package com.example.tripwithme;

import java.util.Timer;
import java.util.TimerTask;

import com.example.tripwithme.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	private Button navBarButton;
	private Button searchBtn;
	private DrawerLayout mDrawerLayout;
	private RelativeLayout wallpaper;
	private LinearLayout backgroundLayout;
	private TimerTask timerTask;
    private Timer timer;
    private int wallpaperTurn = 0;
    //private static Handler handler;
	
	Button main_btn_mypage; //오른쪽 위 마이페이지 아이콘
	ImageView profile_picture; //메뉴 안 프로필 사진

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//액션바 숨김
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		profile_picture=(ImageView)findViewById(R.id.drawer_picture);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
		main_btn_mypage=(Button)findViewById(R.id.main_btn_mypage);
		searchBtn = (Button)findViewById(R.id.main_btn_search);
		
		//jjy 050704) drawerlayout 그림자 추가 
		//jjy 050707) 그림자 제거하고 어두워지게
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		//mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
		backgroundLayout=(LinearLayout)findViewById(R.id.main_layout_background);
		wallpaper=(RelativeLayout)findViewById(R.id.main_layout_wallpaper);
		navBarButton=(Button)findViewById(R.id.main_btn_popup_menu);
		
		//jjy 050705) 배경화면 바뀌는 효과 추가
		final Handler handler = new Handler(){
			public void handleMessage(Message msg){
				switch(wallpaperTurn){
				case 0:
					wallpaper.setBackgroundDrawable(getResources().getDrawable(R.drawable.brazil));
					wallpaperTurn++;
					break;
				case 1:
					wallpaper.setBackgroundDrawable(getResources().getDrawable(R.drawable.wall1));
					wallpaperTurn++;
					break;
				case 2:
					wallpaper.setBackgroundDrawable(getResources().getDrawable(R.drawable.wall2));
					wallpaperTurn++;
					break;	
				case 3:
					wallpaper.setBackgroundDrawable(getResources().getDrawable(R.drawable.wall3));
					wallpaperTurn++;
					break;	
				case 4:
					wallpaper.setBackgroundDrawable(getResources().getDrawable(R.drawable.wall4));
					wallpaperTurn = 0;
					break;
				}
			}
		};
		//jjy 050705) 배경화면이 2초 마다 바뀜
		timerTask = new TimerTask(){
			@Override
			public void run() {
				handler.sendEmptyMessage(1);
			}
			
		};
		timer = new Timer();
		timer.schedule(timerTask, 3000, 7000);
		
		//jjy 050705) 검색 버튼
		searchBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mypageIntent=new Intent(MainActivity.this, TravelerListActivity.class);
				startActivity(mypageIntent);
			}
		});
		
		//프로필 사진 버튼
		profile_picture.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mypageIntent=new Intent(MainActivity.this, ProfileActivity.class);
				startActivity(mypageIntent);
			}
		});
		
		//drawerLayout 온오프 버튼(햄버거 버튼)
		navBarButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//jjy 050704) drawerLayout 오픈 및 클로즈 동작
				if (mDrawerLayout.isDrawerOpen(Gravity.START))	{
					mDrawerLayout.closeDrawer(Gravity.START);
				}
				else {
					mDrawerLayout.openDrawer(Gravity.START);
				}
				//
			}
		});
		
		//사용자 페이지 버튼
		main_btn_mypage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//danee 050704) 프로필 액티비티 띄움
				Intent mypageIntent=new Intent(MainActivity.this, ProfileActivity.class);
				startActivity(mypageIntent);
			}
		});
		
		
		//로긴 엑티비티 띄움 (임시)
		Intent intent=new Intent(MainActivity.this, LoginActivity.class);
		//Intent intent=new Intent(MainActivity.this, ChatActivity.class);
		startActivity(intent);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

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

















