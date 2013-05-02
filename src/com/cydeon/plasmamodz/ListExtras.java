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
	

	
	String[] random = {"Enable USB Debugging", "Restore Boot Animation", "CRT Electron Beam Animation"};
	
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
		Intent usb = new Intent(getActivity(), ExtraDialogs.class);
		
	switch(position){
	case 0:
		usb.putExtra("USB", "usb");
		break;
	case 1:
		usb.putExtra("Restore", "restore");
		break;
	case 2:
		usb.putExtra("CRT", "crt");
		break;
	}
	startActivity(usb);
	}
}
