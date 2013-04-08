package com.cydeon.plasmamodz;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StatusBar extends Activity implements OnClickListener{

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statusbar);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
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
	}

}
