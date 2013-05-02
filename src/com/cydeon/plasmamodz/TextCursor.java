package com.cydeon.plasmamodz;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TextCursor extends Activity implements OnClickListener, OnLongClickListener, OnGestureListener{

	private GestureDetector gestureDetector;
	private static final int SWIPE_MIN_DISTANCE = 150;
	private static final int SWIPE_THRESHOLD_VELOCITY = 100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themes);
		TextView ee = (TextView) findViewById(R.id.tvEasterEgg);
		ee.setVisibility(View.GONE);
		
		RelativeLayout r1 = (RelativeLayout) findViewById(R.id.myLayout);
		gestureDetector = new GestureDetector(this, this);
		OnTouchListener gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};

		r1.setOnTouchListener(gestureListener);
		 
		int [] viewIds = new int [] {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10};
			for(int i = 0; i < viewIds.length; i++){
				View v = findViewById(viewIds[i]);
				if (v != null) {
					v.setVisibility(0);
				}
			}
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		Button cursorBlack = (Button) findViewById(R.id.b1);
		cursorBlack.setBackgroundResource(R.drawable.textc_black);
		Button cursorBlue = (Button) findViewById(R.id.b2);
		cursorBlue.setBackgroundResource(R.drawable.textc_blue);
		Button cursorGray = (Button) findViewById(R.id.b3);
		cursorGray.setBackgroundResource(R.drawable.textc_white);
		Button cursorGreen = (Button) findViewById(R.id.b4);
		cursorGreen.setBackgroundResource(R.drawable.textc_green);
		Button cursorYellow = (Button) findViewById(R.id.b5);
		cursorYellow.setBackgroundResource(R.drawable.textc_yellow);
		Button cursorOrange = (Button) findViewById(R.id.b6);
		cursorOrange.setBackgroundResource(R.drawable.textc_orange);
		Button cursorPink = (Button) findViewById(R.id.b7);
		cursorPink.setBackgroundResource(R.drawable.textc_pink);
		Button cursorPurple = (Button) findViewById(R.id.b8);
		cursorPurple.setBackgroundResource(R.drawable.textc_purple);
		Button cursorLightBlue = (Button) findViewById(R.id.b9);
		cursorLightBlue.setBackgroundResource(R.drawable.textc_lightblue);
		Button cursorRed = (Button) findViewById(R.id.b10);
		cursorRed.setBackgroundResource(R.drawable.textc_red);
		
		for(int i = 0; i < viewIds.length; i++){
			View v = findViewById(viewIds[i]);
			if (v != null) {
				v.setOnClickListener(this);
			}
		}
		for(int i = 0; i < viewIds.length; i++){
			View v = findViewById(viewIds[i]);
			if (v != null) {
				v.setOnLongClickListener(this);
			}
		}
	}

	@Override
	public void onClick(View arg0) {
		Intent install = new Intent(TextCursor.this, Download.class);
		if (arg0.getId() == R.id.b1) {
			install.putExtra("CursorBlack", "cursorblack");
			startActivity(install);
		}else if (arg0.getId() == R.id.b2){
			install.putExtra("CursorBlue", "cursorblue");
			startActivity(install);
		}else if (arg0.getId() == R.id.b3){
			install.putExtra("CursorGray", "cursorGray");
			startActivity(install);
		}else if (arg0.getId() == R.id.b4){
			install.putExtra("CursorGreen", "cursorgreen");
			startActivity(install);
		}else if (arg0.getId() == R.id.b5){
			install.putExtra("CursorYellow", "cursoryellow");
			startActivity(install);
		}else if (arg0.getId() == R.id.b6){
			install.putExtra("CursorOrange", "cursororange");
			startActivity(install);
		}else if (arg0.getId() == R.id.b7){
			install.putExtra("CursorPink", "cursorpink");
			startActivity(install);
		}else if (arg0.getId() == R.id.b8){
			install.putExtra("CursorPurple", "cursorpurple");
			startActivity(install);
		}else if (arg0.getId() == R.id.b9){
			install.putExtra("CursorLightBlue", "cursorlightblue");
			startActivity(install);
		}else if (arg0.getId() == R.id.b10){
			install.putExtra("CursorRed", "cursorred");
			startActivity(install);
		}
		overridePendingTransition (0 , R.anim.slide_up);
	}
	
	@Override
	public boolean onLongClick(View arg0) {
		TextView ee = (TextView) findViewById(R.id.tvEasterEgg);
		if (arg0.getId() == R.id.b4){
			ee.setVisibility(View.VISIBLE);
			ee.setText("Whoah! You just found an Easter Egg! You sly dog!");
		}
		return false;
	}
	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
            float velocityY) {
        if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
        	
        	Toast.makeText(TextCursor.this, "You can't do that!", Toast.LENGTH_SHORT).show();
            return true; // Right to left

        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

        	Intent previous = new Intent(TextCursor.this, Lock.class);
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
	public void onLongPress(MotionEvent arg0) {
		Intent home = new Intent(TextCursor.this, MainActivity.class);
		startActivity(home);
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
