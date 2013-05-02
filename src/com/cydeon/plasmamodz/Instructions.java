package com.cydeon.plasmamodz;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Instructions extends Activity {
		
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.intro);
		TextView introView = (TextView) findViewById(R.id.tvIntro);
		final Typeface intro = Typeface.createFromAsset(getAssets(), "xpressive.ttf");
		introView.setTypeface(intro);
		TextView introView2 = (TextView) findViewById(R.id.tvIntro2);
		introView2.setTypeface(intro);
		Button bIntro = (Button) findViewById(R.id.bIntro);
		bIntro.getBackground().setColorFilter(0xFF0099cc,
				PorterDuff.Mode.MULTIPLY);
		bIntro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			setContentView(R.layout.intro2);
			TextView modView = (TextView) findViewById(R.id.tvMod);
			modView.setTypeface(intro);
			Button bMod = (Button) findViewById(R.id.bMod);
			bMod.getBackground().setColorFilter(0xFF0099cc, PorterDuff.Mode.MULTIPLY);
			bMod.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent(Instructions.this, Themes.class);
					Bundle bndlanimation =
		        	       	   ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.blank,R.anim.blank).toBundle();
		        	           startActivity(i, bndlanimation);
				}
			});
			}
		});
	}
	
	/*
	package com.cydeon.plasmamodz;

	import android.app.Activity;
	import android.os.Bundle;
	import android.view.Window;
	import android.view.WindowManager;

	public class Instro extends Activity{
		
		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.intro2);
		}
	}

*/
	

}

