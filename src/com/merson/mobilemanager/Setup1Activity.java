package com.merson.mobilemanager;

import android.app.Activity;  
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Setup1Activity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup1);
	}
	
	
	//第一页  只有一个next  下一页的设置    跳往第二设置页
	public void next(View v){
		startActivity(new Intent(this,Setup2Activity.class));
	}
	
}
