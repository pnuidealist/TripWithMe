package com.example.tripwithme;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ProfileActivity extends Activity {
	
	Button profile_btn_toggle;
	LinearLayout profile_layout_toggle0, profile_layout_toggle1, profile_layout_toggle2;
	
	int profile_toggle=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		profile_btn_toggle=(Button)findViewById(R.id.profileBtn);
		
		profile_layout_toggle0=(LinearLayout)findViewById(R.id.profile_toggle0);
		profile_layout_toggle1=(LinearLayout)findViewById(R.id.profile_toggle1);
		profile_layout_toggle2=(LinearLayout)findViewById(R.id.profile_toggle2);
		
		profile_btn_toggle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (profile_toggle) {
				case 0:
					profile_layout_toggle0.setVisibility(View.VISIBLE);
					profile_layout_toggle1.setVisibility(View.INVISIBLE);
					profile_layout_toggle2.setVisibility(View.INVISIBLE);
					profile_btn_toggle.setText(R.string.profile_toggle0);
					profile_toggle=1;
					break;
				case 1:
					profile_layout_toggle1.setVisibility(View.VISIBLE);
					profile_layout_toggle0.setVisibility(View.INVISIBLE);
					profile_layout_toggle2.setVisibility(View.INVISIBLE);
					profile_btn_toggle.setText(R.string.profile_toggle1);
					profile_toggle=2;
					break;
				case 2:
					profile_layout_toggle1.setVisibility(View.VISIBLE);
					profile_layout_toggle0.setVisibility(View.INVISIBLE);
					profile_layout_toggle2.setVisibility(View.INVISIBLE);
					profile_btn_toggle.setText(R.string.profile_toggle1);
					profile_toggle=3;
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
