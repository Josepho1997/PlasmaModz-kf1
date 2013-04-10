package com.cydeon.plasmamodz;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

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
					className = "com.cydeon.plasmamodz.Lock";
					fileName = "lock.zip";
					fileRealName = "Stock Lockscreen Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/kvtnkjnxby2ui6q/lockStock.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (lockgreen != null){
					className = "com.cydeon.plasmamodz.Lock";
					fileName = "lock.zip";
					fileRealName = "Green Lockscreen Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/186ncjhcu330f7j/lockGreen.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (lockblue != null){
					className = "com.cydeon.plasmamodz.Lock";
					fileName = "lock.zip";
					fileRealName = "Blue Lockscreen Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/330tlfwcvtlpf05/lockBlue.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (lockred != null){
					className = "com.cydeon.plasmamodz.Lock";
					fileName = "lock.zip";
					fileRealName = "Red Lockscreen Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/t2ygzzqtwlzhtk4/lockRed.zip"));
					req.setDestinationInExternalPublicDir(
							Environment.DIRECTORY_DOWNLOADS, fileName);
					enqueue = dm.enqueue(req);
				}else if (lockorange != null){
					className = "com.cydeon.plasmamodz.Lock";
					fileName = "lock.zip";
					fileRealName = "Oragne Lockscreen Mod";
					dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
					Request req = new Request(
							Uri.parse("https://dl.dropbox.com/s/a2h15l68mpetub6/lockOrange.zip"));
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
			Intent openNewIntent = new Intent(Download.this,
					Class.forName(className));
			startActivity(openNewIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
