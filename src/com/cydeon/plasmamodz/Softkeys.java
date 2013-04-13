package com.cydeon.plasmamodz;

import java.io.File;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.os.*;


public class Softkeys extends Activity implements OnClickListener, OnGestureListener{

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

			int [] viewIds = new int [] {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10, R.id.b11, R.id.b12, R.id.b13, R.id.b13, R.id.b14, R.id.b15, R.id.b16, R.id.b17, R.id.b18, R.id.b19, R.id.b20, R.id.b21, R.id.b22, R.id.b23, R.id.b24, R.id.b25, R.id.b26, R.id.b27, R.id.b28, R.id.b29, R.id.b30};
			for(int i = 0; i < viewIds.length; i++){
				View v = findViewById(viewIds[i]);
				if (v != null) {
					v.setVisibility(0);
				}
			}
			Button stock = (Button) findViewById(R.id.b1);
			stock.setBackgroundResource(R.drawable.soft_stock);
			Button stockBlue = (Button) findViewById(R.id.b2);
			stockBlue.setBackgroundResource(R.drawable.soft_stock_blue);
			Button green = (Button) findViewById(R.id.b3);
			green.setBackgroundResource(R.drawable.soft_green);
			Button pink = (Button) findViewById(R.id.b4);
			pink.setBackgroundResource(R.drawable.soft_pink);
			Button purple = (Button) findViewById(R.id.b5);
			purple.setBackgroundResource(R.drawable.soft_purple);
			Button yellow = (Button) findViewById(R.id.b6);
			yellow.setBackgroundResource(R.drawable.soft_yellow);
			Button red = (Button) findViewById(R.id.b7);
			red.setBackgroundResource(R.drawable.soft_red);
			Button galaxy = (Button) findViewById(R.id.b8);
			galaxy.setBackgroundResource(R.drawable.soft_galaxy);
			Button galaxyBlue = (Button) findViewById(R.id.b9);
			galaxyBlue.setBackgroundResource(R.drawable.soft_galaxy_blue);
			Button reflect = (Button) findViewById(R.id.b10);
			reflect.setBackgroundResource(R.drawable.soft_reflect);
			Button reflectBlue = (Button) findViewById(R.id.b11);
			reflectBlue.setBackgroundResource(R.drawable.soft_reflect_blue);
			Button razor = (Button) findViewById(R.id.b12);
			razor.setBackgroundResource(R.drawable.soft_razor);
			Button razorBlue = (Button) findViewById(R.id.b13);
			razorBlue.setBackgroundResource(R.drawable.soft_razor_blue);
			Button small = (Button) findViewById(R.id.b14);
			small.setBackgroundResource(R.drawable.soft_small);
			Button smallBlue = (Button) findViewById(R.id.b15);
			smallBlue.setBackgroundResource(R.drawable.soft_small_blue);
			Button smallReflect = (Button) findViewById(R.id.b16);
			smallReflect.setBackgroundResource(R.drawable.soft_small_reflect);
			Button smallReflectBlue = (Button) findViewById(R.id.b17);
			smallReflectBlue.setBackgroundResource(R.drawable.soft_small_reflect_blue);
			Button xperia = (Button) findViewById(R.id.b18);
			xperia.setBackgroundResource(R.drawable.soft_xperia);
			Button blueXperia = (Button) findViewById(R.id.b19);
			blueXperia.setBackgroundResource(R.drawable.soft_xperia_blue);
			Button zte = (Button) findViewById(R.id.b20);
			zte.setBackgroundResource(R.drawable.soft_zte);
			Button zteBlue = (Button) findViewById(R.id.b21);
			zteBlue.setBackgroundResource(R.drawable.soft_zte_blue);
			Button college = (Button) findViewById(R.id.b22);
			college.setBackgroundResource(R.drawable.soft_college);
			Button collegeBlue = (Button) findViewById(R.id.b23);
			collegeBlue.setBackgroundResource(R.drawable.soft_college_blue);
			Button defused = (Button) findViewById(R.id.b24);
			defused.setBackgroundResource(R.drawable.soft_defused);
			Button defusedBlue = (Button) findViewById(R.id.b25);
			defusedBlue.setBackgroundResource(R.drawable.soft_defused_blue);
			Button droid = (Button) findViewById(R.id.b26);
			droid.setBackgroundResource(R.drawable.soft_droid);
			Button droidBlue = (Button) findViewById(R.id.b27);
			droidBlue.setBackgroundResource(R.drawable.soft_droid_blue);
			Button pixel = (Button) findViewById(R.id.b28);
			pixel.setBackgroundResource(R.drawable.soft_pixel);
			Button pixelBlue = (Button) findViewById(R.id.b29);
			pixelBlue.setBackgroundResource(R.drawable.soft_pixel_blue);
			Button facebook = (Button) findViewById(R.id.b30);
			facebook.setBackgroundResource(R.drawable.soft_facebook);
			int [] viewIds2 = new int [] {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10, R.id.b11, R.id.b12, R.id.b13, R.id.b13, R.id.b14, R.id.b15, R.id.b16, R.id.b17, R.id.b18, R.id.b19, R.id.b20, R.id.b21, R.id.b22, R.id.b23, R.id.b24, R.id.b25, R.id.b26, R.id.b27, R.id.b28, R.id.b29, R.id.b30};
			for(int i = 0; i < viewIds2.length; i++){
				View v = findViewById(viewIds2[i]);
				if (v != null) {
					v.setOnClickListener(this);
				}
			}
				
			}

	@Override
	public void onClick(View arg0) {
		Intent a = new Intent(Softkeys.this, Bmod.class);
		if (arg0.getId() == R.id.b1) {
			a.putExtra("Stock", "stock");
			startActivity(a);
		} else if (arg0.getId() == R.id.b2) {
			a.putExtra("StockBlue", "stockblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b3) {
			a.putExtra("Green", "green");
			startActivity(a);
		} else if (arg0.getId() == R.id.b4) {
			a.putExtra("Pink", "pink");
			startActivity(a);
		} else if (arg0.getId() == R.id.b5) {
			a.putExtra("Purple", "purple");
			startActivity(a);
		} else if (arg0.getId() == R.id.b6) {
			a.putExtra("Yellow", "yellow");
			startActivity(a);
		} else if (arg0.getId() == R.id.b7) {
			a.putExtra("Red", "red");
			startActivity(a);
		} else if (arg0.getId() == R.id.b8) {
			a.putExtra("Galaxy", "galaxy");
			startActivity(a);
		} else if (arg0.getId() == R.id.b9) {
			a.putExtra("GalaxyBlue", "galaxyblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b10) {
			a.putExtra("Reflect", "Reflect");
			startActivity(a);
		} else if (arg0.getId() == R.id.b11) {
			a.putExtra("ReflectBlue", "reflect");
			startActivity(a);
		} else if (arg0.getId() == R.id.b12) {
			a.putExtra("Razor", "razor");
			startActivity(a);
		} else if (arg0.getId() == R.id.b13) {
			a.putExtra("RazorBlue", "razorblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b14) {
			a.putExtra("Small", "small");
			startActivity(a);
		} else if (arg0.getId() == R.id.b15) {
			a.putExtra("SmallBlue", "smallblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b16) {
			a.putExtra("SmallReflect", "smallreflect");
			startActivity(a);
		} else if (arg0.getId() == R.id.b17) {
			a.putExtra("SmallReflectBlue", "smallreflectblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b18) {
			a.putExtra("Xperia", "xperia");
			startActivity(a);
		} else if (arg0.getId() == R.id.b19) {
			a.putExtra("XperiaBlue", "xperiablue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b20) {
			a.putExtra("Zte", "zte");
			startActivity(a);
		} else if (arg0.getId() == R.id.b21) {
			a.putExtra("ZteBlue", "zteblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b22) {
			a.putExtra("College", "college");
			startActivity(a);
		} else if (arg0.getId() == R.id.b23) {
			a.putExtra("CollegeBlue", "collegeblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b24) {
			a.putExtra("Defused", "defused");
			startActivity(a);
		} else if (arg0.getId() == R.id.b25) {
			a.putExtra("DefusedBlue", "defusedblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b26) {
			a.putExtra("Droid", "droid");
			startActivity(a);
		} else if (arg0.getId() == R.id.b27) {
			a.putExtra("DroidBlue", "droidblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b28) {
			a.putExtra("Pixel", "pixel");
			startActivity(a);
		} else if (arg0.getId() == R.id.b29) {
			a.putExtra("PixelBlue", "pixelsblue");
			startActivity(a);
		} else if (arg0.getId() == R.id.b30){
			a.putExtra("Facebook", "facebook");
			startActivity(a);
		}

	
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
        	
           Intent next = new Intent(Softkeys.this, Wifi.class);
           Bundle bndlanimation =
       	   ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.leftr,R.anim.rightl).toBundle();
           startActivity(next, bndlanimation);
           finish();
            return true; // Right to left

        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

        	Intent previous = new Intent(Softkeys.this, Themes.class);
        	 Bundle bndlanimation =
        				ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.back,R.anim.backfinish).toBundle();
        	           startActivity(previous, bndlanimation);
        	           finish();
            return true; // Left to right
        }
        return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		Intent in = new Intent(Softkeys.this, MainActivity.class);
		startActivity(in);
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
	
	@Override
	public boolean onTouchEvent(MotionEvent me) {
	return gestureDetector.onTouchEvent(me);
	}
}
