package com.example.tripwithme;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RealTimeChatListActivity extends Activity {

	private Button btnTest;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_real_time_chat_list);
		
		btnTest=(Button)findViewById(R.id.test_btn); 
		
		//액션바 숨김
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		
		
		btnTest.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(RealTimeChatListActivity.this, RealTimeChatActivity.class);
				startActivity(intent);
				//finish();
			}
		});
	}	
}
