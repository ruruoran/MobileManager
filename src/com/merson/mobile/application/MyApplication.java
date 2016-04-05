package com.merson.mobile.application;

/*application 里可存放全局的  
1次增加*/

import com.merson.mobile.receiver.MyNumberLocationService;

import android.app.Application; 
import android.content.Intent;
import android.content.SharedPreferences;

public class MyApplication extends Application {
	
	public static String SERVER_PATH;
	
	public static SharedPreferences configsp;
	
	public static SharedPreferences .Editor editor;
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		SERVER_PATH = "http://192.168.3.34/MobileManager";
		
		 configsp = getSharedPreferences("config",MODE_PRIVATE);
		 
		 editor = configsp.edit();
		 
		 startService(new Intent(this, MyNumberLocationService.class));
		 
	}
	
	public static void setConfigValue(String key , String value){
		editor.putString(key, value);
		editor.commit();
	}
	
	public static void setConfigValue(String key , int value){
		editor.putInt(key, value);
		editor.commit();
	}
	
	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		stopService(new Intent(this, MyNumberLocationService.class));
	}

}
