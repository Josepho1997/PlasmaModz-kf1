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

public class StatusBar extends Activity implements OnClickListener, OnGestureListener{

	private GestureDetector gestureDetector;
	private static final int SWIPE_MIN_DISTANCE = 150;
	private static final int SWIPE_THRESHOLD_VELOCITY = 100;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statusbar);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		RelativeLayout ll = (RelativeLayout) findViewById(R.id.sBar);
		gestureDetector = new GestureDetector(this, this);
		OnTouchListener gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};
		
		Button softstock = (Button) findViewById(R.id.bStock);
		softstock.setOnClickListener(this);
		Button softGreenHex = (Button) findViewById(R.id.bGreenHex);
		softGreenHex.setOnClickListener(this);
		Button softPurple = (Button) findViewById(R.id.bLDPurple);
		softPurple.setOnClickListener(this);
		Button softNightSky = (Button) findViewById(R.id.bNightSky);
		softNightSky.setOnClickListener(this);
		Button softPurpleBlue = (Button) findViewById(R.id.bPBLue);
		softPurpleBlue.setOnClickListener(this);
		Button softRainbow = (Button) findViewById(R.id.bRainbow);
		softRainbow.setOnClickListener(this);
		Button softRedBlueOrange = (Button) findViewById(R.id.bRBlueO);
		softRedBlueOrange.setOnClickListener(this);
		Button softWhiteBlack = (Button) findViewById(R.id.bWBlack);
		softWhiteBlack.setOnClickListener(this);
		Button softWood = (Button) findViewById(R.id.bWood);
		softWood.setOnClickListener(this);
		Button softWhiteBlue = (Button) findViewById(R.id.bWBlue);
		softWhiteBlue.setOnClickListener(this);
		
		
	}

	public void onClick(View arg0) {
		Intent z = new Intent(StatusBar.this, Bmod.class);
		if (arg0.getId() == R.id.bStock) {
			z.putExtra("StatStock", "softstock");
		} else if (arg0.getId() == R.id.bGreenHex){
			z.putExtra("StatGreenHex", "softgreenhex");
		} else if (arg0.getId() == R.id.bLDPurple){
			z.putExtra("StatLightDarkPurple", "statlightdarkpurple");
		} else if (arg0.getId() == R.id.bNightSky){
			z.putExtra("StatNightSky", "statnightsky");
		} else if (arg0.getId() == R.id.bPBLue){
			z.putExtra("StatPurpleBlue", "statpurpleblue");
		} else if (arg0.getId() == R.id.bRainbow){
			z.putExtra("StatRainbow", "statrainbow");
		} else if (arg0.getId() == R.id.bRBlueO){
			z.putExtra("StatRedBlueOrange", "statredblueorange");
		} else if (arg0.getId() == R.id.bWBlack){
			z.putExtra("StatWhiteBlack", "statwhiteblack");
		} else if (arg0.getId() == R.id.bWood){
			z.putExtra("StatWood", "statwood");
		} else if (arg0.getId() == R.id.bWBlue){
			z.putExtra("StatWhiteBlue", "statwhiteblue");
		}
		startActivity(z);
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

            Intent next = new Intent(StatusBar.this, Lock.class);
            Bundle bndlanimation =
                	   ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.leftr,R.anim.rightl).toBundle();
                    startActivity(next, bndlanimation);
            Log.i("tag", "Right to left");
            finish();
            return true; // Right to left

        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

        	Intent previous = new Intent(StatusBar.this, Wifi.class);
        	 Bundle bndlanimation =
     				ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.back,R.anim.backfinish).toBundle();
     	           startActivity(previous, bndlanimation);
            Log.i("tag", "Left to right");
            finish();
            return true; // Left to right
        }
        return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		Intent in = new Intent(StatusBar.this, MainActivity.class);
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
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev){
	    super.dispatchTouchEvent(ev);    
	    return gestureDetector.onTouchEvent(ev); 
	}

}
