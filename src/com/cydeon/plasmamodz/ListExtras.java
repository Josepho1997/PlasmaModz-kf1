package com.cydeon.plasmamodz;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeoutException;

import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListExtras extends ListFragment {

	String crt = null;
	

	
	String[] random = {"Enable CRT Animation", "Restore Boot Animation", "Dance"};
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
		return inflater.inflate(R.layout.extras, container, false);
	}
	
	@Override 
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, random));
		
		
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
	
		
	switch(position){
	case 0:
		Intent crt = new Intent(getActivity(), ExtraDialogs.class);
		crt.putExtra("CRT", "crt");
		startActivity(crt);
		break;
	case 1:
		Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
		break;
	case 2:
		Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
		break;
	}
	}
}
