package cn.edu.gdmec.android.mobileguard.m1Home;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.GridView;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m1Home.adapter.HomeAdapter;

/**
 * Created by 黄煜辉 on 2017/9/12.
 */

public class HomeActivity extends AppCompatActivity{
    private long mExitTime;
    private GridView gv_home;
    private SharedPreferences msharedPreferences;
    private DevicePolicyManager policyManager;
    private ComponentName componentName;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //初始化布局
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        msharedPreferences=getSharedPreferences("config",MODE_PRIVATE);
        //初始化gridView
        gv_home=(GridView)findViewById(R.id.gv_home);
        gv_home.setAdapter(new HomeAdapter(HomeActivity.this));
        //设置条目的点击事件
       /* gv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://手机防盗
                    case 1://通讯卫士
                        startActivity(SecurityPhoneActivity.class);
                        break;
                    case 2://软件管家
                        startActivity(AppManagerActivity.class);
                        break;
                    case 3://病毒查杀
                        startActivity(VirusScanActivity.class);
                        break;
                    case 4://缓存清理
                        startActivity(CacheClearListActivity.class);
                    case 5://进程管理
                        startActivity(ProcessManagerActivity.class);
                        break;
                    case 6://流量统计
                        startActivity(TrafficMonitoringActivity.class);
                        break;
                    case 7://高级工具
                        startActivity(AdvancedToolsActivity.class);
                        break;
                    case 8://设置中心
                        startActivity(SettingsActivity.class);
                }
            }
        });*/
    }
}
