package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;


import cn.edu.gdmec.android.mobileguard.m2theftguard.adapter.ContactAdapter;
import cn.edu.gdmec.android.mobileguard.m2theftguard.entity.ContactInfo;

/**
 * Created by 黄煜辉 on 2017/9/20.
 */

public class LostFindActivity extends Activity implements View.OnClickListener{
    private TextView mSafePhoneTV;
    private RelativeLayout mInterSetupRL;
    private SharedPreferences msharedPrefences;
    private ToggleButton mToggleButton;
    private TextView mProtectStatusTV;


    @Override
    public void onClick(View v) {

    }
}
