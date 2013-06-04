package com.cydeon.plasmamodz;

import java.io.IOException;
import java.util.List;

import com.tezlastorme.buildprop.BuildProp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import framework.BuilderProp;

public class BuildPropEditor extends ListActivity{
	
	List<String> tests;
	String[] tested;
	//String eInput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			tests = BuilderProp.getPropArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
	}
	
	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	      MenuInflater menuInflater = getMenuInflater();
	      menuInflater.inflate(R.layout.menu, menu);
	      return true;
	  	}
	
	 @Override
	  public boolean onOptionsItemSelected(MenuItem item)
	  {

	      switch (item.getItemId())
	      {
	      case R.id.menu_Refresh:
	    	  finish();
	    	  Intent intent = getIntent();
	    	    overridePendingTransition(0, 0);
	    	    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

	    	    overridePendingTransition(0, 0);
	    	    startActivity(intent);
	          return true;
	          
	      default:
	          return super.onOptionsItemSelected(item);
	      }
	  }  
	
	
	@Override
	public void onListItemClick(ListView list, View view, int position, long id){
		super.onListItemClick(list, view, position, id);
		String[] test = tests.toArray(new String[tests.size()]);
		String testName = test[position];
		tested = testName.split("\\=");
		Toast.makeText(this, tested[0], Toast.LENGTH_SHORT).show();
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		final EditText input = new EditText(this);
		alertDialogBuilder
		
			//.setMessage(tested[0] + "=" + tested[1])
			.setCancelable(false);
			alertDialogBuilder.setPositiveButton("Save",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				String eInput = input.getText().toString();
				//Toast.makeText(BuildPropEditor.this, eInput, Toast.LENGTH_LONG).show();
				BuildProp.setProp(tested[0], eInput);
			}
		  });
			alertDialogBuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				
			}
		});

			AlertDialog alertDialog = alertDialogBuilder.create();
		    input.setHint(tested[1]);
		    input.setLeft(50);
		    alertDialog.setTitle(tested[0]); 
		    alertDialog.setMessage(tested[0]);
		    alertDialog.setView(input);
		   //eInput = input.getText().toString();
			
			alertDialog.show();
			
			
	/*	try {
			Class clazz = Class
					.forName("com.cydeon.androidgames." + testName);
			Intent intent = new Intent(this, clazz);
			startActivity(intent);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} */
	}


}
