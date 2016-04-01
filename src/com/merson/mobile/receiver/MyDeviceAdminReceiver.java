package com.merson.mobile.receiver;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyDeviceAdminReceiver extends DeviceAdminReceiver {

	void showToast (Context context, String msg){
		String status = msg;
		Toast.makeText(context, status, Toast.LENGTH_LONG).show();
	}
	
	
	@Override
	public void onDisabled(Context context, Intent intent) {
		// TODO Auto-generated method stub
		/*super.onDisabled(context, intent);*/
		showToast(context, "admin_receiver_status_disabled");
	}

	@Override
	public void onEnabled(Context context, Intent intent) {
		// TODO Auto-generated method stub
//		super.onEnabled(context, intent);
		showToast(context, "admin_receiver_status_enabled");
	}

	
}
