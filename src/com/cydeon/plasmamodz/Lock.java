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

public class Lock extends Activity implements OnClickListener, OnGestureListener{

	 private GestureDetector gestureDetector;
	 private static final int SWIPE_MIN_DISTANCE = 150;
	    private static final int SWIPE_THRESHOLD_VELOCITY = 100;

	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themes);
		    
		    ActionBar actionBar = getActionBar();
			actionBar.hide();
			
			RelativeLayout ll = (RelativeLayout) findViewById(R.id.myLayout);
		    gestureDetector = new GestureDetector(this, this);
		    OnTouchListener gestureListener = new View.OnTouchListener() {
		        public boolean onTouch(View v, MotionEvent event) {
		            return gestureDetector.onTouchEvent(event);
		        }
		    };

		    ll.setOnTouchListener(gestureListener);
		    
		    
			
			int [] viewIds = new int [] {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5};
			
			for(int i = 0; i < viewIds.length; i++){
				View v = findViewById(viewIds[i]);
				if (v != null) {
					v.setVisibility(0);
				}
			}
			
			Button lockstock = (Button) findViewById(R.id.b1);
			lockstock.setBackgroundResource(R.drawable.lockstock);
			Button lockgreen = (Button) findViewById(R.id.b2);
			lockgreen.setBackgroundResource(R.drawable.lockgreen);
			Button lockblue = (Button) findViewById(R.id.b3);
			lockblue.setBackgroundResource(R.drawable.lockblue);
			Button lockred = (Button) findViewById(R.id.b4);
			lockred.setBackgroundResource(R.drawable.lockred);
			Button lockorange = (Button) findViewById(R.id.b5);
			lockorange.setBackgroundResource(R.drawable.lockorange);
			
			for(int i = 0; i < viewIds.length; i++){
				View v = findViewById(viewIds[i]);
				if (v != null) {
					v.setOnClickListener(this);
				}
			}
			
	}

	@Override
	public void onClick(View arg0) {
		Intent a = new Intent(Lock.this, Download.class);
		if (arg0.getId() == R.id.b1) {
			a.putExtra("LockStock", "lockstock");
		}else if (arg0.getId() == R.id.b2){
			a.putExtra("LockGreen", "lockgreen");
		}else if (arg0.getId() == R.id.b3){
			a.putExtra("LockBlue", "lockblue");
		}else if (arg0.getId() == R.id.b4){
			a.putExtra("LockRed", "lockred");
		}else if (arg0.getId() == R.id.b5){
			a.putExtra("LockOrange", "lockorange");
		}
		startActivity(a);
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

        	Intent next = new Intent(Lock.this, TextCursor.class);
        	Bundle bndlanimation =
        	       	   ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.leftr,R.anim.rightl).toBundle();
        	           startActivity(next, bndlanimation);
            Log.i("tag", "Right to left");
            finish();
            return true; // Right to left

        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
        	Intent previous = new Intent(Lock.this, StatusBar.class);
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
		// TODO Auto-generated method stub
		
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
