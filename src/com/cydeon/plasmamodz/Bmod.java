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
		final String bluedarkwifi = battery.getString("BlueDarkWifi");
		final String bluewifi = battery.getString("BlueWifi");
		final String goldwifi = battery.getString("GoldWifi");
		final String greenwifi = battery.getString("GreenWifi");
		final String orangewifi = battery.getString("OrangeWifi");
		final String pinkwifi = battery.getString("PinkWifi");
		final String redwifi = battery.getString("RedWifi");
		final String whitewifi = battery.getString("WhiteWifi");
		
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
		}if (bluedarkwifi != null){
			batteryView.setImageResource(R.drawable.blank);
		}if (bluewifi != null){
			batteryView.setImageResource(R.drawable.blank);
		}if (goldwifi != null){
			batteryView.setImageResource(R.drawable.blank);
		}if (greenwifi != null){
			batteryView.setImageResource(R.drawable.blank);
		}if (orangewifi != null){
			batteryView.setImageResource(R.drawable.blank);
		}if (pinkwifi != null){
			batteryView.setImageResource(R.drawable.blank);
		}if (redwifi != null){
			batteryView.setImageResource(R.drawable.blank);
		}if (whitewifi != null){
			batteryView.setImageResource(R.drawable.blank);
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
	                            
	                            
	                            
	                        }
	                    }
	                }
	            }
	        };
	 
	        registerReceiver(receiver, new IntentFilter(
	                DownloadManager.ACTION_DOWNLOAD_COMPLETE));

		
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
			                Uri.parse("https://dl.dropbox.com/s/s74kge4oohbbn7b/softkey_stock.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (stockblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Stock Blue softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/ao5bsk2ypi9106j/softkey_stock_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
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
			                Uri.parse("https://dl.dropbox.com/s/lh314twk6yjr5yh/softkey_pink.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (purple != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Purple softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/p9qkvggr0a6df51/softkey_purple.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (yellow != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Yellow softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/hj9is7ohuagbb42/softkey_yellow.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (red != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Red softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/qzd95tgnr63vvlp/softkey_red.zip"));
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
					fileRealName = "Reflect Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/ck429r6w7hwa70d/softkey_reflect.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (reflectblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Reflect Blue Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/mjinoz4curlz1rd/softkey_reflect_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (razor != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Razor Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/zkq1lr1cpvux02h/softkey_razor.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (razorblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Razor Blue Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/c1pnqgyq2fg4asi/softkey_razor_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (small != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Small Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/w8fnyvd9lkkuos2/softkey_small.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (smallblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Small Blue Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/jcj2r6ifjaqo8rz/softkey_small_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (smallreflect != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Small Reflect Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/a5afxfv6mkvav8z/softkey_small_reflect.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (smallreflectblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Small Reflect Blue Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/iok8uktd2ckdg65/softkey_small_reflect_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (xperia != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Xperia Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/3sbkvirpcbksljg/softkey_xperia.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (xperiablue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Xperia Blue Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/3nvzbqlxelelk7g/softkey_xperia_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (zte != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "ZTE Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/1r8zl2zqjiykvov/softkey_zte.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
				}if (zteblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "ZTE Blue Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/hkiynqfsoupi5wl/softkey_zte_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);
			        enqueue = dm.enqueue(req);
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
					fileRealName = "Droid Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/nvs1yyl87m0mj67/softkey_droid.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (droidblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Droid Blue Softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/a7h5p0j9yvrd9qo/softkey_droid_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (pixel != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Pixel softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/u8mdhhrjfpr4oh4/softkey_pixel.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (pixelblue != null){
					className = "com.cydeon.plasmamodz.Wifi";
					fileName = "softkey.zip";
					fileRealName = "Pixel Blue softkey Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/zgvzgw5u8elmeaz/softkey_pixel_blue.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (bluedarkwifi != null){
					className = "com.cydeon.plasmamodz.StatusBar";
					fileName = "wifi.zip";
					fileRealName = "Dark Blue Wifi Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/faar9qvd3br8e71/wifi_blue_dark.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (bluewifi != null){
					className = "com.cydeon.plasmamodz.StatusBar";
					fileName = "wifi.zip";
					fileRealName = "Blue Wifi Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/f98v3323nzez91v/wifi_cyan.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (goldwifi != null){
					className = "com.cydeon.plasmamodz.StatusBar";
					fileName = "wifi.zip";
					fileRealName = "Gold Wifi Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/nx7j2ak6noi6v8v/wifi_gold.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (greenwifi != null){
					className = "com.cydeon.plasmamodz.StatusBar";
					fileName = "wifi.zip";
					fileRealName = "Green Wifi Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/dsupqkqtgtvunqg/wifi_green.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (orangewifi != null){
					className = "com.cydeon.plasmamodz.StatusBar";
					fileName = "wifi.zip";
					fileRealName = "Orange Wifi Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/h71zqsxdlnr0p8l/wifi_orange.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (pinkwifi != null){
					className = "com.cydeon.plasmamodz.StatusBar";
					fileName = "wifi.zip";
					fileRealName = "Pink Wifi Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/yjdlbco6zkbdz46/wifi_pink.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (redwifi != null){
					className = "com.cydeon.plasmamodz.StatusBar";
					fileName = "wifi.zip";
					fileRealName = "Red Wifi Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/lk7v6umk2pk2bi3/wifi_red.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}if (whitewifi != null){
					className = "com.cydeon.plasmamodz.StatusBar";
					fileName = "wifi.zip";
					fileRealName = "White Wifi Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
			        Request req = new Request(
			                Uri.parse("https://dl.dropbox.com/s/zvp3pprwlh6h39z/wifi_white.zip"));
			        req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
		                    fileName);	
			        enqueue = dm.enqueue(req);
				}
				
				try {
					Context context2 = getApplicationContext();
            		CharSequence text = "Downloading " + fileRealName;
            		int duration = Toast.LENGTH_SHORT;
            		Toast toast = Toast.makeText(context2, text, duration);
            		toast.show();
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
	