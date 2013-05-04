package com.cydeon.plasmamodz;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Wifi extends Activity implements OnClickListener,
		OnGestureListener {

	private GestureDetector gestureDetector;
	private static final int SWIPE_MIN_DISTANCE = 150;
	private static final int SWIPE_THRESHOLD_VELOCITY = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themes);

		RelativeLayout ll = (RelativeLayout) findViewById(R.id.myLayout);
		gestureDetector = new GestureDetector(this, this);
		OnTouchListener gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};
		
		ActionBar ab = getActionBar();
		ab.hide();

		ll.setOnTouchListener(gestureListener);
		int[] viewIds = new int[] { R.id.b1, R.id.b2, R.id.b3, R.id.b4,
				R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10 };
		for (int i = 0; i < viewIds.length; i++) {
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

		int[] viewIds2 = new int[] { R.id.b1, R.id.b2, R.id.b3, R.id.b4,
				R.id.b5, R.id.b6, R.id.b7, R.id.b8 };
		for (int i = 0; i < viewIds2.length; i++) {
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
		} else if (arg0.getId() == R.id.b9) {
			a.putExtra("HoneycombWifi", "honeycombwifi");
			startActivity(a);
		} else if (arg0.getId() == R.id.b10) {
			a.putExtra("LightRedWifi", "lightredwifi");
			startActivity(a);
		}
		overridePendingTransition (0 , R.anim.slide_up);

	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
            float velocityY) {
        if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
        	
        	Intent next = new Intent(Wifi.this, StatusBar.class);
        	Bundle bndlanimation =
        	       	   ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.leftr,R.anim.rightl).toBundle();
        	           startActivity(next, bndlanimation);
            Log.i("tag", "Right to left");
            finish();
            return true; // Right to left

        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

        	Intent previous = new Intent(Wifi.this, Softkeys.class);
        	 Bundle bndlanimation =
     				ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.back,R.anim.backfinish).toBundle();
     	           startActivity(previous, bndlanimation);
     	          finish();
            Log.i("tag", "Left to right");
            return true; // Left to right
        }
        return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		Intent in = new Intent(Wifi.this, MainActivity.class);
		startActivity(in);
		overridePendingTransition (0 , R.anim.slide_down);
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
