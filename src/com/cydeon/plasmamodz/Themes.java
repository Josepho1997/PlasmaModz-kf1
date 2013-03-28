package com.cydeon.plasmamodz;

import java.io.File;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Themes extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themes);
		
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
		
	}

}
