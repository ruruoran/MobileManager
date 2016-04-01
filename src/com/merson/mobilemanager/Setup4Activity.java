package com.merson.mobilemanager;

import com.merson.mobile.mobilemanager.PhoneSafeActivity;
import com.merson.mobile.receiver.MyDeviceAdminReceiver;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Setup4Activity extends SetupBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup4);
	}
	
	public void previous(View v){
		startActivity(new Intent(this,Setup3Activity.class));
	}
	
	
	public void next(View v){
		startActivity(new Intent(this,PhoneSafeActivity.class));
	}
	
	
	public void active(View v){
		
		Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		
		ComponentName mDeviceAdminSample = new ComponentName(this, MyDeviceAdminReceiver.class);
		
		intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdminSample);
		
		intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "hello kitty");
		
		startActivityForResult(intent,100);
	}
	
	
	
}
