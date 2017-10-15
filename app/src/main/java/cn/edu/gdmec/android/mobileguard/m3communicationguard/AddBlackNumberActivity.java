package cn.edu.gdmec.android.mobileguard.m3communicationguard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m3communicationguard.db.dao.BlackNumberDao;
import cn.edu.gdmec.android.mobileguard.m3communicationguard.entity.BlackContactInfo;

/**
 * Created by 黄煜辉 on 2017/9/20.
 */

public class AddBlackNumberActivity {/*extends AppCompatActivity implements View.OnClickListener{
    private CheckBox mSmsCB;
    private CheckBox mTelCB;
    private EditText mNumET;
    private EditText mNameET;
    private BlackNumberDao dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_black_number);
        dao=new BlackNumberDao(this);
        initView();
    }

    private void initView() {
        findViewById(R.id.rl_titlebar).setBackgroundColor(getResources().getColor(R.color.bright_purple));
        ((TextView)findViewById(R.id.tv_title)).setText("添加黑名单");
        ImageView mLeftImgv=(ImageView)findViewById(R.id.imgv_leftbtn);
        mLeftImgv.setOnClickListener(this);
        mLeftImgv.setImageResource(R.drawable.back);
        mSmsCB=(CheckBox)findViewById(R.id.cb_blacknumber_sms);
        mTelCB=(CheckBox)findViewById(R.id.cb_blacknumber_tel);
        mNumET=(EditText)findViewById(R.id.et_blackname);
        mNameET=(EditText)findViewById(R.id.et_blackname);
        findViewById(R.id.add_blacknum_btn).setOnClickListener(this);
        findViewById(R.id.add_fromcontact_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgv_leftbtn:
                finish();
                break;
            case R.id.add_blacknum_btn:
                String number=mNameET.getText().toString().trim();
                String name=mNameET.getText().toString().trim();
                if (TextUtils.isEmpty(number)||TextUtils.isEmpty(name)){
                    Toast.makeText(this,"电话号码和手机不能为空！",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    BlackContactInfo blackContactInfo=new BlackContactInfo();
                    blackContactInfo.phoneNumber=number;
                    blackContactInfo.contactName=name;
                    if (mSmsCB.isChecked()& mTelCB.isChecked()){

                    }
                }
        }

    }*/
}
