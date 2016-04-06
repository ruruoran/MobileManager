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

	//��ȡsdcard�Ŀ��ÿռ�
	public static long getAvailableSDcardSize(){
		
		File SDcard = Environment.getExternalStorageDirectory();
		StatFs statFs = new StatFs(SDcard.getAbsolutePath());
		
		long availableBlocks;
		long blockSize;
		
		if (Build.VERSION.SDK_INT>=18) {
			availableBlocks = statFs.getAvailableBlocksLong();
			blockSize = statFs.getBlockSizeLong();
			
		}else {//�汾����  ����18api ��
			availableBlocks = statFs.getAvailableBlocks();
			blockSize = statFs.getBlockSize();
		}
		
		return availableBlocks * blockSize;
		
	}
	
	
	//��ȡRom �Ŀ��ÿռ�
	 public static long getAvailableROMSize(){


	        File SDcard=        Environment.getDataDirectory();

	        StatFs statFs = new StatFs(SDcard.getAbsolutePath());

	        long availableBlocks;
	        long blockSize;

	        if (Build.VERSION.SDK_INT>=18){ //��ȡ���ǵ�ǰ�ֻ��İ汾
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
			//Ӧ�����֣�Ӧ��ͼƬ��Ӧ���Ƿ�װ��SDcard��
			// appinfo.packageName;
			 
			 final CharSequence lable = applicationInfo.loadLabel(packageManager);
			 final Drawable icon = applicationInfo.loadIcon(packageManager);
			 boolean isSDCARD;
			 
			 /* if( (appinfo.flags &   appinfo.FLAG_SYSTEM )!=0 ) //=   1 | 4;
	           {
	               //ϵͳӦ��
	               isSDCARD=false;
	           }else
	           {
	               //�û��Լ���װ��Ӧ��
	               isSDCARD=true;
	           }*/

			 

	            if( (applicationInfo.flags &   applicationInfo.FLAG_EXTERNAL_STORAGE )!=0 ) //=   1 | 4;
	            {
	                //SDCARD
	                isSDCARD=true;
	            }else
	            {
	                //��SDcard��װ
	                isSDCARD=false;
	            }
	            
	            AppInfo appInfo = new AppInfo(lable.toString(),icon,isSDCARD);
	            appinfolist.add(appInfo);
			 
		}
		 
		 return appinfolist;
		 
	 }

	
	
	
}
