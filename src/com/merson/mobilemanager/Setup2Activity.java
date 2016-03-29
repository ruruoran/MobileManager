package com.merson.mobilemanager;

import com.merson.mobile.application.MyApplication;
import com.merson.mobile.view.SettingItem; 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Setup2Activity extends ActionBarActivity {

	private String TAG = "Setup2Activity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup2);
		
		SettingItem si_setup2_bindsim = (SettingItem) findViewById(R.id.si_setup2_bindsim);
		
		si_setup2_bindsim.setMyOnclickListener(new SettingItem.MyOnclickListen() {
			
			@Override
			public void myCheckOnclick() {
				// TODO Auto-generated method stub
				Log.i(TAG, "myonclick executed");
				//绑定SIM卡的业务逻辑
				//如何判断两个sim卡不一样
				TelephonyManager mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
				String imsi = mTelephonyManager.getSimSerialNumber();//imsi
				 //Toast.makeText(Setup2Activity.this, ims, Toast.LENGTH_SHORT).show();
				MyApplication.setConfigValue("imsi", imsi);
			}
			
			@Override
			public void myCancleOnclick() {
				// TODO Auto-generated method stub
				MyApplication.setConfigValue("imsi", "");

			}
		});
	}
	
	//上一页 即第一步
	public void previous(View v){
		startActivity(new Intent(this,Setup1Activity.class));
	}
	
	//下一页  即第三页
	public void next(View v){
		startActivity(new Intent(this,Setup3Activity.class));
	}
}
