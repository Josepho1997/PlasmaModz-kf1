package com.cydeon.plasmamodz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListShort1 extends ListActivity {
	 
		static final String[] Activity = 
	               new String[] { "Battery Mods", "Softkey Mods", "Status Bar Mods", "Wifi Mods", "Installer"};
	 
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
	 
			setListAdapter(new ListShort(this, Activity));
	 
		}
	 
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			
			String selectedValue = (String) getListAdapter().getItem(position);
			Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
			 if(position == 0){
				 Intent Bmods = new Intent(ListShort1.this, Themes.class);
				 startActivity(Bmods);
			 }else if (position == 1){
				 Intent Smods = new Intent(ListShort1.this, Softkeys.class);
				 startActivity(Smods);
			 }else if (position == 2){
				 Intent Wmods = new Intent(ListShort1.this, StatusBar.class);
				 startActivity(Wmods);
			 }else if (position == 3){
				 Intent SBmods = new Intent(ListShort1.this, Wifi.class);
				 startActivity(SBmods);
			 }else if (position == 4){
				 Intent Installer = new Intent(ListShort1.this, Install.class);
				 startActivity(Installer);
			 }
		}
}
