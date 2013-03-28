package com.cydeon.plasmamodz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Boots1 extends ListActivity {
	 
		static final String[] Boot = 
	               new String[] { "Android", "Dragon Ball", "JellyBean", "Nexus"};
	 
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
	 
			setListAdapter(new Boots(this, Boot));
	 
		}
	 
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
	 
			//get selected items
			String selectedValue = (String) getListAdapter().getItem(position);
			Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
			 if(position == 0){
				 Intent a = new Intent(Boots1.this, Softkeys.class);
				 startActivity(a);
			 }else if(position == 1){
				 Intent b = new Intent(Boots1.this, Themes.class);
				 startActivity(b);
			 }
	 
		}

}
