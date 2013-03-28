	package com.cydeon.plasmamodz;

	import com.stericson.RootTools.*;
	import com.stericson.RootTools.exceptions.RootDeniedException;
	import com.stericson.RootTools.execution.CommandCapture;

	import java.io.BufferedInputStream;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.OutputStream;
	import java.io.Reader;
	import java.net.URL;
	import java.net.URLConnection;
	import java.util.concurrent.TimeoutException;

	import com.cydeon.plasmamodz.R;

	import android.app.ActionBar;
	import android.app.Activity;
	import android.app.ProgressDialog;
	import android.content.Context;
	import android.os.AsyncTask;
	import android.os.Bundle;
import android.view.LayoutInflater;
	import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
	import android.widget.Button;
	import android.widget.ImageView;
	import android.widget.TextView;
import android.widget.Toast;

	public class Boots extends ArrayAdapter<String> {
		private final Context context;
		private final String[] values;
	 
		public Boots(Context context, String[] values) {
			super(context, R.layout.list_boot, values);
			this.context = context;
			this.values = values;
		}
	 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.list_boot, parent, false);
			TextView textView = (TextView) rowView.findViewById(R.id.label);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
			textView.setText(values[position]);
	 
			// Change icon based on name
			String s = values[position];
	 
			System.out.println(s);
	 
			if (s.equals("Android")) {
				imageView.setImageResource(R.drawable.android);
			} else if (s.equals("Dragon Ball")) {
				imageView.setImageResource(R.drawable.dotted);
			} else if (s.equals("JellyBean")) {
				imageView.setImageResource(R.drawable.soft_galaxy);
			} else {
				imageView.setImageResource(R.drawable.default_img);
			}
	 
			return rowView;
		}
	}