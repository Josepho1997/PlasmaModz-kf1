package com.cydeon.plasmamodz;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeoutException;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class BootAnimation extends Activity{
	
	String fileName;
	
	private class DownloadFile extends AsyncTask<String, Integer, String>{
		@Override
		protected String doInBackground(String... sURL) {
			try{
				URL url = new URL(sURL[0]);
				URLConnection connection = url.openConnection();
				connection.connect();
				//Shows 0-100% progress bar
				int fileLength = connection.getContentLength();
				
				//Download the file
				InputStream input = new BufferedInputStream(url.openStream());
				OutputStream output = new FileOutputStream("/sdcard/plasma/boot/bootanimation.zip");
				byte data[] = new byte[1024];
				long total = 0;
				int count;
				while ((count = input.read(data)) != -1) {
					total += count;
					//Publish the Progress
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
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			mProgressDialog.dismiss();
			Context context = getApplicationContext();
			CharSequence text = "Installing " + fileName;
			int duration = Toast.LENGTH_SHORT;
				
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			CommandCapture command = new CommandCapture(0, "su", "#!/system/bin/sh", "busybox mount -o remount, rw /system", "mkdir /sdcard/plasma/boot/bkup", "rm /sdcard/plasma/boot/bkup/bootanimation.zip", "mv /sdcard/plasma/boot/bootanimation.zip /sdcard/plasma", "cp /system/media/bootanimation.zip /sdcard/", "rm /system/media/bootanimation.zip", "cp /sdcard/plasma/bootanimation.zip /system/media/", "mv /sdcard/bootanimation.zip /sdcard/plasma/boot/bkup/", "rm /sdcard/plasma/bootanimation.zip", "chmod 644 /system/media/bootanimation.zip");
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
			Toast.makeText(BootAnimation.this, "Finished Installing " + fileName, Toast.LENGTH_SHORT).show();
		}
	}
	    
		ProgressDialog mProgressDialog;

	@Override
	 protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battery);
		ImageView batteryView = (ImageView) findViewById(R.id.ivBattery);
		
		
		Bundle battery;
		battery = getIntent().getExtras();
		final String android = battery.getString("Android");
		final String dragon = battery.getString("Dragon");
		final String gameboy = battery.getString("GameBoy");
		final String gamecube = battery.getString("GameCube");
		final String nexus = battery.getString("Nexus");
		final String nightmare = battery.getString("Nightmare");
		final String xbox = battery.getString("Xbox");
		final String xbox1 = battery.getString("Xbox1");
		
		
		if (android != null){
			fileName = "Android Boot Animation";
			UrlImageViewHelper.setUrlDrawable(batteryView, "https://dl.dropbox.com/s/kl2bbv7vp2sq9mh/0038.jpg", R.drawable.default_img, 60000);
		}else if (dragon != null){
			fileName = "Dragon Ball Boot Animation (46.35MB)";
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8158/7454334802_31641ae875_m.jpg", R.drawable.default_img, 60000);
		}else if (gameboy != null){
			fileName = "GameBoy Boot Animation";
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8153/7457111720_6d74056a02_m.jpg", R.drawable.default_img, 60000);
		}else if (gamecube != null){
			fileName = "GameCube Boot Animation";
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8015/7457111876_ca01535a4d_m.jpg", R.drawable.default_img, 60000);
		}else if (nexus != null){
			fileName = "Nexus Boot Animation";
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8149/7462059092_86088934b2_m.jpg", R.drawable.default_img, 60000);
		}else if (nightmare != null){
			fileName = "The Nightmare Before Christmas Boot Animation";
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8014/7490899268_6b812e99f4_m.jpg", R.drawable.default_img, 60000);
		}else if (xbox != null){
			fileName = "New Xbox Boot Animation";
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm8.staticflickr.com/7254/7457111536_4d1924a1d4_m.jpg", R.drawable.default_img, 60000);
		}else if (xbox1 != null){
			fileName = "Old Xbox Boot Animation";
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8012/7457111956_8ca4ee912f_m.jpg", R.drawable.default_img, 60000);
		}
		
		

		
		mProgressDialog = new ProgressDialog(BootAnimation.this);
		mProgressDialog.setIndeterminate(false);
		mProgressDialog.setMax(100);
		mProgressDialog.setMessage("Downloading " + fileName);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressDialog.setCancelable(false);
		Button bInstallB = (Button) findViewById(R.id.bInstallBattery);
		Button bReturnB = (Button) findViewById(R.id.bReturnBattery);
		bInstallB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (android != null){
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropbox.com/s/mqan6ly3g8t4r5j/bootanimation.zip");
				}if (dragon != null){
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropboxusercontent.com/s/qglugttuxbmc2r5/DBbootanimation.zip");
				}if (gameboy != null){
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropboxusercontent.com/s/u8ej23xbgb033n1/Gbootanimation.zip");
				}if (gamecube != null){
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropboxusercontent.com/s/mnihfh6mxwfstn0/GCbootanimation.zip");
				}if (nexus != null){
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropboxusercontent.com/s/16unuhb9xfjw69e/Jellybean%284.1%29.zip");
				}if (nightmare != null){
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropboxusercontent.com/s/51j2c4cyuanqqfk/The%20Nightmare%20Before%20Christmas.zip");
				}if (xbox != null){
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropboxusercontent.com/s/mowmrhgrvb0qb48/NXbootanimation.zip");
				}if (xbox1 != null){
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropboxusercontent.com/s/zu1w7ud5o3trz1r/OXbootanimation.zip");
				}
				
			}
		});
		
		bReturnB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				overridePendingTransition (0 , R.anim.slide_down);
			}
		});

	}
	
	

}
