package com.merson.mobile.application;

/*application ��ɴ��ȫ�ֵ�  
1������*/

import android.app.Application;

public class MyApplication extends Application {
	
	public static String SERVER_PATH;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		SERVER_PATH = "http://192.168.3.34/MobileManager";
	}

}
