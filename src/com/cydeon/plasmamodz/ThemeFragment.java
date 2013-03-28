package com.cydeon.plasmamodz;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.cydeon.plasmamodz.R;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThemeFragment extends Fragment {


	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.theme_frag,
	            container, false);
	    Button button = (Button) view.findViewById(R.id.button1);
	    button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (arg0.getId() == R.id.button1) {
					Intent intent = new Intent(getActivity(), Themes.class);
					ThemeFragment.this.startActivity(intent);
				}
				}
		});
	    
		return view;
	}}