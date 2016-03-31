package com.merson.mobile.receiver;
	//���ü�����   ������ʱ��������

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

		if (anti_theif) {//����û������˷�������   �����Ƿ񻻿�
			
			
			//ȡ�ñ���ľɵ�sim����
			final String imsi_saved = MyApplication.configsp.getString("imsi", "");
			
			//����ж�����sim����һ��
			TelephonyManager mTelephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
			//������ǰ�ֻ����sim�� IMSI��
			String imsi_current = mTelephonyManager.getSimSerialNumber();
			
			Log.i("MyBootCompleteReceiver", imsi_current + "----" + imsi_saved);
			 if (!imsi_saved.equals(imsi_current)) {
				 //ȡ�ð�ȫ�ֻ���
				 final String safenum = MyApplication.configsp.getString("safenum", "");
				SmsManager smsManager = SmsManager.getDefault();
				//���;������
				smsManager.sendTextMessage("1383838438", null, "watch out ��������ֻ�������", null, null);
			}
		}
		
	}

}
