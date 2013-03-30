	package com.cydeon.plasmamodz;

	import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
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
			ImageView imageViewP = (ImageView) rowView.findViewById(R.id.logoP);
			ImageView imageViewL = (ImageView) rowView.findViewById(R.id.logoL);
			textView.setText(values[position]);
	 
			String s = values[position];
	 
			System.out.println(s);
	 
			if (s.equals("Android")) {
				UrlImageViewHelper.setUrlDrawable(imageViewP, "https://dl.dropbox.com/s/rwcd8ma0oiecddq/0033.png", R.drawable.default_img, 60000);	
			} else if (s.equals("Dragon Ball")) {
				UrlImageViewHelper.setUrlDrawable(imageViewL, "https://dl.dropbox.com/s/4p33hsydhkv4kgn/dragon_boot.png", R.drawable.default_img, 60000);	
			} else if (s.equals("GameBoy")){
				UrlImageViewHelper.setUrlDrawable(imageViewL, "https://dl.dropbox.com/s/49ke2m2gyeggakk/gameboy_boot.png", R.drawable.default_img, 60000);	
			} else if (s.equals("GameCube")){
				UrlImageViewHelper.setUrlDrawable(imageViewL, "https://dl.dropbox.com/s/5wavzwvjsatv5bh/gamecube_boot.png", R.drawable.default_img, 60000);	
			} else if (s.equals("Nexus")){
				UrlImageViewHelper.setUrlDrawable(imageViewP, "https://dl.dropbox.com/s/0vg7pn3yz6ql2v7/nexus_boot.png", R.drawable.default_img, 60000);	
			} else if (s.equals("The Nightmare Before Christmas")){
				UrlImageViewHelper.setUrlDrawable(imageViewL, "https://dl.dropbox.com/s/0qhgb8fnws9dsbp/nmbc_boot.png", R.drawable.default_img, 60000);	
			} else if (s.equals("Xbox")){
				UrlImageViewHelper.setUrlDrawable(imageViewL, "https://dl.dropbox.com/s/6a1z0e9rz6iomii/xbox_boot_new.png", R.drawable.default_img, 60000);	
			} else if (s.equals("Xbox 1")){
				UrlImageViewHelper.setUrlDrawable(imageViewL, "https://dl.dropbox.com/s/r8x47wc0mj7mhd8/boot_xbox_old.png", R.drawable.default_img, 60000);	
			}
	 
			return rowView;
		}
	}