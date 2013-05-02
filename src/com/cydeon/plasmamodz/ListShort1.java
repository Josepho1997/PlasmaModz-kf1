package com.cydeon.plasmamodz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.fima.cardsui.views.CardUI;

public class ListShort1 extends Activity{
	
	private CardUI mCardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mCardView = (CardUI) findViewById(R.id.cardsview);
		

		MyPlayCard batteryCard = new MyPlayCard(
		        "Battery Mods", 
		        "Go to the battery mods section", 
		        "#ff0075ff", "#ffb3d233", true, false);
		
		batteryCard.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListShort1.this, Themes.class);
				startActivity(intent);
				overridePendingTransition(0, R.anim.slide_up);

			}
		});
		mCardView.addCard(batteryCard);
		
		MyPlayCard CursorCard = new MyPlayCard(
		        "Cursor Mods", 
		        "Go to the cursor mods section", 
		        "#ffff00ff", "#ff33ffff", true, false);
		
		CursorCard.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListShort1.this, TextCursor.class);
				startActivity(intent);
				overridePendingTransition(0, R.anim.slide_up);

			}
		});
		mCardView.addCard(CursorCard);
		
		MyPlayCard LockCard = new MyPlayCard(
		        "Lockscreen Mods", 
		        "Go to the lockscreen mods section", 
		        "#ff16dc24", "#ff993CF3", true, false);
		
		LockCard.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListShort1.this, Lock.class);
				startActivity(intent);
				overridePendingTransition(0, R.anim.slide_up);

			}
		});
		mCardView.addCard(LockCard);
		
		MyPlayCard SoftCard = new MyPlayCard(
		        "Softkey Mods", 
		        "Go to the softkey mods section", 
		        "#ffffff00", "#ffff0000", true, false);
		
		SoftCard.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListShort1.this, Softkeys.class);
				startActivity(intent);
				overridePendingTransition(0, R.anim.slide_up);

			}
		});
		mCardView.addCard(SoftCard);
		
		MyPlayCard StatCard = new MyPlayCard(
		        "StatusBar Mods", 
		        "Go to the statusbar mods section", 
		        "#ffb3d233", "#ff33b5e5", true, false);
		
		StatCard.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListShort1.this, StatusBar.class);
				startActivity(intent);
				overridePendingTransition(0, R.anim.slide_up);

			}
		});
		mCardView.addCard(StatCard);
		
		MyPlayCard WifiCard = new MyPlayCard(
		        "Wifi Mods", 
		        "Go to the wifi mods section", 
		        "#ffda3800", "#ff16dc24", true, false);
		
		WifiCard.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ListShort1.this, Wifi.class);
				startActivity(intent);
				overridePendingTransition(0, R.anim.slide_up);

			}
		});
		mCardView.addCard(WifiCard);
		
		mCardView.refresh();
		
		}
	
	
	
}
