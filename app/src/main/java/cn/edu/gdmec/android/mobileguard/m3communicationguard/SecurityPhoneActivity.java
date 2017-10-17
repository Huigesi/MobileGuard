package cn.edu.gdmec.android.mobileguard.m3communicationguard;

/**
 * Created by 黄煜辉 on 2017/9/20.
 */

public class SecurityPhoneActivity {
/*extends AppCompatActivity implements View.OnClickListener{
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
        if(dao.getTotalNumber()>0){
            mHaveBlackNumber.setVisibility(View.VISIBLE);
            mNoBlackNumber.setVisibility(View.GONE);
        }else {
            mHaveBlackNumber.setVisibility(View.GONE);
            mNoBlackNumber.setVisibility(View.VISIBLE);
        }
        pagenumber=0;
        pageBlackNumber.clear();
        pageBlackNumber.addAll(dao.getPageBlackNumber(pagenumber,pagesize));
        if (adapter!=null){
            adapter.notifyDataSetChanged();
        }
        //if(totalNumber!=dao)
    }

    private void fillData() {
        dao=new BlackNumberDao(SecurityPhonectivity.this);
        totalNumber=dao.getTotalNumber();
        if(totalNumber==0){
            mHaveBlackNumber.setVisibility(View.GONE);
            mNoBlackNumber.setVisibility(View.VISIBLE);
        }else if (totalNumber>0){
            mHaveBlackNumber.setVisibility(View.VISIBLE);
            mNoBlackNumber.setVisibility(View.GONE);
            pagenumber=0;
            if (pageBlackNumber.size()>0){
                pageBlackNumber.clear();
            }
            pageBlackNumber.addAll(dao.getPageBlackNumber(pagenumber,pagesize));
            if (adapter==null){
                adapter=new BlackContactAdapter(pageBlackNumber,SecurityPhonectivity.this);
                adapter.setCallBack(new BlackContactAdapter.BlackContactCallback() {
                    @Override
                    public void DataSizeChanged() {
                        fillData();
                    }
                });
                mListView.setAdapter(adapter);
            }else {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void initView() {
        findViewById(R.id.rl_titlebar).setBackgroundColor(getResources().getColor(R.color.bright_purple));
        ImageView mLeftImgv=(ImageView)findViewById(R.id.imgv_leftbtn);
        ((TextView)findViewById(R.id.tv_title)).setText("通讯卫士");
        mLeftImgv.setOnClickListener(this);
        mLeftImgv.setImageResource(R.drawable.back);
        mHaveBlackNumber=(FrameLayout)findViewById(R.id.fl_haveblacknumber);
        mNoBlackNumber=(FrameLayout)findViewById(R.id.fl_noblacknumber);
        findViewById(R.id.btn_addblacknumber).setOnClickListener(this);
        mListView=(ListView)findViewById(R.id.lv_blacknumbers);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        int lastVisiblePostion=mListView.getLastVisiblePosition();
                        if (lastVisiblePostion==pageBlackNumber.size()-1){
                            pagenumber++;
                            if (pagenumber*pagesize>=totalNumber){
                                Toast.makeText(SecurityPhonectivity.this,"没有更多数据",Toast.LENGTH_LONG).show();
                            }else{
                                pageBlackNumber.addAll(dao.getPageBlackNumber(pagenumber,pagesize));
                                adapter.notifyDataSetChanged();
                            }
                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.imgv_leftbtn:
                 finish();
                 break;
             case R.id.btn_addblacknumber:
                 startActivity(new Intent(this,AddBlackNumberActivity.class));
                 break;
         }
    }
}
*/
}