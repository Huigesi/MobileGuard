package cn.edu.gdmec.android.mobileguard.m3communicationguard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m3communicationguard.adapter.BlackContactAdapter;
import cn.edu.gdmec.android.mobileguard.m3communicationguard.db.dao.BlackNumberDao;
import cn.edu.gdmec.android.mobileguard.m3communicationguard.entity.BlackContactInfo;

/**
 * Created by 黄煜辉 on 2017/9/20.
 */

public class SecurityPhonectivity extends AppCompatActivity implements View.OnClickListener{
    private FrameLayout mHaveBlackNumber;
    private FrameLayout mNoBlackNumber;
    private BlackNumberDao dao;
    private ListView mListView;
    private int pagenumber=0;
    private int pagesize=15;
    private int totalNumber;
    private List<BlackContactInfo> pageBlackNumber=new ArrayList<BlackContactInfo>();
    private BlackContactAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_security_phone);
        initView();
        fillData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //if(totalNumber!=dao)
    }

    private void fillData() {
    }

    private void initView() {

    }

    @Override
    public void onClick(View v) {

    }
}
