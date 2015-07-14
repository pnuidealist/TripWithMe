
package com.example.tripwithme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TravelerDetails extends Activity {

	private Button screenBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traveler_details);

		//액션바 숨김
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		//findViewById(R.id.traveler_details).setBackgroundDrawable(getResources().getDrawable(R.drawable.travelerdetails_sample));
		
		screenBtn = (Button)findViewById(R.id.traveler_details_btn);
		
		screenBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(TravelerDetails.this, ChatActivity.class);
				startActivity(intent);
				//finish();
			}
		});
		
		
		
	}
}
