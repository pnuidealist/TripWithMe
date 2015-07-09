package com.example.tripwithme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ChatActivity extends Activity {
	private Button navBarButton;
	private Button main_btn_mypage;
	private ImageView profile_picture; // 메뉴 안 프로필 사진
	private DrawerLayout mDrawerLayout;

	private ListView listView;
	private ChatListAdapter listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		ActionBar actionBar = getActionBar();
		actionBar.hide();

		navBarButton = (Button) findViewById(R.id.main_btn_popup_menu);
		main_btn_mypage = (Button) findViewById(R.id.main_btn_mypage);
		profile_picture = (ImageView) findViewById(R.id.drawer_picture);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);

		listView = (ListView) findViewById(R.id.chatList);
		listAdapter = new ChatListAdapter(this);
		listView.setAdapter(listAdapter);

		//drawerLayout 온오프 버튼(햄버거 버튼)
		navBarButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// jjy 050704) drawerLayout 오픈 및 클로즈 동작
				if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
					mDrawerLayout.closeDrawer(Gravity.START);
				} else {
					mDrawerLayout.openDrawer(Gravity.START);
				}
				//
			}
		});

		// 사용자 페이지 버튼
		main_btn_mypage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// danee 050704) 프로필 액티비티 띄움
				Intent mypageIntent = new Intent(ChatActivity.this, ProfileActivity.class);
				startActivity(mypageIntent);
			}
		});
		
		// 프로필 사진 버튼
		profile_picture.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mypageIntent = new Intent(ChatActivity.this, ProfileActivity.class);
				startActivity(mypageIntent);
			}
		});

		listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo3), "hello", false);
		listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo1), "hello what's up?", true);
		listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo3), "I am here to help you ", false);
		listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo1), "It's not easy to satisfy me ", true);
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
