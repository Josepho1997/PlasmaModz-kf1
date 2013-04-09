package com.cydeon.plasmamodz;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class About1 extends ListActivity {
	 
		static final String[] Activity = 
	               new String[] { "About PlasmaModz", "About Me"};
	 
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
	 
			setListAdapter(new ListShort(this, Activity));
	 
		}
	 
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(About1.this);
			String selectedValue = (String) getListAdapter().getItem(position);
			Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
			 if(position == 0){
			        alertDialog.setTitle("About PlasmaModz");
			        alertDialog.setMessage(R.string.aboutApp);
			        alertDialog.setNegativeButton(R.string.aboutAppButton, new DialogInterface.OnClickListener() {
		                   public void onClick(DialogInterface dialog, int id) {
		                   }
		               });

			        alertDialog.show();
			 }else if(position == 1){
				 
			 }
		}

}
