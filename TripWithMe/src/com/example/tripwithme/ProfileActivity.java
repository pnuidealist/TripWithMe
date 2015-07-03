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
	Button profile_btn_toggle;
	LinearLayout profile_layout0, profile_layout1, profile_layout2;
	boolean menu_toggle=false; //true=open, false=close
	int profile_layoutNo=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
		
		profile_btn_toggle=(Button)findViewById(R.id.profileBtn);
		profile_layout0=(LinearLayout)findViewById(R.id.profile_layout0);
		profile_layout1=(LinearLayout)findViewById(R.id.profile_layout1);
		profile_layout2=(LinearLayout)findViewById(R.id.profile_layout2);
		
		if (profile_layoutNo==0){
			profile_layout0.setVisibility(View.VISIBLE);
			profile_layout1.setVisibility(View.GONE);
			profile_layout2.setVisibility(View.GONE);
			profile_btn_toggle.setText(R.string.profile_toggle0);
			profile_layoutNo=1;
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
		
		profile_btn_toggle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (profile_layoutNo) {
				case 1:
					profile_layout1.setVisibility(View.VISIBLE);
					profile_layout0.setVisibility(View.GONE);
					profile_layout2.setVisibility(View.GONE);
					profile_btn_toggle.setText(R.string.profile_toggle1);
					profile_layoutNo=2;
					break;
				case 2:
					profile_layout2.setVisibility(View.VISIBLE);
					profile_layout0.setVisibility(View.GONE);
					profile_layout1.setVisibility(View.GONE);
					profile_btn_toggle.setText(R.string.profile_toggle2);
					profile_layoutNo=3;
					break;
				case 3:
					finish();
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
