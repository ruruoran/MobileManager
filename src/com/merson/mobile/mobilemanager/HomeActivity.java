package com.merson.mobile.mobilemanager;

import com.merson.mobilemanager.R; 
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
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
			case 0:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
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
				
			case 8:
				Toast.makeText(HomeActivity.this,titles[position],Toast.LENGTH_LONG).show();
				break;

			default:
				break;
			}
			
		}
		
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
