package com.merson.mobile.view;

import com.merson.mobile.application.MyApplication;
import com.merson.mobilemanager.R;

import android.R.attr;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;



public class SettingItem extends RelativeLayout implements View.OnClickListener{

	private SharedPreferences.Editor editor;
	private static final String TAG = "SettingItem";
	
	private  CheckBox cb_setting_update ;
	private  TextView tv_setting_updatestatus;
	private TextView  tv_setting_autoupdate;
	
	 private String itemtitle;
	 private String onstring;
	 private String offstring;
	 private String sp_keyname;

	public SettingItem(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(null);
	}
	
	
	public SettingItem(Context context,AttributeSet attrs) {
		super(context,attrs);
		// TODO Auto-generated constructor stub
		init(attrs);
	}

	//在init里将三个控件加入到当前布局
	private void init(AttributeSet attrs) {
		// TODO Auto-generated method stub
		
		 editor = MyApplication.configsp.edit();
		 
		 View v = View.inflate(getContext(), R.layout.activity_setting_item, null);
		  cb_setting_update = (CheckBox) v.findViewById(R.id.cb_setting_update);
		  tv_setting_updatestatus = (TextView) v.findViewById(R.id.tv_setting_updatestatus);
		  tv_setting_autoupdate = (TextView) v.findViewById(R.id.tv_setting_autoupdate);
		  
		  if (attrs!=null) {
			itemtitle = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "itemtitle");
			onstring = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "onstring");
			offstring = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "offstring");
			sp_keyname = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "sp_keyname");

            //初始化该控件内的子控件
			tv_setting_autoupdate.setText(itemtitle);
			if (MyApplication.configsp.getBoolean(sp_keyname, true)) {
				tv_setting_updatestatus.setText(onstring);//开启  设为onstriong 
				cb_setting_update.setChecked(true);
			}else {
				tv_setting_updatestatus.setText(offstring);
				cb_setting_update.setChecked(false);
			}
			
		}
		  addView(v);
		  setOnClickListener(null);
		
	}
	
	
	@Override
	public void setOnClickListener(OnClickListener l) {
		// TODO Auto-generated method stub
		super.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//这里获取的就是当前的状态
		boolean checked = cb_setting_update.isChecked();
		Log.i(TAG,checked+"");
		
		if (checked) {
			cb_setting_update.setChecked(false);
			tv_setting_updatestatus.setText(offstring);
			Log.i(TAG,checked+"取消");
			
			editor.commit();
		}
		 else {

	            cb_setting_update.setChecked(true);
	            tv_setting_updatestatus.setText(onstring);
	            Log.i(TAG, checked + "开启");
	            editor.putBoolean(sp_keyname, true);
	            editor.commit();

	        }
		
	}
	
	
	
	
	

	
	
	
}
