package cn.edu.gdmec.android.mobileguard.m2theftguard.receiver;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;

import cn.edu.gdmec.android.mobileguard.m2theftguard.service.GPSLocationService;

/**
 * Created by 黄煜辉 on 2017/9/20.
 */

public class SmsLostFindReciver extends BroadcastReceiver{
    private static final String TAG=SmsLostFindReciver.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private ComponentName componentName;

    @Override
    public void onReceive(Context context, Intent intent) {
        sharedPreferences = context.getSharedPreferences("config", Activity.MODE_PRIVATE);
        boolean protecting=sharedPreferences.getBoolean("protecting",true);
        if (protecting){
            Object[] objs=(Object[]) intent.getExtras().get("pdus");
            DevicePolicyManager dpm = (DevicePolicyManager)context.getSystemService(Context.DEVICE_POLICY_SERVICE);
            for (Object obj : objs){
                SmsMessage smsMessage= SmsMessage.createFromPdu((byte[]) obj);
                String sender=smsMessage.getOriginatingAddress();
                if(sender.startsWith("+86")){
                    sender=sender.substring(3, sender.length());
                }
                String body=smsMessage.getMessageBody();
                String safephone=sharedPreferences.getString("safephone",null);
                if (!TextUtils.isEmpty(safephone)&sender.equals(safephone)){
                    if (("#*location*#".equals(body))){
                        Log.i(TAG,"返回位置信息.");
                        Intent service=new Intent(context, GPSLocationService.class);
                        context.startService(service);
                    }
                }
           }
        }
    }
}
