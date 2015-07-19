package com.example.tripwithme;

import java.util.Timer;
import java.util.TimerTask;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private TimerTask timerTask;
	private Timer timer;
	private EditText authenticationNumberBox;
	private Button sendBtn;
	Button login_okBtn; // 확인버튼

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		// 액션바 숨김
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		sendBtn = (Button) findViewById(R.id.sendBtn);
		login_okBtn = (Button) findViewById(R.id.okBtn);
		timer = new Timer();
		authenticationNumberBox = (EditText) findViewById(R.id.editText2);//인증번호 입력 editBox
		
		// 확인 버튼 눌렀을 시 액티비티 종료 (메인화면이 먼저 생성되고 열린 액티비티 이므로 종료되면 뒤에 메인화면이 남는다)
		login_okBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		// 인증번호전송 버튼
		sendBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				timer.schedule(timerTask, 3000);
			}
		});
		
		// jjy 050719) 인증번호 자동입력
		final Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				authenticationNumberBox.setText("68713");
			}
		};

		// jjy 050719)
		timerTask = new TimerTask() {

			@Override
			public void run() {
				handler.sendEmptyMessage(1);
			}
		};
		
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