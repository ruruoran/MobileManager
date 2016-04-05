package com.merson.mobilemanager;

import com.merson.mobile.application.MyApplication; 


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SetToastLocationActivity extends ActionBarActivity {

	 private static final String TAG ="SetToastLocation" ;
	 private LinearLayout ll_setlocation_toast;
	 
	 
	 private int windowHeight;
	 private int windowWidth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_toast_location);
		
		 ll_setlocation_toast  = (LinearLayout)findViewById(R.id.ll_setlocation_toast );
		
		final LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams)ll_setlocation_toast .getLayoutParams();
		
		layoutParams.gravity = Gravity.LEFT|Gravity.TOP;
		layoutParams.leftMargin=200;
		layoutParams.topMargin=300;
		
		//��ȡ��Ļ���
		final WindowManager mWM = (WindowManager) getSystemService(WINDOW_SERVICE);
		final Display defaultDisplay = mWM.getDefaultDisplay();
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		defaultDisplay.getMetrics(displayMetrics);
		
		windowHeight = displayMetrics.heightPixels;
		windowWidth = displayMetrics.widthPixels;
		
		
		ll_setlocation_toast.setLayoutParams(layoutParams);
		
		
		ll_setlocation_toast.setOnTouchListener(new View.OnTouchListener() {
			
			float startx;
			float starty;
			float endx;
			float endy;
			
			int finalx;
			int finaly;	
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Log.i(TAG,event.getAction()+"");

                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        startx = event.getRawX();
                        starty = event.getRawY();

                        break;
                    case MotionEvent.ACTION_MOVE:

                        endx = event.getRawX();
                        endy = event.getRawY();

                        float dx = endx - startx;
                        float dy = endy - starty;

                        float oldx=  ll_setlocation_toast.getX();
                        float oldy=  ll_setlocation_toast.getY();

                        float oldrigth = oldx+ll_setlocation_toast.getWidth();
                        float oldbottom = oldy+ll_setlocation_toast.getHeight();

                        if (oldx+dx<0||oldrigth+dx>windowWidth||oldbottom+dy>windowHeight||oldy+dy<50){
                            break;
                        }
                        ll_setlocation_toast.layout((int) (oldx + dx), (int) (oldy + dy), (int) (oldrigth + dx), (int) (oldbottom + dy));

                        finalx=(int) (oldx + dx);
                        finaly=(int) (oldy + dy);

                        //�Ե�ǰmove�¼����յ���Ϊ��һ���ƶ������
                        startx=endx;
                        starty=endy;

                        break;

                    case MotionEvent.ACTION_UP:
                        MyApplication.setConfigValue("toastx", finalx);
                        MyApplication.setConfigValue("toasty",finaly);
                        break;
                }


                return false;
            }
		});
		
		
		 //Ҫ����һ�� ˫�������ָ���ʼλ�á�����������Σ��м���������500ms
		ll_setlocation_toast.setOnClickListener(new View.OnClickListener() {
			
			boolean firstclick = true ;
			long firstclicktime;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(TAG, "onclick");
				
				if (firstclick) {
					firstclicktime = System.currentTimeMillis();
					firstclick = false;
				}else {
					long secondclick = System.currentTimeMillis();
					if (secondclick-firstclicktime<500) {//����˫���¼�
						Toast.makeText(SetToastLocationActivity.this, "˫��", Toast.LENGTH_SHORT).show();
                        ll_setlocation_toast.layout(200, 300, 200 + ll_setlocation_toast.getWidth(), 300 + ll_setlocation_toast.getHeight()  );
                        MyApplication.setConfigValue("toastx", 200);
                        MyApplication.setConfigValue("toasty",300);
                        firstclick = true;
					}else {//���ε��ʧЧ ����
						firstclick = true;
					}
				}
			}
		});
		
	}
}
