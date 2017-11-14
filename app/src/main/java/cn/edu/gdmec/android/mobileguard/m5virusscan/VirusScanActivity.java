package cn.edu.gdmec.android.mobileguard.m5virusscan;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;


import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.SplashActivity;
import cn.edu.gdmec.android.mobileguard.m1Home.utils.MyUtils;
import cn.edu.gdmec.android.mobileguard.m1Home.utils.VersionUpdateUtils;
import cn.edu.gdmec.android.mobileguard.m4appmanager.AppManagerActivity;
import cn.edu.gdmec.android.mobileguard.m4appmanager.adapter.AppManagerAdapter;

/**
 * Created by 黄煜辉 on 2017/9/20.
 */

public class VirusScanActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mLastTimeTV;
    private TextView mScanVersion;
    private SharedPreferences mSP;
    private String mVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virus_scan);
        mSP=getSharedPreferences("config",MODE_PRIVATE);
        copyDB("antivirus.db");
        initView();

            mVersion = MyUtils.getVersion(getApplicationContext());
            final VersionUpdateUtils versionUpdateUtils = new VersionUpdateUtils(mVersion, VirusScanActivity.this);
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    versionUpdateUtils.getCloudVersion();
                }
            }.start();
        mScanVersion.setText("病毒数据库版本："+mVersion);

    }

    @Override
    protected void onResume() {
        String string = mSP.getString("lastVirusScan", "您还没有查杀病毒！");
        mLastTimeTV.setText(string);
        super.onResume();
       Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                mVersion = MyUtils.getVersion(getApplicationContext());
                final VersionUpdateUtils versionUpdateUtils = new VersionUpdateUtils(mVersion, VirusScanActivity.this);
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        versionUpdateUtils.getCloudVersion();
                    }
                }.start();
                mScanVersion.setText("病毒数据库版本："+mVersion);

            }
        };
    }
    private void copyDB(final String dbname) {
        new Thread(){
            public void run(){
                try{
                    File file=new File(getFilesDir(),dbname);
                    if(file.exists()&&file.length()>0){
                        Log.i("VirusScanActivity","数据库已存在");
                        return;
                    }

                    //File file1 =new File(Environment.DIRECTORY_DOWNLOADS);
                   /* if (formPath.equals){

                    }else {

                    }*/
                    InputStream is=getAssets().open(dbname);
                    FileOutputStream fos=openFileOutput(dbname,MODE_PRIVATE);
                    byte[] buffer=new byte[1024];
                    int len=0;
                    while ((len=is.read(buffer))!=-1){
                        fos.write(buffer,0,len);
                    }
                    is.close();
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            };
        }.start();

    }
    private void initView() {
        findViewById(R.id.rl_titlebar).setBackgroundColor(
                getResources().getColor(R.color.light_blue));
        ImageView mLeftImgv=(ImageView)findViewById(R.id.imgv_leftbtn);
        ((TextView)findViewById(R.id.tv_title)).setText("病毒查杀");
        mLeftImgv.setOnClickListener(this);
        mLeftImgv.setImageResource(R.drawable.back);
        mLastTimeTV=(TextView)findViewById(R.id.tv_lastscantime);
        mScanVersion=(TextView)findViewById(R.id.tv_scan_version);
        findViewById(R.id.rl_allscanvirus).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgv_leftbtn:
                finish();
                break;
            case R.id.rl_allscanvirus:
                startActivity(new Intent(this,VirusScanSpeedActivity.class));
                break;
        }
    }
}
