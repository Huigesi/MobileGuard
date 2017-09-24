package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import cn.edu.gdmec.android.mobileguard.m2theftguard.adapter.ContactAdapter;
import cn.edu.gdmec.android.mobileguard.m2theftguard.entity.ContactInfo;

/**
 * Created by 黄煜辉 on 2017/9/20.
 */

public class ContactSelectActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView mListView;
    private ContactAdapter adapter;
    private List<ContactInfo> systemContacts;
    Handler mHandler= new Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case 10:
                    if (systemContacts!=null){
                        adapter=new ContactAdapter(systemContacts,ContactSelectActivity.this);
                    }
            }
        }
    };

    @Override
    public void onClick(View v) {


    }
}
