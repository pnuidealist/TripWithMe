package com.example.tripwithme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


//150705 jjy)
public class TravelerListActivity extends Activity {
	private ListView mListView = null;
	private TravelerListAdapter mAdapter = null;
	private DrawerLayout mDrawerLayout;
	private Button navBarButton;
	private Button main_btn_mypage;
	private ImageView profile_picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_travelerlist);
		getActionBar().hide();

		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
		navBarButton = (Button) findViewById(R.id.main_btn_popup_menu);
		navBarButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
					mDrawerLayout.closeDrawer(Gravity.START);
				} else {
					mDrawerLayout.openDrawer(Gravity.START);
				}
				//
			}
		});

		main_btn_mypage = (Button) findViewById(R.id.main_btn_mypage);
		main_btn_mypage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mypageIntent = new Intent(TravelerListActivity.this, ProfileActivity.class);
				startActivity(mypageIntent);
			}
		});
		
		profile_picture=(ImageView)findViewById(R.id.drawer_picture);
		profile_picture.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mypageIntent=new Intent(TravelerListActivity.this, ProfileActivity.class);
				startActivity(mypageIntent);
			}
		});
		
		mListView = (ListView) findViewById(R.id.travelerList);
		mAdapter = new TravelerListAdapter(this);
		mListView.setAdapter(mAdapter);

		// 리스트뷰 목록 추가
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo1),
				getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "111~11","이름","국적","언어","관광지","5");
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo2),
				getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "222~22","이름","국적","언어","관광지","5");
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo3),
				getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "333~33","이름","국적","언어","관광지","5");
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo4),
				getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "444~44","이름","국적","언어","관광지","5");
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