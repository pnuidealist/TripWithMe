package com.example.tripwithme;

import java.util.Timer;
import java.util.TimerTask;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class ChatActivity extends Activity {
	private ImageView profile_picture; // 메뉴 안 프로필 사진
	private DrawerLayout mDrawerLayout;
	private Button navBarButton;
	private Button main_btn_mypage;
	private Button sendButton;
	private EditText textInputBox;
	private Timer timer;
	private TimerTask timerTask;
	private int garaChatCnt;
	private Boolean hasUserEnteredMsg = false;
	private Boolean isTimerSet = false;
	private ListView listView;
	private ChatListAdapter listAdapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		ActionBar actionBar = getActionBar();
		actionBar.hide();

		timer = new Timer();
		garaChatCnt = 0;
		sendButton = (Button) findViewById(R.id.chat_textSendBtn);
		navBarButton = (Button) findViewById(R.id.main_btn_popup_menu);
		main_btn_mypage = (Button) findViewById(R.id.main_btn_mypage);
		textInputBox = (EditText) findViewById(R.id.chat_textInputBox);
		profile_picture = (ImageView) findViewById(R.id.drawer_picture);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);

		listView = (ListView) findViewById(R.id.chatList);
		listAdapter = new ChatListAdapter(this);
		listView.setAdapter(listAdapter);
		// sendButton
		sendButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String userInput = textInputBox.getText().toString();
				listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo1), userInput, false);
				hasUserEnteredMsg = true; // 이 변수가 true라면 timerTast가 답장을 보내고
											// false로 만듬.
				if ( ! isTimerSet){
					timer.schedule(timerTask, 1500, 3000);
					isTimerSet = true;
				}
				
					listView.post(new Runnable() {
			        @Override
			        public void run() {
			            // Select the last row so it will scroll into view...
			            listView.setSelection(listAdapter.getCount() - 1);
			        }
			    });
			}
		});

		// drawerLayout 온오프 버튼(햄버거 버튼)
		navBarButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// jjy 050704) drawerLayout 오픈 및 클로즈 동작
				if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
					mDrawerLayout.closeDrawer(Gravity.START);
				} else {
					mDrawerLayout.openDrawer(Gravity.START);
				}
				//
			}
		});

		
		final Handler chatHandler = new Handler() {
			public void handleMessage(Message msg) {
				switch (garaChatCnt) {
				case 0:
					if (hasUserEnteredMsg == true) {
						listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo3), "hello what's up?",
								true);
						hasUserEnteredMsg = false;
						garaChatCnt++;
					}
					break;
				case 1:
					if (hasUserEnteredMsg == true) {
						listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo3),
								"It's not easy to satisfy me ", true);
						hasUserEnteredMsg = false;
						garaChatCnt++;
					}
					break;
				case 2:
					if (hasUserEnteredMsg == true) {
						listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo3), "OK^^", true);
						hasUserEnteredMsg = false;
						garaChatCnt++;
						timer.cancel();
					}
					break;
				}
			}
		};

		timerTask = new TimerTask() {

			@Override
			public void run() {
				chatHandler.sendEmptyMessage(1);
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
