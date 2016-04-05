package com.merson.mobile.receiver;

import com.merson.mobile.application.MyApplication;
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
import android.view.Gravity;
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
	
	
	//�����绰ͨ��״̬
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
				//�ڶ��� �Ѻ�����ʾ����
				Toast.makeText(MyNumberLocationService.this, location, Toast.LENGTH_LONG).show();
				showLocationView(location);
				break;
				
			case TelephonyManager.CALL_STATE_OFFHOOK:
				break;
			}
		}
		
	}

	//����ʹ�õ����Զ����toast���  
	private void showLocationView(String location){
		
		LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflate.inflate(R.layout.mynumberlocation,null);
		 v.setBackgroundResource(R.drawable.call_locate_blue);
		
		TextView message = (TextView) v.findViewById(R.id.message);
		message.setText(location);
		
		
		mWM = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
		
		layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
		layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
		//ʹ�ô���֧��͸����
		layoutParams.format = PixelFormat.TRANSLUCENT;
		
		layoutParams.gravity = Gravity.LEFT|Gravity.TOP;
		/*layoutParams.x = 200;
		layoutParams.y = 300;
		*/
		
		layoutParams.x = MyApplication.configsp.getInt("toastx", 200);
		layoutParams.y = MyApplication.configsp.getInt("toasty", 300)+50;
		
		layoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
		layoutParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
		
		mWM.addView(v, layoutParams);
		
	}
	
	//������ʾ��  ������toast��һֱ�ڣ�
	private void hideLocationView(){
		if (mWM!=null) {
			mWM.removeView(v);
		}
	}


	
}
