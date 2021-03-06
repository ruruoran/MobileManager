package com.merson.mobile.mobilemanager;

import com.merson.mobile.application.MyApplication; 
import com.merson.mobile.utils.Md5Utils;
import com.merson.mobilemanager.AdvanceToolActivity;
import com.merson.mobilemanager.PackageManagerActivity;
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
	private String[] titles = {"手机防盗","通讯卫士","软件管理",
			 "进程管理","流量统计","手机杀毒",
			 "缓存清理","高级工具","设置中心"};
	
	//盛装照片
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
		 
		 
		 tv_home_welcome.setText("欢迎您,新用户,我们的应用可以保卫您手机的安全！");
		//方法2,让控件处于选中状态
		//tv_home_welcome.setSelected(true);
		 
		 //初始化九宫格
		 //相似与ListView
		 gv_home_content.setAdapter(new MyAdapter());
		 
		 gv_home_content.setOnItemClickListener(new MyItemOnClickListener());
		 
	}
	
	
	class MyItemOnClickListener implements AdapterView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0://手机防盗
				//Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				 //设置一个密码，输入密码正确之后才可以进入设置
				 //第一次进入的时候让他设置密码，保存到sp里。之后第二次以后才验证密码
				String phonesafe_pwd = MyApplication.configsp.getString("phonesafe_pwd", "");
				if (phonesafe_pwd.isEmpty()) {
					 //表明没有设置过，此时弹出一个框让用户去设置
					showSetpwdDialog();
				}else {
					 //看看用户输入的密码跟之前保存的是否一样
                    showinputpwdDialog();
				}
				
				// startActivity(new Intent(HomeActivity.this,PhoneSafeActivity.class));
				break;
				
			case 1:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;
				
			case 2:
				startActivity(new Intent(HomeActivity.this,PackageManagerActivity.class));
//				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
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
				//Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				startActivity(new Intent(HomeActivity.this,AdvanceToolActivity.class));
				break;
				
			case 8://设置中心
				//Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				//点击  跳转到 settingactivity 页面
				//startActivity(new Intent(this,SettingActivity.class));
				break;

			default:
				break;
			}
			
		}

		
	}
	
	
	//自定义alertdialog    用于验证密码
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
				
				//savepwd 还是可能为空的。时间差
				if (!savepwd.isEmpty()) {
					if (savepwd.equals(pwd)) {
						dialog.dismiss();
						startActivity(new Intent(HomeActivity.this,PhoneSafeActivity.class));
					}else {
						Toast.makeText(HomeActivity.this, "输入密码有误，请重输！", Toast.LENGTH_LONG).show();
					}
				}else {
					Toast.makeText(HomeActivity.this, "密码不能为空，请重输！", Toast.LENGTH_LONG).show();

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
	
	
	
	//自定义alertdialog    用于设置密码
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
						//进一步判断
						if (pwd.equals(pwdcon)) {
							/*MyApplication.editor.putString("phonesafe_pwd",pwd);
	                         MyApplication.editor.commit();*/
							
							//将pwd换成 md5加密后的pwd
							MyApplication.setConfigValue("phonesafe_pwd", Md5Utils.getMd5Digest(pwd));
							dialog.dismiss();
							
						}else {
							Toast.makeText(HomeActivity.this, "用户名或者密码不一致，请重新输入!", Toast.LENGTH_LONG).show();
						}
					}else {
						Toast.makeText(HomeActivity.this, "用户名或者密码不能为空!", Toast.LENGTH_LONG).show();
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
			//GridView 优化  可参考Listview 优化
			// 方法1 ：复用convertview
			// 方法2 ：viewholder
			// TODO Auto-generated method stub
			
			View v = View.inflate(HomeActivity.this, R.layout.item_gridview, null);
			//注意： v.findViewById  否则是本activity（home）下的
			ImageView iv_gv_icon = (ImageView) v.findViewById(R.id.iv_gv_icon);
			TextView tv_gv_name = (TextView) v.findViewById(R.id.tv_gv_name);
			
			iv_gv_icon.setImageResource(iconarray[position]);
			tv_gv_name.setText(titles[position]);
			return v;
		}
		
	}
	
	
}
