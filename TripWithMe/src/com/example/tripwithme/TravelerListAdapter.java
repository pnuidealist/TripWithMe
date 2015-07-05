package com.example.tripwithme;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//150705 jjy)
public class TravelerListAdapter extends BaseAdapter {
	private class ViewHolder {
		public FrameLayout photo;
		public ImageView photoBckgnd;
		public TextView period;
		public TextView name;
		public TextView nationality;
		public TextView language;
		public TextView attraction;
		public TextView loveNumber;

	}

	private Context mContext = null;
	private ArrayList<TravelerListModel> mListData = new ArrayList<TravelerListModel>();

	public TravelerListAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		return mListData.size();
	}

	@Override
	public Object getItem(int position) {
		return mListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listitem_travelerlist, null);

			holder.photo = (FrameLayout) convertView.findViewById(R.id.travelerList_photo);
			holder.photoBckgnd = (ImageView) convertView.findViewById(R.id.travelerList_photo_bkgnd);
			holder.period = (TextView) convertView.findViewById(R.id.traveler_listitem_period);

			holder.name = (TextView) convertView.findViewById(R.id.traveler_listitem_name);
			holder.nationality = (TextView) convertView.findViewById(R.id.traveler_listitem_nationality);
			holder.language = (TextView) convertView.findViewById(R.id.traveler_listitem_language);
			holder.attraction = (TextView) convertView.findViewById(R.id.traveler_listitem_attraction);
			holder.loveNumber = (TextView) convertView.findViewById(R.id.traveler_listitem_love_number);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		TravelerListModel mData = mListData.get(position);

		if (mData.photo != null) {
			holder.photoBckgnd.setVisibility(View.VISIBLE);
			holder.photoBckgnd.setImageDrawable(mData.photoBckgnd);
			holder.photo.setVisibility(View.VISIBLE);
			holder.photo.setBackgroundDrawable(mData.photo);

		} else {
			holder.photoBckgnd.setVisibility(View.GONE);
		}

		holder.period.setText(mData.period);
		holder.name.setText(mData.name);
		holder.nationality.setText(mData.nationality);
		holder.language.setText(mData.language);
		holder.attraction.setText(mData.attraction);
		holder.loveNumber.setText(mData.loveNumber);

		// convertView.setMinimumHeight(holder.photoBckgnd.getHeight()+holder.period.getHeight());

		return convertView;
	}

	// codes needed for list view item management

	public void addItem(Drawable photo, Drawable photoBckgnd, String period, String name, String nationality,
			String language, String attraction, String loveNumber) {
		TravelerListModel addInfo = null;
		addInfo = new TravelerListModel();
		addInfo.photo = photo;
		addInfo.photoBckgnd = photoBckgnd;
		addInfo.period = period;
		addInfo.name = name;
		addInfo.nationality = nationality;
		addInfo.language = language;
		addInfo.attraction = attraction;
		addInfo.loveNumber = loveNumber;

		mListData.add(addInfo);
	}

	public void remove(int position) {
		mListData.remove(position);
	}
}