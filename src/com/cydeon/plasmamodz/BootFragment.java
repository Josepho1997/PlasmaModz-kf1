package com.cydeon.plasmamodz;

import java.io.File;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class BootFragment extends Fragment implements OnClickListener {{


		//Defining File Directory
	    File directory = new File(Environment.getExternalStorageDirectory() + "/plasma/boot");
	    if(directory.exists() && directory.isDirectory()){
	    //Do nothing. Directory is existent	
	    }else{
	    //Directory does not exist. Make directory (First time app users)
	    directory.mkdirs();
	    }
		
	    File bkup = new File(Environment.getExternalStorageDirectory() + "/plasma/boot/bkup");
	    if(bkup.exists() && bkup.isDirectory()){
	    //Do nothing. Directory is existent	
	    }else{
	    //Directory does not exist. Make directory (First time app users)
	    bkup.mkdirs();
	    }}
	
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 View view = inflater.inflate(R.layout.boot_frag,
		            container, false);
		 Button select = (Button) view.findViewById(R.id.bSelect);
		 Button restore = (Button) view.findViewById(R.id.bRestore);
		 
		 select.setOnClickListener(this);
		 restore.setOnClickListener(this);
		return view;
}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.bSelect) {
			Intent a = new Intent(getActivity(), Boots1.class);
			BootFragment.this.startActivity(a);
		} else if (v.getId() == R.id.bRestore) {
			Intent i = new Intent(getActivity(), Install.class);
			BootFragment.this.startActivity(i);
		}
	}

}