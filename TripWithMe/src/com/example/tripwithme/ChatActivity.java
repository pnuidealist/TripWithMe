package com.example.tripwithme;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class ChatActivity extends Activity {
	private ImageView profile_picture; // 메뉴 안 프로필 사진
	private DrawerLayout mDrawerLayout;
	private Button navBarButton;
	private Button main_btn_mypage;
	private Button sendButton;
	private Button calenderButton;//yeun20150715
	
	private ImageView imgviewMarket; //jjy20150716 메뉴 안 마켓 이동 아이콘
	private ImageView imgviewRealTimeChat; //jjy20150716 메뉴 안 실시간채팅 이동 아이콘
	
	private EditText textInputBox;
	private Timer timer;
	private TimerTask timerTask;
	private int garaChatCnt;
	private Boolean hasUserEnteredMsg = false;
	private Boolean isTimerSet = false;
	private ListView listView;
	private ChatListAdapter listAdapter;
	private CharSequence[] items = { "2015.7.2 해운대", "2015.7.3 남포동" };//다이얼로그 창 체크 목록
	private ArrayList<String> mSelectedItems = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		ActionBar actionBar = getActionBar();
		actionBar.hide();

		timer = new Timer();
		garaChatCnt = 0;
		imgviewMarket = (ImageView)findViewById(R.id.drawer_market);
		imgviewRealTimeChat = (ImageView)findViewById(R.id.drawer_talk);
		sendButton = (Button) findViewById(R.id.chat_textSendBtn);
		navBarButton = (Button) findViewById(R.id.main_btn_popup_menu);
		main_btn_mypage = (Button) findViewById(R.id.main_btn_mypage);
		textInputBox = (EditText) findViewById(R.id.chat_textInputBox);
		profile_picture = (ImageView) findViewById(R.id.drawer_picture);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main_drawer);
		calenderButton = (Button) findViewById(R.id.chat_calendar);
		
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
				if (!isTimerSet) {
					timer.schedule(timerTask, 1500, 3000);
					isTimerSet = true;
				}
				
				textInputBox.setText("");

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
		
		//yeun20150715
		calenderButton.setOnClickListener(new View.OnClickListener() {
			//jjy20150716
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(ChatActivity.this)
				.setTitle("가이드 날짜 선택")
//				.setMessage("시간 초과!!!")
//				.setCancelable(false)	// Back Button 동작 안하도록 설정
				.setMultiChoiceItems(items, null,
						new DialogInterface.OnMultiChoiceClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//								 if (isChecked) {
//								 mSelectedItems.add(which);
//								 } else if (mSelectedItems.contains(which)) {
//								 mSelectedItems.remove(Integer.valueOf(which));
//								 }
							}
						})
				// "종료" 버튼
				.setNegativeButton("결정", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(ChatActivity.this, "결정함", Toast.LENGTH_SHORT).show();						
					}
				})

				.show();
			}
		});
		
		//jjy150716
				//네이게이션바에서 마켓 이동 버튼
		imgviewMarket.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChatActivity.this, MarketActivity.class);
				startActivity(intent);
			}
		});

		// 네이게이션바에서 실시간채팅 이동 버튼
		imgviewRealTimeChat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChatActivity.this, RealTimeChatListActivity.class);
				startActivity(intent);
			}
		});
		//////////////////////////////////////

		
		
		final Handler chatHandler = new Handler() {
			public void handleMessage(Message msg) {
				switch (garaChatCnt) {
				case 0:
					if (hasUserEnteredMsg == true) {
						listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo1), "hello what's up?",
								true);
						hasUserEnteredMsg = false;
						garaChatCnt++;
					}
					break;
				case 1:
					if (hasUserEnteredMsg == true) {
						listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo1),
								"It's not easy to satisfy me ", true);
						hasUserEnteredMsg = false;
						garaChatCnt++;
					}
					break;
				case 2:
					if (hasUserEnteredMsg == true) {
						listAdapter.addItem(getResources().getDrawable(R.drawable.chat_photo1), "OK^^", true);
						hasUserEnteredMsg = false;
						garaChatCnt++;
						timer.cancel();
					}
					break;
				}
				// Select the last row so it will scroll into view...
				listView.setSelection(listAdapter.getCount() - 1);
				
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
