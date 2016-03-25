package com.merson.mobile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.widget.TextView;

public class MyTextView extends TextView{
	public MyTextView(Context context){
		super(context);
	}
	
	
    public MyTextView(Context context,AttributeSet attrs){
		super(context,attrs);
	}
    
    @Override
    public boolean isFocused() {
    	// TODO Auto-generated method stub
//    	return super.isFocused();
    	return true;
    }

}
