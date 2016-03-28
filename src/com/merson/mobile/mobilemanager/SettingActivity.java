package com.merson.mobile.mobilemanager;

import com.merson.mobile.application.MyApplication; 
import com.merson.mobilemanager.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class SettingActivity extends ActionBarActivity {
	
	private static final String TAG  = "SettingActivity";
	
	TextView tv_setting_updatestatus;
	CheckBox cb_setting_update;
	
    private SharedPreferences sp;
    SharedPreferences.Editor editor;
    
    
    //����״̬��
  //final ActionBar actionBar = getActionBar();
  // final android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
    //supportActionBar.hide();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		 sp = MyApplication.configsp;
		  editor = sp.edit();
		
		 /*�Զ������ʵ��
		  * 
		  * tv_setting_updatestatus = (TextView) findViewById(R.id.tv_setting_updatestatus);
		 cb_setting_update = (CheckBox) findViewById(R.id.cb_setting_update);
		 
		 
		 if (MyApplication.configsp.getBoolean("autoupdate", true)) {
			 tv_setting_updatestatus.setText("�Զ����¿���");
			 cb_setting_update.setChecked(true);
			
		}else {
			tv_setting_updatestatus.setText("�Զ����¹ر�");
			 cb_setting_update.setChecked(false);
		}
		 
		 
		 //���� checkbox�����¼�
		 
		 cb_setting_update.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//��ȡ����click֮���һ��ѡ��״̬
				boolean checked = cb_setting_update.isChecked();
                Log.i(TAG,checked+"");
                if (checked) {
                	//cb_setting_update.setChecked(true);
					tv_setting_updatestatus.setText("�Զ����¿���");
					Log.i(TAG,checked+"����");
					editor.putBoolean("autoupdate", true);
					editor.commit();
				}else {
                	//cb_setting_update.setChecked(false);
					tv_setting_updatestatus.setText("�Զ����¹ر�");
					Log.i(TAG,checked+"�ر�");
					editor.putBoolean("autoupdate", false);
					editor.commit();
				}
				
			}
		});*/
	}
}
