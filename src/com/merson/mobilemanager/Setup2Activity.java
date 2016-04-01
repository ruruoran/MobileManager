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
import android.widget.Toast;

public class Setup2Activity extends SetupBaseActivity{

	private String TAG = "Setup2Activity";
	@Override
	public  void onCreate(Bundle savedInstanceState) {
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
		//子类实现自己的方法    加上显示效果
		overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
	}
	
	//下一页  即第三页
	public void next(View v){
		String imsi = MyApplication.configsp.getString("imsi", "");
		if (!imsi.isEmpty()) {//imsi不为空   即已经绑定手机号
			
			startActivity(new Intent(this,Setup3Activity.class));
			overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);

		}else {
			Toast.makeText(this, "对不起，没有绑定手机，无法使用本功能！", Toast.LENGTH_LONG).show();
		}
	}
}
