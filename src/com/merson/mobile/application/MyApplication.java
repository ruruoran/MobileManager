package com.merson.mobile.application;

/*application ��ɴ��ȫ�ֵ�  
1������*/

import android.app.Application;
import android.content.SharedPreferences;

public class MyApplication extends Application {
	
	public static String SERVER_PATH;
	
	public static SharedPreferences configsp;
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		SERVER_PATH = "http://192.168.3.34/MobileManager";
		
		 configsp = getSharedPreferences("config",MODE_PRIVATE);
	}

}
