package cn.edu.gdmec.android.mobileguard.m1Home.utils;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.nfc.Tag;
import android.util.Log;
import android.webkit.MimeTypeMap;

import java.util.regex.Pattern;

/**
 * Created by 黄煜辉 on 2017/9/12.
 */

public class DownLoadUtils {
    public void downloadApk(String url, String targetFile, Context context){
        DownloadManager.Request request =new DownloadManager.Request(Uri.parse(url));
        request.setAllowedOverRoaming(false);
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String mimeString =mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url));
        request.setMimeType(mimeString);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setVisibleInDownloadsUi(true);

        request.setDestinationInExternalPublicDir("/data/data/"+context.getPackageName()+"/files/antivirus.db",targetFile);

        DownloadManager downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        long mTaskid = downloadManager.enqueue(request);


    }
}
