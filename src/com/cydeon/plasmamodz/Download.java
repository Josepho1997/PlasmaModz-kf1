package com.cydeon.plasmamodz;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Download extends Activity {

	String fileName;
	String className;
	String fileRealName;
	String dp;
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
		
		final String lockstock = battery.getString("LockStock");
		final String lockgreen = battery.getString("LockGreen");
		final String lockblue = battery.getString("LockBlue");
		final String lockred = battery.getString("LockRed");
		final String lockorange = battery.getString("LockOrange");
		final String cursorblack = battery.getString("CursorBlack");
		final String cursorblue = battery.getString("CursorBlue");
		final String cursorgray = battery.getString("CursorGray");
		final String cursorgreen = battery.getString("CursorGreen");
		final String cursoryellow = battery.getString("CursorYellow");
		final String cursororange = battery.getString("CursorOrange");
		final String cursorpink = battery.getString("CursorPink");
		final String cursorpurple = battery.getString("CursorPurple");
		final String cursorlightblue = battery.getString("CursorLightBlue");
		final String cursorred = battery.getString("CursorRed");

		
		if (lockstock != null) {
			UrlImageViewHelper.setUrlDrawable(batteryView, "https://dl.dropbox.com/s/h25skmwe92yi78u/Screenshot_2013-04-09-23-22-26.png",
					R.drawable.default_img, 60000);
		}else if (lockgreen != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "https://dl.dropbox.com/s/dl434p5mh5er7nu/Screenshot_2013-04-09-23-01-42.png",
					R.drawable.default_img, 60000);
		}else if (lockblue != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "https://dl.dropbox.com/s/rzl28q5og1jikuk/Screenshot_2013-04-09-23-16-30.png",
					R.drawable.default_img, 60000);
		}else if (lockred != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "https://dl.dropbox.com/s/s4rz6koi1s1nk3i/Screenshot_2013-04-09-23-18-03.png",
					R.drawable.default_img, 60000);
		}else if (lockorange != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "https://dl.dropbox.com/s/9v1auzuqdxsciql/Screenshot_2013-04-09-23-14-26.png",
					R.drawable.default_img, 60000);
		}else if (cursorblack != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursorblue != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursorgray != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursorgreen != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursoryellow != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursororange != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursorpink != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursorpurple != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursorlightblue != null){
			batteryView.setImageResource(R.drawable.blank);
		}else if (cursorred != null){
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
				
				if (lockstock != null) {
					className = "com.cydeon.plasmamodz.TextCursor";
					fileName = "lock.zip";
					fileRealName = "Stock Lockscreen Mod";
					deleteLock();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/kvtnkjnxby2ui6q/lockStock.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (lockgreen != null){
					className = "com.cydeon.plasmamodz.TextCursor";
					fileName = "lock.zip";
					fileRealName = "Green Lockscreen Mod";
					deleteLock();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/186ncjhcu330f7j/lockGreen.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (lockblue != null){
					className = "com.cydeon.plasmamodz.TextCursor";
					fileName = "lock.zip";
					fileRealName = "Blue Lockscreen Mod";
					deleteLock();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/330tlfwcvtlpf05/lockBlue.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (lockred != null){
					className = "com.cydeon.plasmamodz.TextCursor";
					fileName = "lock.zip";
					fileRealName = "Red Lockscreen Mod";
					deleteLock();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/t2ygzzqtwlzhtk4/lockRed.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (lockorange != null){
					className = "com.cydeon.plasmamodz.TextCursor";
					fileName = "lock.zip";
					fileRealName = "Oragne Lockscreen Mod";
					deleteLock();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/a2h15l68mpetub6/lockOrange.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursorblack != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Black Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/t05ju63s5yg91tg/TextSelectBlack.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursorblue != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Blue Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/9h71oks5qjgb4ab/TextSelectBlue.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursorgray != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Gray Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/qogx05rav0y7h6x/TextSelectGray.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursorgreen != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Green Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/29p9zpfg2hk7cth/TextSelectGreen.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursoryellow != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Yellow Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/wp872sfbr4q49bh/TextSelectYellow.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursororange != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Orange Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/okfazb42puyqki8/TextSelectOrange.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursorpink != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Pink Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/c1e0oxx5iji8gbi/TextSelectPink.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursorpurple != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Purple Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/h9mygqehtzt5zdb/TextSelectPurple.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursorlightblue != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Light Blue Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/c8gjkac7h8lt88s/TextSelectLightBlue.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (cursorred != null){
					className = "com.cydeon.plasmamodz.Install";
					fileName = "cursor.zip";
					fileRealName = "Red Cursor Mod";
					deleteCursor();
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/o5io80vuecrh2cg/TextSelectRed.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}
				
				try {
					Context context2 = getApplicationContext();
					CharSequence text = "Downloading " + fileRealName;
					int duration = Toast.LENGTH_SHORT;
					Toast toast = Toast.makeText(context2, text, duration);
					toast.show();
					Intent openNewIntent = new Intent(Download.this, Class
							.forName(className));
					startActivity(openNewIntent);
					overridePendingTransition (0 , R.anim.slide_down);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
		});

		bReturnB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
				overridePendingTransition (0 , R.anim.slide_down);

			}
		});

	}

	public void showDownload(View view) {
		Context context = getApplicationContext();
		CharSequence text = "Download complete";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	public void deleteLock(){
		CommandCapture command = new CommandCapture(0, "su", "#!/system/bin/sh", "busybox mount -o remount, rw /system", "cd /sdcard/Download", "rm lock.zip");
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
	}
		
		public void deleteCursor(){
			CommandCapture command = new CommandCapture(0, "su", "#!/system/bin/sh", "busybox mount -o remount, rw /system", "cd /sdcard/Download", "rm cursor.zip");
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
		}

}
