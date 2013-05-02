package com.cydeon.plasmamodz;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Credits1 extends ListActivity {
	 
		static final String[] Activity = 
	               new String[] { "Battery Mods", "Cursor Mods", "Lockscreen Mods", "Softkey Mods", "Status Bar Mods", "Wifi Mods"};
	 
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
	 
			setListAdapter(new Credits(this, Activity));
	 
		}
	 
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			
			String selectedValue = (String) getListAdapter().getItem(position);
			Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
			 if(position == 0){
				creditsBattery();
			 }else if (position == 1){
				 creditsCursor();
			 }else if (position == 2){
				 creditsLockscreen();
			 }else if (position == 3){
				creditsSoftkey();
			 }else if (position == 4){
				 creditsStatusBar();
			 }else if (position == 5){
				 creditsWifi();
			 }else if (position == 6){
			 }
		}
		
		public void creditsBattery(){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Credits1.this);
			alertDialogBuilder.setTitle("Battery Mod Credits:");

			alertDialogBuilder
				.setMessage("All of the battery mods have been created entirely by XDA Senior Member 02ranger. Thanks, 02ranger!")
				.setCancelable(false)
				.setNegativeButton("Dismiss",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
					}
				});

				AlertDialog alertDialog = alertDialogBuilder.create();

				alertDialog.show();
		}
		
		public void creditsCursor(){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Credits1.this);
			alertDialogBuilder.setTitle("Cursor Mod Credits:");

			alertDialogBuilder
				.setMessage("All of the cursor mods were made by me")
				.setCancelable(false)
				.setNegativeButton("Dismiss",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
					}
				});

				AlertDialog alertDialog = alertDialogBuilder.create();

				alertDialog.show();
		}
		
		public void creditsLockscreen(){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Credits1.this);
			alertDialogBuilder.setTitle("Lockscreen Mod Credits:");

			alertDialogBuilder
				.setMessage("All of the lockscreen mods were made by me")
				.setCancelable(false)
				.setNegativeButton("Dismiss",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
					}
				});

				AlertDialog alertDialog = alertDialogBuilder.create();

				alertDialog.show();
		}
		
		public void creditsSoftkey(){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Credits1.this);
			alertDialogBuilder.setTitle("Softkey Mod Credits:");
			 
			alertDialogBuilder
				.setMessage("All of the softkey mods have been created by XDA Recognized Contributor atticus 182. Thanks, atticus 182!")
				.setCancelable(false)
				.setNegativeButton("Dismiss",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
					}
				});

				AlertDialog alertDialog = alertDialogBuilder.create();

				alertDialog.show();
		}
		
		public void creditsStatusBar(){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Credits1.this);
			alertDialogBuilder.setTitle("StatusBar Mod Credits:");
			 
			alertDialogBuilder
				.setMessage("All of the status bar mods were made by me")
				.setCancelable(false)
				.setNegativeButton("Dismiss",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
					}
				});

				AlertDialog alertDialog = alertDialogBuilder.create();

				alertDialog.show();
		}
		
		public void creditsWifi(){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Credits1.this);
			alertDialogBuilder.setTitle("Wifi Mod Credits:");
			 
			alertDialogBuilder
				.setMessage("I have no idea who made these wifi mods. I gathered them from the internet. I do not take credit for making these")
				.setCancelable(false)
				.setNegativeButton("Dismiss",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
					}
				});

				AlertDialog alertDialog = alertDialogBuilder.create();

				alertDialog.show();
		}
		
}
