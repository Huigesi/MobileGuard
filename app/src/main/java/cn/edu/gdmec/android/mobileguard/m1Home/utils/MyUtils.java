package cn.edu.gdmec.android.mobileguard.m1Home.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 黄煜辉 on 2017/9/12.
 */

public class MyUtils {
  /*  public static String getVersion(Context context){
        PackageManager packageManager = context.getPackageManager();
        try{
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(),0);
            return packageInfo.versionName;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return "";
        }
    }*/
    private static String dbname;
    public static String getVersion(Context context){
        String desc = null;
        PackageManager packageManager = context.getPackageManager();
            dbname = "/data/data/"+context.getPackageName()+"/files/antivirus.db";
            SQLiteDatabase db = SQLiteDatabase.openDatabase(
                    dbname, null,
                    SQLiteDatabase.OPEN_READONLY);
            //select * from version

            Cursor cursor = db.rawQuery("select * from version", null);
        if (cursor.moveToNext()){
            desc = cursor.getString(0)+".";
            desc +=cursor.getString(1)+".";
            desc +=cursor.getString(2);

        }
            cursor.close();
            db.close();

            return desc;
    }
}
