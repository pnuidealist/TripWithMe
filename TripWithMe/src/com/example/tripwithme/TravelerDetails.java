package com.example.tripwithme;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TravelerDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traveler_details);

		//액션바 숨김
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		findViewById(R.id.traveler_details).setBackgroundDrawable(getResources().getDrawable(R.drawable.travelerdetails_sample));
	}
}
