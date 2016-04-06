package com.merson.mobilemanager;

import java.util.List;

import com.merson.mobile.bean.AppInfo;
import com.merson.mobile.utils.PackageUtils;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PackageManagerActivity extends Activity {

	ListView lv_package_appinfo;
	private List<AppInfo> appinfolist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_package_manager);
		
		TextView tv_pacakge_rom = (TextView) findViewById(R.id.tv_pacakge_rom);
		TextView tv_pacakge_sdcard = (TextView) findViewById(R.id.tv_pacakge_sdcard);
		
		 tv_pacakge_rom.setText("手机ROM剩余空间:\r\n"+ bytetoMega(PackageUtils.getAvailableROMSize()));
	     tv_pacakge_sdcard.setText("手机SDCARD剩余空间:\r\n" + bytetoMega(PackageUtils.getAvailableSDcardSize()));
	     
	      lv_package_appinfo = (ListView) findViewById(R.id.lv_package_appinfo);
	      
	      //获取显示的数据，封装到一个list
	        appinfolist= PackageUtils.getAllAppInfo(this);


	        lv_package_appinfo.setAdapter(new MyAdapter());
	}
	
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View v, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
	}
	
	
	
	 public String bytetoMega(long bytesize){
	        return Formatter.formatFileSize(this,bytesize);
	    }
	
	
	
	
}
