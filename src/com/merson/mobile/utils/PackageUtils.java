package com.merson.mobile.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.merson.mobile.bean.AppInfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

public class PackageUtils {

	//获取sdcard的可用空间
	public static long getAvailableSDcardSize(){
		
		File SDcard = Environment.getExternalStorageDirectory();
		StatFs statFs = new StatFs(SDcard.getAbsolutePath());
		
		long availableBlocks;
		long blockSize;
		
		if (Build.VERSION.SDK_INT>=18) {
			availableBlocks = statFs.getAvailableBlocksLong();
			blockSize = statFs.getBlockSizeLong();
			
		}else {//版本兼容  低于18api 的
			availableBlocks = statFs.getAvailableBlocks();
			blockSize = statFs.getBlockSize();
		}
		
		return availableBlocks * blockSize;
		
	}
	
	
	//获取Rom 的可用空间
	 public static long getAvailableROMSize(){


	        File SDcard=        Environment.getDataDirectory();

	        StatFs statFs = new StatFs(SDcard.getAbsolutePath());

	        long availableBlocks;
	        long blockSize;

	        if (Build.VERSION.SDK_INT>=18){ //获取的是当前手机的版本
	            availableBlocks =   statFs.getAvailableBlocksLong();
	            blockSize =  statFs.getBlockSizeLong();
	        }else{
	            availableBlocks =   statFs.getAvailableBlocks();
	            blockSize =   statFs.getBlockSize();
	        }



	        return  availableBlocks*blockSize;
	    }
	 
	 
	 public static List<AppInfo> getAllAppInfo(Context ctx){

//       ctx.getSystemService(ctx.ACTIVITY_SERVICE)
		 List<AppInfo> appinfolist = new ArrayList<AppInfo>();
		 
		 final PackageManager packageManager = ctx.getPackageManager();
		 final List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
		 
		 for (ApplicationInfo applicationInfo : installedApplications) {
			//应用名字，应用图片，应用是否安装在SDcard上
			// appinfo.packageName;
			 
			 final CharSequence lable = applicationInfo.loadLabel(packageManager);
			 final Drawable icon = applicationInfo.loadIcon(packageManager);
			 boolean isSDCARD;
			 
			 /* if( (appinfo.flags &   appinfo.FLAG_SYSTEM )!=0 ) //=   1 | 4;
	           {
	               //系统应用
	               isSDCARD=false;
	           }else
	           {
	               //用户自己安装的应用
	               isSDCARD=true;
	           }*/

			 

	            if( (applicationInfo.flags &   applicationInfo.FLAG_EXTERNAL_STORAGE )!=0 ) //=   1 | 4;
	            {
	                //SDCARD
	                isSDCARD=true;
	            }else
	            {
	                //非SDcard安装
	                isSDCARD=false;
	            }
	            
	            AppInfo appInfo = new AppInfo(lable.toString(),icon,isSDCARD);
	            appinfolist.add(appInfo);
			 
		}
		 
		 return appinfolist;
		 
	 }

	
	
	
}
