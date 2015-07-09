package com.example.tripwithme;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatListAdapter extends BaseAdapter{
	private class ViewHolder{
		public ImageView photo;
		public TextView txtView;
	}
	private ViewHolder holder;
	private Context context = null;
	
	ArrayList <ChatListModel> list = new ArrayList<ChatListModel>();
	
	public ChatListAdapter(Context context){
		super();
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ChatListModel listModel = list.get(position);
		
		if (convertView == null){
			holder = new ViewHolder();
			//in case that current row is a content to be shown on the left of the listview
			if(listModel.isLeft){
				convertView = inflater.inflate(R.layout.chat_left, null);
				holder.txtView = (TextView) convertView.findViewById(R.id.chat_left_txtbx);
				holder.photo = (ImageView) convertView.findViewById(R.id.photo_left);
				
			}
			else if(!listModel.isLeft){
				convertView = inflater.inflate(R.layout.chat_right, null);
				holder.txtView = (TextView) convertView.findViewById(R.id.chat_right_txtbx);
				holder.photo = (ImageView) convertView.findViewById(R.id.photo_right);
				
			}
			convertView.setTag(holder);
		}
		else
			holder = (ViewHolder)convertView.getTag();
		holder.txtView.setText(listModel.talk);
		holder.photo.setImageDrawable(listModel.photo);
		return convertView;
	}
	public void addItem(Drawable photo,String text, Boolean isLeft){
		ChatListModel newItem = new ChatListModel();
		newItem.photo = photo;
		newItem.isLeft = isLeft;
		newItem.talk = text;
		list.add(newItem);
	}

}
