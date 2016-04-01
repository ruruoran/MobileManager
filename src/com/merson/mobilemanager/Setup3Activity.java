package com.merson.mobilemanager;
//设置页面3  可以绑定手机号
import com.merson.mobile.application.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Setup3Activity extends SetupBaseActivity {

	private EditText et_setup3_safenum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup3);
		
		et_setup3_safenum = (EditText) findViewById(R.id.et_setup3_safenum);
				
	}
	
	//获取联系人
/*	//方法1 跳转系统选择联系人的页面去选择
 * public void selectcontact(View v){		
		
		Intent pickContactIntent = new Intent(Intent.ACTION_PICK,Uri.parse("content://contacts"));
		pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
//		startActivity(pickContactIntent);
		startActivityForResult(pickContactIntent, 100);
			
	}*/
	
	
	//第二种方法      自定义listview  装载 系统联系人
	public void selectcontact(View v){
		startActivity(new Intent(this,ContactListActivity.class));
	}
	
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK) {
			if (requestCode == 100) {
				Uri contactUri = data.getData();
				String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
				
				Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
				
				cursor.moveToFirst();
				// Retrieve the phone number from the NUMBER column
				
				int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
				
				String number = cursor.getString(column);
				
				et_setup3_safenum.setText(number);
				
			}
		}else if (resultCode==1000) {
			if (requestCode==200) {
				String number = data.getStringExtra("number");
				et_setup3_safenum.setText(number);
			}
		}
	}
	
	
	//前一步
	public void previous(View v){
		startActivity(new Intent(this,Setup2Activity.class));
	}
	
	//下一步
	public void next(View v){
		final String s = et_setup3_safenum.getText().toString();
		if (!s.isEmpty()) {//安全号码不为空时  即设置了安全号码
			MyApplication.setConfigValue("safenum", s);
			startActivity(new Intent(this,Setup4Activity.class));
		}else{//还未设置安全号码
			Toast.makeText(Setup3Activity.this, "安全号码不能为空！！！", Toast.LENGTH_LONG).show();
		}
	}
	
	
	
	
	
}
