package com.example.tripwithme;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RealTimeChatActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//액션바 숨김
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		setContentView(R.layout.activity_real_time_chat);
	}
}
