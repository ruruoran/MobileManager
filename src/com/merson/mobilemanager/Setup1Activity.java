package com.merson.mobilemanager;

import android.app.Activity;  
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Setup1Activity extends SetupBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup1);
	}
	
	
	
	//��һҳ  ֻ��һ��next  ��һҳ������    �����ڶ�����ҳ
	public void next(View v){
		startActivity(new Intent(this,Setup2Activity.class));
	}
	
	//�̳г�����Ҫʵ�������еķ���  �������������Ϊ��
	@Override
	public void previous(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
