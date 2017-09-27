package cn.edu.gdmec.android.mobileguard.m2theftguard.receiver;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

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

        }
    }
}
