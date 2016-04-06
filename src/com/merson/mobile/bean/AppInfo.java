package com.merson.mobile.bean;

import android.graphics.drawable.Drawable;

public class AppInfo {

	String appname ;
	Drawable icon;
	boolean isSdcard;//true 表示装在sdcard false 表示装在ROM中
	
	
	public AppInfo(String appname, Drawable icon, boolean isSdcard) {
		super();
		this.appname = appname;
		this.icon = icon;
		this.isSdcard = isSdcard;
	}


	public AppInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAppname() {
		return appname;
	}


	public void setAppname(String appname) {
		this.appname = appname;
	}


	public Drawable getIcon() {
		return icon;
	}


	public void setIcon(Drawable icon) {
		this.icon = icon;
	}


	public boolean isSdcard() {
		return isSdcard;
	}


	public void setSdcard(boolean isSdcard) {
		this.isSdcard = isSdcard;
	}


	@Override
	public String toString() {
		return "AppInfo [appname=" + appname + ", icon=" + icon + ", isSdcard="
				+ isSdcard + "]";
	}
	
	
	
	
	
}
