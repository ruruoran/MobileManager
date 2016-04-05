package com.merson.mobilemanager;

import com.merson.mobile.dao.NumberLocationDao; 

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QueryLocationActivity extends ActionBarActivity {

	private static final String  TAG= "QueryLocationActivity";
	private EditText et_querylocation_num;
	private TextView tv_queryloction_result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_query_location);
		
		et_querylocation_num = (EditText) findViewById(R.id.et_querylocation_num);
		tv_queryloction_result = (TextView) findViewById(R.id.tv_queryloction_result);
		
		et_querylocation_num.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				 Log.i(TAG,"beforeTextChanged");
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int agter) {
				// TODO Auto-generated method stub
				final String numberLocation = NumberLocationDao.getNumberLocation(s.toString(), QueryLocationActivity.this);				
				tv_queryloction_result.setText(numberLocation);
				 Log.i(TAG,"onTextChanged");
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.i(TAG,"afterTextChanged");
				
			}
		} );
		
		
	}
	
	
	public void query(View v){
		final String s = et_querylocation_num.getText().toString();
		final String numberLocation=NumberLocationDao.getNumberLocation(s, this);
		if (numberLocation.isEmpty()) {
			 Toast.makeText(QueryLocationActivity.this, "∫≈¬Î∏Ò Ω”–ŒÛ", Toast.LENGTH_SHORT).show();
		}else {
			tv_queryloction_result.setText(numberLocation);
		}
		//Toast.makeText(QueryLocationActivity.this, numberLocation, Toast.LENGTH_LONG).show();
	}
}
