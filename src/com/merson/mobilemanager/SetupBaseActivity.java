package com.merson.mobilemanager;
//定义一个基类
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public abstract class SetupBaseActivity extends ActionBarActivity {

	//系统提供给我们的用于滑动手势检测的类
	GestureDetector gestureDetector ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		gestureDetector = new GestureDetector(this,new MyGestureListener());
		super.onCreate(savedInstanceState);
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		gestureDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
	
	
	class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
		@Override
		public boolean onFling(MotionEvent e1,//包含了该flag的起点
				MotionEvent e2, //包含了该flag的终点
				float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			//快速在屏幕上滑动的时候，会call到该callback
			//e1  包含了起点的x y坐标  
			float startx = e1.getX();
			float starty = e1.getY();
			
			float stopx = e2.getX();
			float stopy = e2.getY();
			
			if (stopx-startx>200) {//右滑
				//显示上一页
				previous(null);
				
			}else  if(startx - stopx>200){
				next(null);
			}
			
			return super.onFling(e1, e2, velocityX, velocityY);
		}
		
		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub
			Log.i("onDoubleTap", "onDoubleTap");
			return super.onDoubleTap(e);
		}
		
		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			Log.i("onLongPress","onLongPress");
			super.onLongPress(e);
		}
	} 
	
	
	
	
	
	public abstract void next(View v);
	
	public abstract void previous(View v);
	
	
	
	
	
}
