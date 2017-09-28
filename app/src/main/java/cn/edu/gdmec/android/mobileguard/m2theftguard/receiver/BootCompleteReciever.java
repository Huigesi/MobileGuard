package cn.edu.gdmec.android.mobileguard.m2theftguard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.edu.gdmec.android.mobileguard.App;


/**
 * Created by 黄煜辉 on 2017/9/20.
 */

public class BootCompleteReciever extends BroadcastReceiver{
    private static final String TAG=BootCompleteReciever.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        //((App) context.getApplicationContext()).correctSIM();
    }
}
