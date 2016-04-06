package com.merson.mobile.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.pm.ServiceInfo;

public class RunningServiceUtils {
	public static boolean isRunning(Context ctx,String servicename){
		//判断当前的service是否在运行
		//ActivityManager ams
		ActivityManager activityManager = (ActivityManager) ctx.getSystemService(ctx.ACTIVITY_SERVICE);
		
		final List<RunningServiceInfo> runningServices = activityManager.getRunningServices(100);
		
		for (RunningServiceInfo runningServiceInfo : runningServices) {
			if (servicename.equals(runningServiceInfo.service.getClassName())) {
				return true;
			}
		}
		return false;
	}
}
