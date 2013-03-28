package com.cydeon.plasmamodz;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeoutException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;

import com.koushikdutta.urlimageviewhelper.*;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Bmod extends Activity {

	String fileName;
	String className;
	String fileRealName;
	 private long enqueue;
	 private DownloadManager dm;
	 ProgressDialog progressbar;
	
	private void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while((read = in.read(buffer)) != -1){
			out.write(buffer, 0, read);
		}
	}
	
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
				OutputStream output = new FileOutputStream("/sdcard/plasma/downloads/" + fileName);
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
			CharSequence text = "Download complete";
			int duration = Toast.LENGTH_SHORT;
				AssetManager assetManager = getAssets();
				String[] files = null;
				try{
					files = assetManager.list("");
					
			} catch (IOException e) {
				Log.e("tag", "Failed to get asset file list.", e);
			}

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			try {
				  Intent openNewIntent = new Intent(Bmod.this, Class.forName(className) );
				  startActivity( openNewIntent );
				} catch (ClassNotFoundException e) {
				  e.printStackTrace(); 
				}
		}
	}
	
	ProgressDialog mProgressDialog;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battery);
		Button bInstallB = (Button) findViewById(R.id.bInstallBattery);
		Button bReturnB = (Button) findViewById(R.id.bReturnBattery);
		ImageView batteryView = (ImageView) findViewById(R.id.ivBattery);
		Bundle battery;
		battery = getIntent().getExtras();
		final String andy = battery.getString("Andy");
		final String bluebox = battery.getString("BlueBox");
		final String circlepercent = battery.getString("CirclePercent");
		final String circles = battery.getString("Circles");
		final String digital = battery.getString("Digital");
		final String dotted = battery.getString("Dotted");
		final String fullcircle1 = battery.getString("FullCircle1");
		final String fullcircle2 = battery.getString("FullCircle2");
		final String gauge = battery.getString("Gauge");
		final String honeycomb = battery.getString("Honeycomb");
		final String stock = battery.getString("Stock");
		final String stockblue = battery.getString("StockBlue");
		final String green = battery.getString("Green");
		final String pink = battery.getString("Pink");
		final String purple = battery.getString("Purple");
		final String yellow = battery.getString("Yellow");
		final String red = battery.getString("Red");
		final String galaxy = battery.getString("Galaxy");
		final String galaxyblue = battery.getString("GalaxyBlue");
		final String reflect = battery.getString("Reflect");
		final String reflectblue = battery.getString("ReflectBlue");
		final String razor = battery.getString("Razor");
		final String razorblue = battery.getString("RazorBlue");
		final String small = battery.getString("Small");
		final String smallblue = battery.getString("SmallBlue");
		final String smallreflect = battery.getString("SmallReflect");
		final String smallreflectblue = battery.getString("SmallReflectBlue");
		final String xperia = battery.getString("Xperia");
		final String xperiablue = battery.getString("XperiaBlue");
		final String zte = battery.getString("Zte");
		final String zteblue = battery.getString("ZteBlue");
		final String college = battery.getString("College");
		final String collegeblue = battery.getString("CollegeBlue");
		final String defused = battery.getString("Defused");
		final String defusedblue = battery.getString("DefusedBlue");
		final String droid = battery.getString("Droid");
		final String droidblue = battery.getString("DroidBlue");
		final String pixel = battery.getString("Pixel");
		final String pixelblue = battery.getString("PixelBlue");
		if (andy != null){
	        UrlImageViewHelper.setUrlDrawable(batteryView, "http://random.png", R.drawable.default_img, 60000);
		}if (bluebox != null){
			batteryView.setImageResource(R.drawable.bluebox);
		}if (circlepercent != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://forum.xda-developers.com/attachment.php?attachmentid=1738177&stc=1&d=1361125906", R.drawable.default_img, 60000);
		}if (circles != null){
			batteryView.setImageResource(R.drawable.circles);
		}if (digital != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://forum.xda-developers.com/attachment.php?attachmentid=1768332&stc=1&d=1362062335", R.drawable.default_img, 60000);
		}if (dotted != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://forum.xda-developers.com/attachment.php?attachmentid=1754013&stc=1&d=1361622539", R.drawable.default_img, 60000);
		}if (fullcircle1 != null){
			batteryView.setImageResource(R.drawable.fullcircle1);
		}if (fullcircle2 != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://forum.xda-developers.com/attachment.php?attachmentid=1720115&stc=1&d=1360581542", R.drawable.default_img, 60000);
		}if (gauge != null){
			batteryView.setImageResource(R.drawable.gauge);
		}if (honeycomb != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://forum.xda-developers.com/attachment.php?attachmentid=1754014&stc=1&d=1361622539", R.drawable.default_img, 60000);
		}if (stock != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock/example.png", R.drawable.default_img, 60000);
		}if (stockblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock/example.png", R.drawable.default_img, 60000);
		}if (green != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Green/example.png", R.drawable.default_img, 60000);
		}if (pink != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Green/example.png", R.drawable.default_img, 60000);
		}if (purple != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Green/example.png", R.drawable.default_img, 60000);
		}if (yellow != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Green/example.png", R.drawable.default_img, 60000);
		}if (red != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Green/example.png", R.drawable.default_img, 60000);
		}if (galaxy != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Galaxy/example.png", R.drawable.default_img, 60000);
		}if (galaxyblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Galaxy/example.png", R.drawable.default_img, 60000);
		}if (reflect != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Reflect/example.png", R.drawable.default_img, 60000);
		}if (reflectblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Reflect/example.png", R.drawable.default_img, 60000);
		}if (razor != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/RAZR%20HD/example.png", R.drawable.default_img, 60000);
		}if (razorblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/RAZR%20HD/example.png", R.drawable.default_img, 60000);
		}if (small != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Small/example.png", R.drawable.default_img, 60000);
		}if (smallblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Small/example.png", R.drawable.default_img, 60000);
		}if (smallreflect != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Small%20Reflect/example.png", R.drawable.default_img, 60000);
		}if (smallreflectblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Stock%20Small%20Reflect/example.png", R.drawable.default_img, 60000);
		}if (xperia != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Xperia/example.png", R.drawable.default_img, 60000);
		}if (xperiablue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Xperia/example.png", R.drawable.default_img, 60000);
		}if (zte != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/ZTE%20Grand/example.png", R.drawable.default_img, 60000);
		}if (zteblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/ZTE%20Grand/example.png", R.drawable.default_img, 60000);
		}if (college != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Fonts/College/example.png", R.drawable.default_img, 60000);
		}if (collegeblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Fonts/College/example.png", R.drawable.default_img, 60000);
		}if (defused != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Fonts/Defused/example.png", R.drawable.default_img, 60000);
		}if (defusedblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Fonts/Defused/example.png", R.drawable.default_img, 60000);
		}if (droid != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Fonts/Droid/example.png", R.drawable.default_img, 60000);
		}if (droidblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Fonts/Droid/example.png", R.drawable.default_img, 60000);
		}if (pixel != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Fonts/Pixel/example.png", R.drawable.default_img, 60000);
		}if (pixelblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://dl.dropbox.com/u/1983605/Softkeys/Fonts/Pixel/example.png", R.drawable.default_img, 60000);
		}
		
		 BroadcastReceiver receiver = new BroadcastReceiver() {
	            @Override
	            public void onReceive(Context context, Intent intent) {
	                String action = intent.getAction();
	                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
	                    long downloadId = intent.getLongExtra(
	                            DownloadManager.EXTRA_DOWNLOAD_ID, 0);
	                    Query query = new Query();
	                    query.setFilterById(enqueue);
	                    Cursor c = dm.query(query);
	                    if (c.moveToFirst()) {
	                        int columnIndex = c
	                                .getColumnIndex(DownloadManager.COLUMN_STATUS);
	                        if (DownloadManager.STATUS_SUCCESSFUL == c
	                                .getInt(columnIndex)) {
	                            String uriString = c
	                                    .getString(c
	                                            .getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
	                    		Context context2 = getApplicationContext();
	                    		CharSequence text = fileRealName + " downloaded";
	                    		int duration = Toast.LENGTH_SHORT;
	                    		Toast toast = Toast.makeText(context2, text, duration);
	                    		toast.show();
	                    		fileRealName = null;
	                            
	                            
	                            
	                        }
	                    }
	                }
	            }
	        };
	 
	        registerReceiver(receiver, new IntentFilter(
	                DownloadManager.ACTION_DOWNLOAD_COMPLETE));

		
		mProgressDialog = new ProgressDialog(Bmod.this);
		mProgressDialog.setIndeterminate(false);
		mProgressDialog.setMax(100);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressDialog.setCancelable(false);
		bInstallB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (andy != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Android Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/gfukrwqy4xqrnj9/Android.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (bluebox != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Blue Box Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/3eh0l472rvpd8yi/BlueBox.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (circlepercent != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Circle Percent Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/pd6ojb92nzgo227/CirclePercent.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (circles != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Circles Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/i9nqlqr681mezfa/Circles.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (digital != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Digital Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/tkyp6g7f2f1budd/Digital.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (dotted != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Dotted Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/fz2rzp3wqiosfpg/Dotted.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (fullcircle1 != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Full Circle Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/l7ebn47y02f4f8n/FullCircle1.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (fullcircle2 != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Full Circle 2 Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/9fo8vowu74ve89y/FullCircle2.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (gauge != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Gauge Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/8zlcdz2ymwe4kma/Gauge.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (honeycomb != null){
					className = "com.cydeon.plasmamodz.Softkeys";
					fileName = "batterymod.zip";
					fileRealName = "Honeycomb Batttery Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/qmclypdhziqop19/Honeycomb.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (stock != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Stock softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("http://"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (stockblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (green != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Green softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/sm9cf1b0oih87yh/softkey_green.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (pink != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Pink softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("http://"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (purple != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Purple softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("http://"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (yellow != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Yellow softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("http://"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (red != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Red softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("http://"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (galaxy != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Galaxy softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/5k3tn5057ckpub7/softkey_galaxy.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (galaxyblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Galaxy Blue softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/0euvlxw3t54bxvd/softkey_galaxy_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (reflect != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (reflectblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (razor != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (razorblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (small != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (smallblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Small Blue softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/jcj2r6ifjaqo8rz/softkey_small_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (smallreflect != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (smallreflectblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (xperia != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (xperiablue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (zte != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (zteblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (college != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "College softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/enqy2d9n19oxkzl/softkey_college.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (collegeblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "College Blue softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/sea6xl48h8hs3mh/softkey_college_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (defused != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Defused softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/9hpqt42l7d1t5yh/softkey_defused.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (defusedblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Defused Blue softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/r4nos7lq38ege7q/softkey_defused_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
			    }if (droid != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileName = "softkey.zip";
					fileRealName = "Droid softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/nvs1yyl87m0mj67/softkey_droid.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (droidblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Droid Blue softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/a7h5p0j9yvrd9qo/softkey_droid_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (pixel != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}if (pixelblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute();
				}
				
				try {
					  Intent openNewIntent = new Intent(Bmod.this, Class.forName(className) );
					  startActivity( openNewIntent );
					} catch (ClassNotFoundException e) {
					  e.printStackTrace();
					  }
			
			}
		});
		

		
		bReturnB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
				
			}
		});
	
		
		
	}

	public void showDownload(View view) {
		Context context = getApplicationContext();
		CharSequence text = "Download complete";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
        try {
			  Intent openNewIntent = new Intent(Bmod.this, Class.forName(className) );
			  startActivity( openNewIntent );
			} catch (ClassNotFoundException e) {
			  e.printStackTrace();
			  }
	}

}
	