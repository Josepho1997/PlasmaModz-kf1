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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;


public class ExtraDialogs extends Activity{

	String fileName;
	final Context context = this;
	
	private class DownloadFile extends AsyncTask<String, Integer, String>{
		@Override
		protected String doInBackground(String... sURL) {
			try{
				URL url = new URL(sURL[0]);
				URLConnection connection = url.openConnection();
				connection.connect();
				int fileLength = connection.getContentLength();
				
				InputStream input = new BufferedInputStream(url.openStream());
				OutputStream output = new FileOutputStream("/sdcard/plasma/boot/crtanim");
				byte data[] = new byte[1024];
				long total = 0;
				int count;
				while ((count = input.read(data)) != -1) {
					total += count;
					publishProgress((int) (total * 100/fileLength));
					output.write(data, 0, count);
					}
					
				output.flush();
				output.close();
				input.close();
				
		} catch (Exception e) {
			
		}
		return null;
			}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog.show();
		}
		
		@Override
		protected void onProgressUpdate(Integer... progress){
			super.onProgressUpdate(progress);
			mProgressDialog.setProgress(progress[0]);
			
			
			
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			mProgressDialog.dismiss();
			Context context = getApplicationContext();
			CharSequence text = "Installing " + fileName;
			int duration = Toast.LENGTH_SHORT;
				
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			CommandCapture command = new CommandCapture(0, "su");
			try {
				RootTools.getShell(true).add(command).waitForFinish();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (RootDeniedException e) {
				e.printStackTrace();
			}
			} //end of if statement
		}
	    
		ProgressDialog mProgressDialog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle battery;
		battery = getIntent().getExtras();
		final String crt = battery.getString("CRT");
		mProgressDialog = new ProgressDialog(ExtraDialogs.this);
		mProgressDialog.setIndeterminate(false);
		mProgressDialog.setMax(100);
		mProgressDialog.setMessage("Downloading " + fileName);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressDialog.setCancelable(false);
		if(crt != null){
			startCRT();
		}
	}
	
	public void startCRT(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		alertDialogBuilder.setTitle("Install CRT Beam Off Animation?");
		 
		alertDialogBuilder
			.setMessage("Are you sure that you want to install CRT Beam Off Animation?")
			.setCancelable(false)
			.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					ExtraDialogs.this.finish();
				}
			  })
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					ExtraDialogs.this.finish();
				}
			});

			AlertDialog alertDialog = alertDialogBuilder.create();

			alertDialog.show();
	}
	
}

