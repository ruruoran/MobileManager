package com.merson.mobile.mobilemanager;


import com.merson.mobilemanager.R;
import com.merson.mobilemanager.Setup1Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;



//������������ҳ��
//�ж��û��Ƿ��Ѿ����ù������û�У������һ��������ҳ��
public class PhoneSafeActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_safe);
		
		 //����ж��Ƿ��Ѿ����ù���ͨ�������򵼻�����һ����sim����Ϣ���������Ϣ��������Ϊ�Ѿ����ù�
		startActivity(new Intent(this,Setup1Activity.class));
	}
}
