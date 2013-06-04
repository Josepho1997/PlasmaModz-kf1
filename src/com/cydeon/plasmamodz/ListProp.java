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

public class ListProp extends Fragment implements OnClickListener{

	
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
		 return view;
		 
}

	@Override
	public void onClick(View arg0) {
		if (arg0.getId() == R.id.bListS) {
			Intent i = new Intent(getActivity(), BuildPropEditor.class);
			startActivity(i);
		}
	}
	
}
