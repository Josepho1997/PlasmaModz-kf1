package com.cydeon.plasmamodz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Wifi extends Activity implements OnClickListener {

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themes);
		
		 int [] viewIds = new int [] {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10};
			for(int i = 0; i < viewIds.length; i++){
				View v = findViewById(viewIds[i]);
				if (v != null) {
					v.setVisibility(0);
				}
			}
	
	Button blueDark = (Button) findViewById(R.id.b1);
	blueDark.setBackgroundResource(R.drawable.wifi_blue);
	Button blue = (Button) findViewById(R.id.b2);
	blue.setBackgroundResource(R.drawable.wifi_blue_dark);
	Button gold = (Button) findViewById(R.id.b3);
	gold.setBackgroundResource(R.drawable.wifi_gold);
	Button green = (Button) findViewById(R.id.b4);
	green.setBackgroundResource(R.drawable.wifi_green);
	Button orange = (Button) findViewById(R.id.b5);
	orange.setBackgroundResource(R.drawable.wifi_orange);
	Button pink = (Button) findViewById(R.id.b6);
	pink.setBackgroundResource(R.drawable.wifi_pink);
	Button red = (Button) findViewById(R.id.b7);
	red.setBackgroundResource(R.drawable.wifi_red);
	Button white = (Button) findViewById(R.id.b8);
	white.setBackgroundResource(R.drawable.wifi_white);
	Button honeycomb = (Button) findViewById(R.id.b9);
	honeycomb.setBackgroundResource(R.drawable.wifi_honeycomb);
	Button lightred = (Button) findViewById(R.id.b10);
	lightred.setBackgroundResource(R.drawable.wifi_lightred);

	int [] viewIds2 = new int [] {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8};
		for(int i = 0; i < viewIds2.length; i++){
			View v = findViewById(viewIds2[i]);
			if (v != null) {
				v.setOnClickListener(this);
			}
		}
}
	
	
	@Override
	public void onClick(View arg0) {
		Intent a = new Intent(Wifi.this, Bmod.class);
		if (arg0.getId() == R.id.b1) {
			a.putExtra("BlueDarkWifi", "bluedarkwifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b2) {
			a.putExtra("BlueWifi", "bluewifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b3) {
			a.putExtra("GoldWifi", "goldwifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b4) {
			a.putExtra("GreenWifi", "greenwifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b5) {
			a.putExtra("OrangeWifi", "orangewifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b6) {
			a.putExtra("PinkWifi", "pinkwifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b7) {
			a.putExtra("RedWifi", "redwifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b8) {
			a.putExtra("WhiteWifi", "whitewifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b9){
			a.putExtra("HoneycombWifi", "honeycombwifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b10){
			a.putExtra("LightRedWifi", "lightredwifi");
			startActivity(a);
		}
		
	}

}
