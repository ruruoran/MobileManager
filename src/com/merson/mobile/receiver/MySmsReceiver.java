package com.merson.mobile.receiver;

import com.merson.mobile.application.MyApplication;
import com.merson.mobilemanager.R;

import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.util.Log;

public class MySmsReceiver extends BroadcastReceiver {

	private static final String TAG = "MySmsReceiver" ;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Log.i(TAG, "onReceiver");
		
		Object[] objs = (Object[]) intent.getExtras().get("pdus");
		
		for (Object object : objs) {
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) object);
			
			String body = smsMessage.getMessageBody();
			
			String sender = smsMessage.getOriginatingAddress();
			
			Log.i(TAG,"onReceive " +body);
			
			if (body.equals("*#alarm#*")) {
				
				playalarm(context);
				
			}else if (body.equals("*#location#*")){
				                
				getlocation(context);
				             
			}else if (body.equals("*#wipedata#*")){
				              
				wipedata(context);
				            
			}else if (body.equals("*#lockscreen#*")){
				             
				lockscreen(context);
				            
			}
		}

	}
	
	//�������ԱȨ��
	private void lockscreen(Context ctx){
		Log.i(TAG,"lockscreen");
		//ʵ������
		DevicePolicyManager mDPM =  (DevicePolicyManager) ctx.getSystemService(Context.DEVICE_POLICY_SERVICE);
		
		mDPM.lockNow();
		
		mDPM.resetPassword("123", 0);
	}
	
	private void wipedata(Context ctx){
		Log.i(TAG,"wipedata");
		//���ݲ���
		DevicePolicyManager mDPM = (DevicePolicyManager) ctx.getSystemService(Context.DEVICE_POLICY_SERVICE);
		
		mDPM.wipeData(0);
	}
	
	private void getlocation(Context ctx){
		Log.i(TAG,"getlocation");
		
		ctx.startService(new Intent(ctx,MyUpdateLocationService.class));
		
		final String longitude = MyApplication.configsp.getString("longitude", "");
		
		final String latitude = MyApplication.configsp.getString("latitude", "");
		
		Log.i("getlocation",longitude+"--"+latitude);
		 //ͨ��smsManager ��λ����Ϣ������ȫ���롣
		
	}
	
	//���ž�ʾ����
	 private void playalarm(Context ctx) {
	        Log.i(TAG,"playalarm");
 
	        MediaPlayer mediaPlayer =   MediaPlayer.create(ctx, R.raw.alarm);
	        //��Ӳ����ʼ������Ƶ
	        mediaPlayer.setLooping(true);
	        mediaPlayer.start();

	}

}
