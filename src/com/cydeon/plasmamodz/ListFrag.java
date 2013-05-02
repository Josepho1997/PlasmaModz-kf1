package com.cydeon.plasmamodz;

import java.io.File;
import java.io.IOException;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class ListFrag extends Fragment implements OnClickListener{

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 View view = inflater.inflate(R.layout.boot_frag,
		            container, false);
		 Button select = (Button) view.findViewById(R.id.bSelect);
		 select.setVisibility(View.GONE);
		 Button lists = (Button) view.findViewById(R.id.bListS);
		 lists.setVisibility(View.VISIBLE);
		 lists.setOnClickListener(this);
		 ImageView image = (ImageView) view.findViewById(R.id.ivShort);
		 image.setVisibility(View.VISIBLE);
		 File show = new File(Environment.getExternalStorageDirectory() + "/plasma/boot/show");
		 
		 if(show.exists()){
		    //Do nothing. Directory is existent	
		    }else{
		    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
	 		alertDialogBuilder.setTitle("Shortcuts");
	 		 
	 		alertDialogBuilder
	 			.setMessage("Shortcuts are used for ease of access to a specific mod. Say, you installed your theme, and find out you choose the wrong softkeys. Oh noes! Now what do you do? You don't want to have to remake the entire them again. That's where shortcuts come in. Click on any of these shortcuts and it'll lead you automatically to that page's mods. Once you download the desired mod, simply hold down on the part of the screen that is white and you'll return back to this page. Then you can select installer and install that specific mod!")
	 			.setCancelable(false)
	 			.setPositiveButton(R.string.aboutAppButton,new DialogInterface.OnClickListener() {
	 				public void onClick(DialogInterface dialog,int id) {
	 					
	 				}
	 			  });

	 			AlertDialog alertDialog = alertDialogBuilder.create();

	 			alertDialog.show();
		    try {
				show.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    }	
		 return view;
		 
}

	@Override
	public void onClick(View arg0) {
		if (arg0.getId() == R.id.bListS) {
			Intent i = new Intent(getActivity(), ListShort1.class);
			startActivity(i);
		}
	}
	
}
