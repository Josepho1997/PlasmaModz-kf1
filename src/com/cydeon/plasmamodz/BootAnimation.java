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
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BootAnimation extends Activity{
	
	ProgressDialog mProgressDialog;
	String fileName;
	
	private class DownloadFile extends AsyncTask<String, Integer, String> {
	    @Override
	    protected String doInBackground(String... sUrl) {
	        try {
	            URL url = new URL(sUrl[0]);
	            URLConnection connection = url.openConnection();
	            connection.connect();
	            int fileLength = connection.getContentLength();

	            InputStream input = new BufferedInputStream(url.openStream());
	            OutputStream output = new FileOutputStream("/sdcard/plasma/boot/bootanimation.zip");

	            byte data[] = new byte[1024];
	            long total = 0;
	            int count;
	            while ((count = input.read(data)) != -1) {
	                total += count;
	                publishProgress((int) (total * 100 / fileLength));
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
	    protected void onProgressUpdate(Integer... progress) {
	        super.onProgressUpdate(progress);
	        mProgressDialog.setProgress(progress[0]);
	    }

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			CommandCapture command = new CommandCapture(0, "su", "#!/system/bin/sh", "busybox mount -o remount, rw /system", "cd /sdcard/plasma/boot", "rm /system/media/bootanimation.zip", "cp /sdcard/plasma/boot/bootanimation.zip /system/media", "chmod 644 /system/media/bootanimation.zip", "busybox killall system_server");
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

	@Override
	 protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battery);
		
		ProgressDialog mProgressDialog;
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
			UrlImageViewHelper.setUrlDrawable(batteryView, "https://dl.dropbox.com/s/kl2bbv7vp2sq9mh/0038.jpg", R.drawable.default_img, 60000);
		}else if (dragon != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8158/7454334802_31641ae875_m.jpg", R.drawable.default_img, 60000);
		}else if (gameboy != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8153/7457111720_6d74056a02_m.jpg", R.drawable.default_img, 60000);
		}else if (gamecube != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8015/7457111876_ca01535a4d_m.jpg", R.drawable.default_img, 60000);
		}else if (nexus != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8149/7462059092_86088934b2_m.jpg", R.drawable.default_img, 60000);
		}else if (nightmare != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8014/7490899268_6b812e99f4_m.jpg", R.drawable.default_img, 60000);
		}else if (xbox != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm8.staticflickr.com/7254/7457111536_4d1924a1d4_m.jpg", R.drawable.default_img, 60000);
		}else if (xbox1 != null){
			UrlImageViewHelper.setUrlDrawable(batteryView, "http://farm9.staticflickr.com/8012/7457111956_8ca4ee912f_m.jpg", R.drawable.default_img, 60000);
		}
		
		

		mProgressDialog = new ProgressDialog(BootAnimation.this);
		mProgressDialog.setMessage("Download " + fileName);
		mProgressDialog.setIndeterminate(false);
		mProgressDialog.setMax(100);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressDialog.setCancelable(false);
		Button bInstallB = (Button) findViewById(R.id.bInstallBattery);
		Button bReturnB = (Button) findViewById(R.id.bReturnBattery);
		bInstallB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (android != null){
					fileName = "Android Boot Animation";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("https://dl.dropbox.com/s/mqan6ly3g8t4r5j/bootanimation.zip");
				}else if (dragon != null){
					fileName = "Dragon Ball Boot Animation (46.35MB)";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("http://205.196.122.234/snexuws5kfeg/vjzk5v33fu1u6ca/DBbootanimation.zip");
				}else if (gameboy != null){
					fileName = "GameBoy Boot Animation";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("http://205.196.120.109/j9ye9cznxazg/oqu704icx2kxx30/Gbootanimation.zip");
				}else if (gamecube != null){
					fileName = "GameCube Boot Animation";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("http://199.91.154.113/hzdvf89m0vag/r86xilqqq8mursc/GCbootanimation.zip");
				}else if (nexus != null){
					fileName = "Nexus Boot Animation";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("http://forum.xda-developers.com/attachment.php?attachmentid=1162570&d=1340907701");
				}else if (nightmare != null){
					fileName = "The Nightmare Before Christmas Boot Animation";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("http://199.91.154.15/75mtt4zeb4yg/co5d822mralvmn4/The+Nightmare+Before+Christmas.zip");
				}else if (xbox != null){
					fileName = "New Xbox Boot Animation";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("http://205.196.121.24/n4ccp4ps8zzg/j2on8mnc7rqo2q2/NXbootanimation.zip");
				}else if (xbox1 != null){
					fileName = "Old Xbox Boot Animation";
					DownloadFile downloadFile = new DownloadFile();
					downloadFile.execute("http://205.196.120.108/31oc4yj1njxg/un8leuns2md21fq/OXbootanimation.zip");
				}
			}
		});
		
		bReturnB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}
	
	

}
