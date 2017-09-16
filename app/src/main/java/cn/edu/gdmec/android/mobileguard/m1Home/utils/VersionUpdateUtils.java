package cn.edu.gdmec.android.mobileguard.m1Home.utils;

import android.app.Activity;

import junit.runner.Version;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.edu.gdmec.android.mobileguard.m1Home.entity.VersionEntity;

/**
 * Created by 黄煜辉 on 2017/9/12.
 */

public class VersionUpdateUtils {
    private String mVersion;
    private Activity context;
    private VersionEntity versionEntity;
    public VersionUpdateUtils(String mVersion,Activity context){
        this.mVersion=mVersion;
        this.context=context;
    }
    public void getCloudVersion(){
        try{
            HttpClient httpClient=new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(httpClient.getParams(),5000);
            HttpConnectionParams.setSoTimeout(httpClient.getParams(),5000);
            HttpGet httpGet =new HttpGet("http://android2017.duapp.com/updateinfo.html");
            HttpResponse execute =httpClient.execute(httpGet);
            if (execute.getStatusLine().getStatusCode()==200){
                HttpEntity httpEntity=execute.getEntity();
                String result= EntityUtils.toString(httpEntity,"utf-8");
                JSONObject jsonObject=new JSONObject(result);
                versionEntity =new VersionEntity();
                versionEntity.versioncode=jsonObject.getString("code");
                versionEntity.description=jsonObject.getString("des");
                versionEntity.apkurl=jsonObject.getString("apkurl");
                if (!mVersion.equals(versionEntity.versioncode)){
                    System.out.println(versionEntity.description);
                    DownLoadUtils downLoadUtils=new DownLoadUtils();
                    downLoadUtils.downdloadApk(versionEntity.apkurl,"mobileguard,apk",context);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
