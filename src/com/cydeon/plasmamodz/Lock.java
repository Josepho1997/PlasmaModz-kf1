package com.cydeon.plasmamodz;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Lock extends Activity implements OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themes);
		    
		    ActionBar actionBar = getActionBar();
			actionBar.hide();
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
	}

}
