package com.example.tripwithme;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

	Button login_okBtn; //확인버튼
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		//액션바 숨김
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		login_okBtn=(Button)findViewById(R.id.okBtn);
		//확인 버튼 눌렀을 시 액티비티 종료 (메인화면이 먼저 생성되고 열린 액티비티 이므로 종료되면 뒤에 메인화면이 남는다)
		login_okBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
				//startActivity(mainIntent);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
