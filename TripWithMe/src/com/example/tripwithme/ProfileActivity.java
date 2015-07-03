package com.example.tripwithme;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ProfileActivity extends Activity {
	private Button navBarButton;
	private DrawerLayout mDrawerLayout;
	
	Button profile_btn_next;  //프로필 액티비티의 가장 하단 버튼
	LinearLayout profile_layout0, profile_layout1, profile_layout2; //0=작성요구창, 1=필수 작성창, 2-선택 작성창
	boolean menu_toggle=false; //true=open, false=close
	int profile_layoutNo=0; // 프로필의 작성여부 확인) 0 = 프로필 작성 안됨 , 1 = 필수 프로필 작성 , 2 = 선택 프로필 작성

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
		
		profile_btn_next=(Button)findViewById(R.id.profileBtn);
		
		profile_layout0=(LinearLayout)findViewById(R.id.profile_layout0);
		profile_layout1=(LinearLayout)findViewById(R.id.profile_layout1);
		profile_layout2=(LinearLayout)findViewById(R.id.profile_layout2);
		
		//danee 050704) 만약 작성이 안되어있으면 첫 레이아웃 (작성요구) 나머지 레이아웃 숨김
		if (profile_layoutNo==0){ 
			profile_layout0.setVisibility(View.VISIBLE);
			profile_layout1.setVisibility(View.GONE);
			profile_layout2.setVisibility(View.GONE);
			profile_btn_next.setText(R.string.profile_layout_btn0); //"프로필 작성"
			profile_layoutNo=1; //레이아웃 넘김
		}
		navBarButton=(Button)findViewById(R.id.main_btn_popup_menu);
		navBarButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (menu_toggle==false)	{
					mDrawerLayout.openDrawer(Gravity.START);
					menu_toggle=true;
				}
				else {
					mDrawerLayout.closeDrawer(Gravity.START);
					menu_toggle=false;
				}
				
			}
		});
		
		//버튼을 눌렀을때 프로필이 어디까지 작성되어있는지 여부 판단
		profile_btn_next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (profile_layoutNo) {
				case 1: //필수 작성
					profile_layout1.setVisibility(View.VISIBLE);
					profile_layout0.setVisibility(View.GONE);
					profile_layout2.setVisibility(View.GONE);
					profile_btn_next.setText(R.string.profile_layout_btn1); //"다음"
					profile_layoutNo=2; //다음창 
					break;
				case 2: //선택 작성
					profile_layout2.setVisibility(View.VISIBLE);
					profile_layout0.setVisibility(View.GONE);
					profile_layout1.setVisibility(View.GONE);
					profile_btn_next.setText(R.string.profile_layout_btn2); //"완료"
					profile_layoutNo=3;
					break;
				case 3:
					finish(); //두창 모두 지나왔다면 액티비티 종료
					break;
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
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
