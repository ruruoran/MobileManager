package com.merson.mobile.receiver;

import com.merson.mobile.application.MyApplication;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

public class MyUpdateLocationService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		locationManager.requestLocationUpdates("gps", 0, 0, new LocationListener() {
			
			@Override
			public void onStatusChanged(String pro, int arg1, Bundle arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				final double longitude = location.getLongitude();
				final double latitude = location.getLatitude();
				
				MyApplication.setConfigValue("longitude", longitude+"");
				MyApplication.setConfigValue("latitude", longitude+"");

			}
		});
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}
	

}
