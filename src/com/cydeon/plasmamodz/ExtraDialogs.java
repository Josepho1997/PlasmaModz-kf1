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
	String usb = null;
	String boot = null;
	String crt = null;
	
	private class DownloadFile extends AsyncTask<String, Integer, String>{
		@Override
		protected String doInBackground(String... sURL) {
			try{
				URL url = new URL(sURL[0]);
				URLConnection connection = url.openConnection();
				connection.connect();
				int fileLength = connection.getContentLength(); 
				
				InputStream input = new BufferedInputStream(url.openStream());
				OutputStream output = new FileOutputStream("/sdcard/plasma/" + fileName);
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
					
			if(usb != null){
				Toast.makeText(ExtraDialogs.this, "Enabling USB Debugging", Toast.LENGTH_SHORT).show();
			CommandCapture command = new CommandCapture(0, "su", "setprop persist.sys.usb.config mass_storage");
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
			} //end of usb if statement
			
			if(boot != null){
				Toast.makeText(ExtraDialogs.this, "Restoring Boot Animation", Toast.LENGTH_SHORT).show();
			CommandCapture command = new CommandCapture(0, "su", "#!/system/bin/sh", "busybox mount -o remount, rw /system", "cd /sdcard/plasma/boot/bkup", "mv bootanimation.zip /sdcard/plasma", "mv /system/media/bootanimation.zip /sdcard/plasma/boot/bkup/", "mv /sdcard/plasma/bootanimation.zip /system/media/", "chmod 644 /system/media/bootanimation.zip");
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
			} //end of boot if statement
			
			if(crt != null){
				Toast.makeText(ExtraDialogs.this, "Downloading/Installing CRT Electron Beam Animation", Toast.LENGTH_SHORT).show();
				CommandCapture command = new CommandCapture(0, "su", "#!/system/bin/sh", "busybox mount -o remount, rw /system", "cd /sdcard/plasma/", "cp /system/framework/framework-res.apk /sdcard/plasma", "wait 3", "mv /sdcard/Download/resources.arsc /sdcard/plasma/", "wait 2", "zip -r framework-res.apk resources.arsc", "wait 3", "mv framework-res.apk frame.apk", "wait 3", "zipalign -v 4 frame.apk framework-res.apk", "wait 3", "cp framework-res.apk /system/framework", "chmod 644 /system/framework/framework-res.apk", "rm resources.arsc", "rm framework-res.apk", "busybox killall system_server");
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
				} //end of crt if statement
			}
		}
	    
		ProgressDialog mProgressDialog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle battery;
		battery = getIntent().getExtras();
		final String usb = battery.getString("USB");
		final String restore = battery.getString("Restore");
		final String crt = battery.getString("CRT");
		mProgressDialog = new ProgressDialog(ExtraDialogs.this);
		mProgressDialog.setIndeterminate(false);
		mProgressDialog.setMax(100);
		mProgressDialog.setMessage("Downloading " + fileName);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressDialog.setCancelable(false);
		if(usb != null){
			startUSB();
		}else if (restore != null){
			startRestore();
		}else if (crt != null){
			startCRT();
		}
	}
	
	public void startUSB(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		alertDialogBuilder.setTitle("Enable USB Debugging?");
		 
		alertDialogBuilder
			.setMessage("Are you sure that you want to enable USB Debugging?")
			.setCancelable(false)
			.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					usb = "notnull";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
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
	
	public void startRestore(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		alertDialogBuilder.setTitle("Restore Boot Animation?");
		 
		alertDialogBuilder
			.setMessage("Are you sure that you want to restore your previous boot animation?")
			.setCancelable(false)
			.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					boot = "notnull";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
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
	
	public void startCRT(){
		fileName = "resources.arsc";
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		alertDialogBuilder.setTitle("Enable CRT Electron Beam Animation");
		 
		alertDialogBuilder
			.setMessage("Are you sure that you want to enable CRT Electron Beam Animation?")
			.setCancelable(false)
			.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropbox.com/s/bgmgxwl06duga57/resources.arsc");
					crt = "notnull";
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

