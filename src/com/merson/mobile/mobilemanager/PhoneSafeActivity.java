package com.merson.mobile.mobilemanager;


import com.merson.mobile.application.MyApplication;
import com.merson.mobilemanager.R;
import com.merson.mobilemanager.Setup1Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



//������������ҳ��
//�ж��û��Ƿ��Ѿ����ù������û�У������һ��������ҳ��
public class PhoneSafeActivity extends ActionBarActivity {
	
	TextView tv_phonesafe_safenum;
	ImageView iv_phonesafe_enalbe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_safe);
		
	    tv_phonesafe_safenum = (TextView) findViewById(R.id.tv_phonesafe_safenum);
		iv_phonesafe_enalbe = (ImageView) findViewById(R.id.iv_phonesafe_enalbe);
		
		 //����ж��Ƿ��Ѿ����ù���ͨ�������򵼻�����һ����sim����Ϣ���������Ϣ��������Ϊ�Ѿ����ù�
		
		//���xml��û�и������Ĭ��ֵ��
		String safenum = MyApplication.configsp.getString("safenum", "");
		//����ļ���û�иİ�ȫ����ļ�¼    ����תȥ����
		if (safenum.isEmpty()) {
			startActivity(new Intent(this,Setup1Activity.class));
		}else {
			//��ʾ��ȫ����
			tv_phonesafe_safenum.setText(safenum);
			
			//��ʾ�Ƿ��ѿ���������
			boolean flag = MyApplication.configsp.getBoolean("anti_theif", true);
			
			if (flag) {//flag��Ϊtrue   ��flagΪ��ʱ  ����   ��ͼ���ʾ
				iv_phonesafe_enalbe.setImageResource(R.drawable.lock);
			}else {
				iv_phonesafe_enalbe.setImageResource(R.drawable.unlock);
			}
		}
	}
	
	
	public void resetup(View v){
		startActivity(new Intent(this,Setup1Activity.class));
		
	}
	
}
