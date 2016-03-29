package com.merson.mobilemanager;

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

public class Setup3Activity extends Activity {

	private EditText et_setup3_safenum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup3);
		
		et_setup3_safenum = (EditText) findViewById(R.id.et_setup3_safenum);
				
	}
	
	//��ȡ��ϵ��
	public void selectcontact(View v){
		//����1 ��תϵͳѡ����ϵ�˵�ҳ��ȥѡ��
		Intent pickContactIntent = new Intent(Intent.ACTION_PICK,Uri.parse("content://contacts"));
		pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
//		startActivity(pickContactIntent);
		startActivityForResult(pickContactIntent, 100);
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
		}
	}
	
	
	//ǰһ��
	public void previous(View v){
		startActivity(new Intent(this,Setup2Activity.class));
	}
	
	//��һ��
	public void next(View v){
		final String s = et_setup3_safenum.getText().toString();
		if (!s.isEmpty()) {//��ȫ���벻Ϊ��ʱ  �������˰�ȫ����
			MyApplication.setConfigValue("safenum", s);
//			startActivity(new Intent(this,Setup4Activity.class));
		}else{//��δ���ð�ȫ����
			Toast.makeText(Setup3Activity.this, "��ȫ���벻��Ϊ�գ�����", Toast.LENGTH_LONG).show();
		}
	}
	
	
	
	
	
}