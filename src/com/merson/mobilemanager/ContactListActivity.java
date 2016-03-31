package com.merson.mobilemanager;

import java.util.ArrayList;
import java.util.List;

import com.merson.mobile.bean.Contact;
import com.merson.mobile.utils.ContactUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContactListActivity extends ActionBarActivity {

	private ListView lv_contactlist_showcontact;
	private List<Contact> contactlist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_list);
		
		contactlist = new ArrayList<>();
		
		lv_contactlist_showcontact = (ListView) findViewById(R.id.lv_contactlist_showcontact);
		
		//把联系人数据放入contactlist；
		contactlist = ContactUtils.getAllContact(this);
		
		lv_contactlist_showcontact.setAdapter(new MyContactAdpater());
		
		lv_contactlist_showcontact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?>parent,View view ,int position ,long id) {
				// TODO Auto-generated method stub

				Contact onecontact = contactlist.get(position);
				Intent data = new Intent();
				
				data.putExtra("number", onecontact.getNumber());
				
				setResult(1000,data);
				finish();
			}
		});
	}
	
	class MyContactAdpater extends BaseAdapter{

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
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Contact onecontact = contactlist.get(position);
			
			View v = View.inflate(ContactListActivity.this, R.layout.item_contactlist, null);
			final TextView tv_contactlist_name = (TextView) v.findViewById(R.id.tv_contactlist_name);
		    final TextView tv_contactlist_number = (TextView) v.findViewById(R.id.tv_contactlist_number);
			 
			tv_contactlist_name.setText(onecontact.getName());
			tv_contactlist_number.setText(onecontact.getNumber());
			 
            return v;
		}
		
	}
	
}
