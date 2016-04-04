package com.merson.mobilemanager;

import com.merson.mobile.dao.NumberLocationDao;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QueryLocationActivity extends ActionBarActivity {

	private EditText et_querylocation_num;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_query_location);
		
		et_querylocation_num = (EditText) findViewById(R.id.et_querylocation_num);
		
		
	}
	
	
	public void query(View v){
		final String s = et_querylocation_num.getText().toString();
		final String numberLocation=NumberLocationDao.getNumberLocation(s, this);
		Toast.makeText(QueryLocationActivity.this, numberLocation, Toast.LENGTH_LONG).show();
	}
}
