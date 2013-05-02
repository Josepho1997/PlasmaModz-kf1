package com.cydeon.plasmamodz;

import java.io.File;
import java.io.IOException;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
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

public class Themes extends Activity implements OnClickListener, OnGestureListener {
	
	private GestureDetector gestureDetector;
	private static final int SWIPE_MIN_DISTANCE = 150;
	private static final int SWIPE_THRESHOLD_VELOCITY = 100;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themes);
		
		File fIntro = new File("/sdcard/plasma/shown_intro");
		if(fIntro.exists()){
			
		}else{
			Intent i = new Intent(this, Instructions.class);
			startActivity(i);
			try {
				fIntro.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		RelativeLayout r1 = (RelativeLayout) findViewById(R.id.myLayout);
		gestureDetector = new GestureDetector(this, this);
		OnTouchListener gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};

		r1.setOnTouchListener(gestureListener);
		
		 File directory = new File(Environment.getExternalStorageDirectory() + "/plasma/downloads");
		    if(directory.exists() && directory.isDirectory()){
		    }else{
		    directory.mkdirs();
		    }
		    
		    int [] viewIds = new int [] {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10};
			for(int i = 0; i < viewIds.length; i++){
				View v = findViewById(viewIds[i]);
				if (v != null) {
					v.setVisibility(0);
				}
			}
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		Button android = (Button) findViewById(R.id.b4);
		android.setBackgroundResource(R.drawable.android);
		Button bluebox = (Button) findViewById(R.id.b5);
		bluebox.setBackgroundResource(R.drawable.bluebox);
		Button circlepercent = (Button) findViewById(R.id.b3);
		circlepercent.setBackgroundResource(R.drawable.circlepercent);
		Button circles = (Button) findViewById(R.id.b2);
		circles.setBackgroundResource(R.drawable.circles);
		Button digital = (Button) findViewById(R.id.b1);
		digital.setBackgroundResource(R.drawable.digital);
		Button dotted = (Button) findViewById(R.id.b10);
		dotted.setBackgroundResource(R.drawable.dotted);
		Button fullcircle1 = (Button) findViewById(R.id.b9);
		fullcircle1.setBackgroundResource(R.drawable.fullcircle1);
		Button fullcircle2 = (Button) findViewById(R.id.b8);
		fullcircle2.setBackgroundResource(R.drawable.fullcircle2);
		Button gauge = (Button) findViewById(R.id.b7);
		gauge.setBackgroundResource(R.drawable.gauge);
		Button honeycomb = (Button) findViewById(R.id.b6);
		honeycomb.setBackgroundResource(R.drawable.honeycomb);
		circlepercent.setOnClickListener(this);
		circles.setOnClickListener(this);
		digital.setOnClickListener(this);
		android.setOnClickListener(this);
		bluebox.setOnClickListener(this);
		dotted.setOnClickListener(this);
		fullcircle1.setOnClickListener(this);
		fullcircle2.setOnClickListener(this);
		gauge.setOnClickListener(this);
		honeycomb.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		if (arg0.getId() == R.id.b4) {
			Intent a = new Intent(Themes.this, Bmod.class);
			a.putExtra("Andy", "andy");
			startActivity(a);
		} else if (arg0.getId() == R.id.b5) {
			Intent b = new Intent(Themes.this, Bmod.class);
			b.putExtra("BlueBox", "bluebox");
			startActivity(b);
		} else if (arg0.getId() == R.id.b3) {
			Intent c = new Intent(Themes.this, Bmod.class);
			c.putExtra("CirclePercent", "circlepercent");
			startActivity(c);
		} else if (arg0.getId() == R.id.b2) {
			Intent d = new Intent(Themes.this, Bmod.class);
			d.putExtra("Circles", "circles");
			startActivity(d);
		} else if (arg0.getId() == R.id.b1) {
			Intent e = new Intent(Themes.this, Bmod.class);
			e.putExtra("Digital", "digital");
			startActivity(e);
		} else if (arg0.getId() == R.id.b10) {
			Intent f = new Intent(Themes.this, Bmod.class);
			f.putExtra("Dotted", "dotted");
			startActivity(f);
		} else if (arg0.getId() == R.id.b9) {
			Intent g = new Intent(Themes.this, Bmod.class);
			g.putExtra("FullCircle1", "fullcircle1");
			startActivity(g);
		} else if (arg0.getId() == R.id.b8) {
			Intent h = new Intent(Themes.this, Bmod.class);
			h.putExtra("FullCircle2", "fullcircle2");
			startActivity(h);
		} else if (arg0.getId() == R.id.b7) {
			Intent i = new Intent(Themes.this, Bmod.class);
			i.putExtra("Gauge", "guage");
			startActivity(i);
		} else if (arg0.getId() == R.id.b6) {
			Intent j = new Intent(Themes.this, Bmod.class);
			j.putExtra("Honeycomb", "honeycomb");
			startActivity(j);
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
        	
        	Intent next = new Intent(Themes.this, Softkeys.class);
        	Bundle bndlanimation =
        	       	   ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.leftr,R.anim.rightl).toBundle();
        	           startActivity(next, bndlanimation);
            Log.i("tag", "Right to left");
            finish();
            return true; // Right to left

        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

            Toast.makeText(this, "You can't do that!", Toast.LENGTH_SHORT).show();
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
