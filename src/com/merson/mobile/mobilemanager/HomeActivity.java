package com.merson.mobile.mobilemanager;

import com.merson.mobile.application.MyApplication;
import com.merson.mobilemanager.PhoneSafeActivity;
import com.merson.mobilemanager.R; 
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends ActionBarActivity {

	private TextView tv_home_welcome;
	private GridView gv_home_content;
	
	private final int CONTENT_NUM = 9;
	private String[] titles = {"�ֻ�����","ͨѶ��ʿ","�������",
			 "���̹���","����ͳ��","�ֻ�ɱ��",
			 "��������","�߼�����","��������"};
	
	//ʢװ��Ƭ
	private int[] iconarray = {R.drawable.safe,R.drawable.callmsgsafe,R.drawable.app
			 ,    R.drawable.taskmanager,R.drawable.netmanager,R.drawable.trojan,
			    R.drawable.sysoptimize,R.drawable.atools,R.drawable.settings};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		//final ActionBar actionBar = getActionBar();
		  final android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
	      supportActionBar.hide();
		
		 tv_home_welcome = (TextView) findViewById(R.id.tv_home_welcome);
		 gv_home_content = (GridView) findViewById(R.id.gv_home_content);
		 
		 
		 tv_home_welcome.setText("��ӭ��,���û�,���ǵ�Ӧ�ÿ��Ա������ֻ��İ�ȫ��");
		//����2,�ÿؼ�����ѡ��״̬
		//tv_home_welcome.setSelected(true);
		 
		 //��ʼ���Ź���
		 //������ListView
		 gv_home_content.setAdapter(new MyAdapter());
		 
		 gv_home_content.setOnItemClickListener(new MyItemOnClickListener());
		 
	}
	
	
	class MyItemOnClickListener implements AdapterView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0://�ֻ�����
				//Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				 //����һ�����룬����������ȷ֮��ſ��Խ�������
				 //��һ�ν����ʱ�������������룬���浽sp�֮��ڶ����Ժ����֤����
				String phonesafe_pwd = MyApplication.configsp.getString("phonesafe_pwd", "");
				if (phonesafe_pwd.isEmpty()) {
					 //����û�����ù�����ʱ����һ�������û�ȥ����
					showSetpwdDialog();
				}else {
					 //�����û�����������֮ǰ������Ƿ�һ��
                    showinputpwdDialog();
				}
				
				// startActivity(new Intent(HomeActivity.this,PhoneSafeActivity.class));
				break;
				
			case 1:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;
				
			case 2:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;
				
			case 3:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;
				
			case 4:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;
				
			case 5:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;
				
			case 6:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;
				
			case 7:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;
				
			case 8://��������
				//Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				//���  ��ת�� settingactivity ҳ��
				//startActivity(new Intent(this,SettingActivity.class));
				break;

			default:
				break;
			}
			
		}

		
	}
	
	
	//�Զ���alertdialog    ������֤����
	private void showinputpwdDialog(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		View v= View.inflate(this,R.layout.inpwd_dialog,null);
        final TextView et_condialog_pwd= (TextView) v.findViewById(R.id.et_condialog_pwd);

        Button  bt_conpwddialog_cancle = (Button) v.findViewById(R.id.bt_conpwddialog_cancle);
        Button  bt_conpwddialog_confirm = (Button) v.findViewById(R.id.bt_conpwddialog_confirm);

        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        
        bt_conpwddialog_confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String pwd = et_condialog_pwd.getText().toString();
				String savepwd = MyApplication.configsp.getString("phonesafe_pwd", "");
				
				//savepwd ���ǿ���Ϊ�յġ�ʱ���
				if (!savepwd.isEmpty()) {
					if (savepwd.equals(pwd)) {
						dialog.dismiss();
						startActivity(new Intent(HomeActivity.this,PhoneSafeActivity.class));
					}else {
						Toast.makeText(HomeActivity.this, "�����������������䣡", Toast.LENGTH_LONG).show();
					}
				}
			}
		});
        
        bt_conpwddialog_cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
        
	}
	
	
	
	//�Զ���alertdialog    ������������
	private void showSetpwdDialog() {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		View v = View.inflate(this,R.layout.setpwd_dialog,null);
		 final TextView et_dialog_pwd= (TextView) v.findViewById(R.id.et_dialog_pwd);
	        final TextView et_dialog_pwdcon= (TextView) v.findViewById(R.id.et_dialog_pwdcon);

	        Button  bt_setpwddialog_confirm = (Button) v.findViewById(R.id.bt_setpwddialog_confirm);
	        Button  bt_setpwddialog_cancle = (Button) v.findViewById(R.id.bt_setpwddialog_cancle);		
	        
	        builder.setView(v);
	        final AlertDialog dialog = builder.create();
	        dialog.show();
	        
	        bt_setpwddialog_confirm.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String pwd = et_dialog_pwd.getText().toString();
					String pwdcon = et_dialog_pwdcon.getText().toString();
					
					if (!pwd.isEmpty()&&!pwdcon.isEmpty()) {
						//��һ���ж�
						if (pwd.equals(pwdcon)) {
							/*MyApplication.editor.putString("phonesafe_pwd",pwd);
	                         MyApplication.editor.commit();*/
							
							MyApplication.setConfigValue("phonesafe_pwd", pwd);
							dialog.dismiss();
							
						}else {
							Toast.makeText(HomeActivity.this, "�û����������벻һ�£�����������!", Toast.LENGTH_LONG).show();
						}
					}else {
						Toast.makeText(HomeActivity.this, "�û����������벻��Ϊ��!", Toast.LENGTH_LONG).show();
					}
					
				}
			});
	        
	        bt_setpwddialog_cancle.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
	        
	}
	
	
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return CONTENT_NUM;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View converView, ViewGroup parent) {
			//GridView �Ż�  �ɲο�Listview �Ż�
			// ����1 ������convertview
			// ����2 ��viewholder
			// TODO Auto-generated method stub
			
			View v = View.inflate(HomeActivity.this, R.layout.item_gridview, null);
			//ע�⣺ v.findViewById  �����Ǳ�activity��home���µ�
			ImageView iv_gv_icon = (ImageView) v.findViewById(R.id.iv_gv_icon);
			TextView tv_gv_name = (TextView) v.findViewById(R.id.tv_gv_name);
			
			iv_gv_icon.setImageResource(iconarray[position]);
			tv_gv_name.setText(titles[position]);
			return v;
		}
		
	}
	
	
}
