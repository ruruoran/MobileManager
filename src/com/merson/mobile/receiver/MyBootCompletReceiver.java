package com.merson.mobile.receiver;
	//设置监听器   当换卡时发出警报

import com.merson.mobile.application.MyApplication;

import android.content.BroadcastReceiver; 
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsManager;
import android.util.Log;

public class MyBootCompletReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i("MyBootCompletReceiver", intent.getAction());
		
		final boolean  anti_theif = MyApplication.configsp.getBoolean("anti_theif", true);

		if (anti_theif) {//如果用户开启了防盗功能   则检查是否换卡
			
			
			//取得保存的旧的sim卡号
			final String imsi_saved = MyApplication.configsp.getString("imsi", "");
			
			//如何判断两个sim卡不一样
			TelephonyManager mTelephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
			//渠道当前手机里的sim卡 IMSI号
			String imsi_current = mTelephonyManager.getSimSerialNumber();
			
			Log.i("MyBootCompleteReceiver", imsi_current + "----" + imsi_saved);
			 if (!imsi_saved.equals(imsi_current)) {
				 //取得安全手机号
				 final String safenum = MyApplication.configsp.getString("safenum", "");
				SmsManager smsManager = SmsManager.getDefault();
				//发送警告短信
				smsManager.sendTextMessage("1383838438", null, "watch out ！！你的手机换卡了", null, null);
			}
		}
		
	}

}
