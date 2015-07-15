package com.example.tripwithme;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;


//DialogFragment which used to make dialog window for Chat activity calender button click
public class ChatActivityCalenderDialogFragment extends DialogFragment {
	public ArrayList<String> mSelectedItems;
	public CharSequence[] items = { "2015.7.1 해운대", "2015.7.2 남포동", "2015.7.3 광안리" };
	public AlertDialog dialog;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		mSelectedItems = new ArrayList<String>(); // Where we track the selected items
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		// Set the dialog title
		builder.setTitle(R.string.choose_days)
				// Specify the list array, the items to be selected by default
				// (null for none),
				// and the listener through which to receive callbacks when
				// items are selected
				.setMultiChoiceItems(items, null,
						new DialogInterface.OnMultiChoiceClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//								 if (isChecked) {
//								 // If the user checked the item, add it to
//								 //the selected items
//								 mSelectedItems.add(which);
//								 } else if (mSelectedItems.contains(which)) {
//								 // Else, if the item is already in the array,
//								 //remove it
//								 mSelectedItems.remove(Integer.valueOf(which));
//								 }
							}
						})
				// Set the action buttons
				.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						// User clicked OK, so save the mSelectedItems results
						// somewhere
						// or return them to the component that opened the
						// dialog
						//dismiss();
					}
				}).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						//dismiss();
					}
				});

		dialog = builder.create();
		return dialog;
	}

	public void confirmFireMissiles() {
		DialogFragment newFragment = new ChatActivityCalenderDialogFragment();
	    newFragment.show(getFragmentManager(), "missiles");
	}

}