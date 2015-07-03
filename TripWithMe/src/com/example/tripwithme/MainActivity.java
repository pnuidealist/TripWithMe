package com.example.tripwithme;

import com.example.tripwithme.R;

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

public class MainActivity extends Activity {
	
	private Button navBarButton;
	private DrawerLayout mDrawerLayout;
	Button main_btn_mypage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
		main_btn_mypage=(Button)findViewById(R.id.main_btn_mypage);
		navBarButton=(Button)findViewById(R.id.main_btn_popup_menu);
		navBarButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mDrawerLayout.openDrawer(Gravity.START);
			}
		});
		main_btn_mypage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mypageIntent=new Intent(MainActivity.this, ProfileActivity.class);
				startActivity(mypageIntent);
			}
		});
		
		
		//로긴 엑티비티 띄움
		Intent intent=new Intent(MainActivity.this, LoginActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

















