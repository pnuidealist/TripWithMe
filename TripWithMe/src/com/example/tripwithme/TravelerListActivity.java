package com.example.tripwithme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TravelerListActivity extends Activity {
	private ListView mListView = null;
	private TravelerListAdapter mAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_travelerlist);
		getActionBar().hide();
		
		mListView = (ListView) findViewById(R.id.travelerList);
		mAdapter = new TravelerListAdapter(this);
		mListView.setAdapter(mAdapter);
		
		//리스트뷰 목록 추가
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo1),getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "1111111");
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo2),getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "2222222");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
}