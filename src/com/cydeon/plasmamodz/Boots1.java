package com.cydeon.plasmamodz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Boots1 extends ListActivity {
	 
		static final String[] Boot = 
	               new String[] { "Android", "Dragon Ball", "GameBoy", "GameCube", "Nexus", "The Nightmare Before Christmas", "Xbox", "Xbox 1"};
	 
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
	 
			setListAdapter(new Boots(this, Boot));
	 
		}
	 
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			
			String selectedValue = (String) getListAdapter().getItem(position);
			Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
		    Intent a = new Intent(Boots1.this, BootAnimation.class);
			 if(position == 0){
				 a.putExtra("Android", "android");
				 startActivity(a);
			 }else if(position == 1){
				 a.putExtra("Dragon", "dragon");
				 startActivity(a);
			 }else if (position == 2){
				 a.putExtra("GameBoy", "gameboy");
				 startActivity(a);
			 }else if (position == 3){
				 a.putExtra("GameCube", "gamecube");
				 startActivity(a);
			 }else if (position == 4){
				 a.putExtra("Nexus", "nexus");
				 startActivity(a);
			 }else if (position == 5){
				 a.putExtra("Nightmare", "nightmare");
				 startActivity(a);
			 }else if (position == 6){
				 a.putExtra("Xbox", "xbox");
				 startActivity(a);
			 }else if (position == 7){
				 a.putExtra("Xbox1", "xbox1");
				 startActivity(a);
				 overridePendingTransition (0 , R.anim.slide_up);
			 }
	 
		}

}
