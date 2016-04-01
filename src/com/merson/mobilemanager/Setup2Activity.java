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
				//��SIM����ҵ���߼�
				//����ж�����sim����һ��
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
	
	//��һҳ ����һ��
	public void previous(View v){
		startActivity(new Intent(this,Setup1Activity.class));
		//����ʵ���Լ��ķ���    ������ʾЧ��
		overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
	}
	
	//��һҳ  ������ҳ
	public void next(View v){
		String imsi = MyApplication.configsp.getString("imsi", "");
		if (!imsi.isEmpty()) {//imsi��Ϊ��   ���Ѿ����ֻ���
			
			startActivity(new Intent(this,Setup3Activity.class));
			overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);

		}else {
			Toast.makeText(this, "�Բ���û�а��ֻ����޷�ʹ�ñ����ܣ�", Toast.LENGTH_LONG).show();
		}
	}
}
