package com.merson.mobilemanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class SetToastLocationActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_toast_location);
		
		LinearLayout ll_setlocation_toast  = (LinearLayout)findViewById(R.id.ll_setlocation_toast );
		
		final LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams)ll_setlocation_toast .getLayoutParams();
		
		layoutParams.gravity = Gravity.LEFT|Gravity.TOP;
		layoutParams.leftMargin=200;
		layoutParams.topMargin=300;
		
		ll_setlocation_toast.setLayoutParams(layoutParams);
	}
}
