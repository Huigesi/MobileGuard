package cn.edu.gdmec.android.mobileguard.m1Home.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;

/**
 * Created by 黄煜辉 on 2017/9/12.
 */

public class DownLoadUtils {
    public void downdloadApk(String url, String targetFile, Context context){
        DownloadManager.Request request =new DownloadManager.Request(Uri.parse(url));
        request.setAllowedOverRoaming(false);
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

    }
}
