package com.merson.mobile.receiver;

import com.merson.mobile.dao.NumberLocationDao;
import com.merson.mobilemanager.R;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class MyNumberLocationService extends Service {
	
	private static  final String  TAG= "MyNumberLocationService";
	private WindowManager mWM;
	private View v;
	
	

	public MyNumberLocationService() {
		
	}


	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
//		return null;
		throw new UnsupportedOperationException("not yet  implemented");
	}

	
	

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		final TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		
		telephonyManager.listen(new MyPhoneStateListener(), PhoneStateListener.LISTEN_CALL_STATE);
		
		Log.i(TAG,"oncreate");
			
		super.onCreate();
	}
	
	
	//监听电话通话状态
	class MyPhoneStateListener extends PhoneStateListener{

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				hideLocationView();
				break;

			case TelephonyManager.CALL_STATE_RINGING:
				String location = NumberLocationDao.getNumberLocation(incomingNumber, MyNumberLocationService.this);
				Log.i(TAG,location);
				//第二步 把号码显示出来
				Toast.makeText(MyNumberLocationService.this, location, Toast.LENGTH_LONG).show();
				showLocationView(location);
				break;
				
			case TelephonyManager.CALL_STATE_OFFHOOK:
				break;
			}
		}
		
	}

	//这里使用的是自定义的toast风格  
	private void showLocationView(String location){
		
		LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflate.inflate(R.layout.mynumberlocation,null);
		
		TextView message = (TextView) v.findViewById(R.id.message);
		message.setText(location);
		
		
		mWM = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
		
		layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
		layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
		//使得窗口支持透明度
		layoutParams.format = PixelFormat.TRANSLUCENT;
		
		layoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
		layoutParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
		
		mWM.addView(v, layoutParams);
		
	}
	
	//隐藏显示框  （否则toast会一直在）
	private void hideLocationView(){
		if (mWM!=null) {
			mWM.removeView(v);
		}
	}


	
}
