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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		//jjy 050707) 그림자 제거하고 어두워짐
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		//mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
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
				getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "2015.07.1~3","제시카 알바","국적: 미국","사용가능 언어: 한국어, 영어","여행지: 남포동, 해운대","26");
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo2),
				getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "2015.07.2~5","스칼렛 요한슨","국적: 미국","사용가능 언어: 한국어, 영어","여행지: 부산대, 서면, 광안리","56");
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo3),
				getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "2015.07.1~5","로버트 다우니 주니어","국적: 미국","언어: 한국어, 영어, 중국어","여행지: 태종대, 서면","5");
		mAdapter.addItem(getResources().getDrawable(R.drawable.profilelist_photo4),
				getResources().getDrawable(R.drawable.profilelist_photo_bkgnd), "2015.07.2~3","장동건","국적: 한국","사용가능 언어: 한국어, 중국어","여행지: 해운대","159");
		
		//yeun 150709 clickEvent
		mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	
            	Intent intent=new Intent(TravelerListActivity.this, TravelerDetails.class);
				startActivity(intent);
				
            	/*
                Intent intent = new Intent(context, SendMessage.class);
                String message = "abc";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                */
            	
            }
        });
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