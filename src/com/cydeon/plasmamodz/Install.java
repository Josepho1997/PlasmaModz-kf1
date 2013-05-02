package com.cydeon.plasmamodz;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.concurrent.TimeoutException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import com.stericson.RootTools.*;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Install extends Activity implements Runnable{

	private static ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.install);
		Button bInstall = (Button) findViewById(R.id.bInstallTheme);
		bInstall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				showDialog();
				
			}
		});
	}

	
	public void showDialog(){
		progressDialog = ProgressDialog.show(Install.this, "", "Installing Theme", true);
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		try{
			Thread.sleep(1000);
			CommandCapture command = new CommandCapture(0, "su", "#!/system/bin/sh", "busybox mount -o remount, rw /system", "rm -r /sdcard/plasma/working", "wait", "cd /sdcard/plasma", "mkdir working", "mkdir mods", "wait", "mv /sdcard/Download/batterymod.zip /sdcard/plasma/mods/", "mv /sdcard/Download/softkey.zip /sdcard/plasma/mods/", "mv /sdcard/Download/wifi.zip /sdcard/plasma/mods/", "mv /sdcard/Download/dp.zip /sdcard/plasma/", "mv /sdcard/Download/stat.zip /sdcard/plasma/mods/", "mv /sdcard/Download/cursor.zip /sdcard/plasma/mods/", "unzip -o /sdcard/plasma/mods/batterymod.zip -d /sdcard/plasma/working", "wait", "unzip -o /sdcard/plasma/mods/wifi.zip -d /sdcard/plasma/working", "wait", "unzip -o /sdcard/plasma/mods/softkey.zip -d /sdcard/plasma/working", "unzip -o /sdcard/plasma/dp.zip -d /sdcard/", "unzip -o /sdcard/plasma/mods/stat.zip -d /sdcard/plasma/working", "mv /sdcard/Download/lock.zip /sdcard/plasma/mods/", "wait",  "unzip -o /sdcard/plasma/mods/lock.zip -d /sdcard/plasma/working", "wait", "unzip -o /sdcard/plasma/mods/cursor.zip -d /sdcard/plasma/working", "wait", "cd working", "cd SystemUI", "cp /system/app/SystemUI.apk /sdcard/plasma/working/SystemUI", "cp /system/framework/framework-res.apk /sdcard/plasma/working/framework-res/framework-res.apk",  "wait", "cd res", "cp -r /sdcard/layout /sdcard/plasma/working/SystemUI/res", "wait", "cp -r /sdcard/drawable /sdcard/plasma/working/SystemUI/res",  "wait", "cp -r /sdcard/layout-sw600dp /sdcard/plasma/working/SystemUI/res", "wait", "cd /sdcard/plasma/working/SystemUI", "rm /sdcard/plasma/working/SystemUI/res/drawable/stat_sys_battery.xml", "zip -r SystemUI.apk res", "wait", "cd /sdcard/plasma/working/framework-res", "zip -r framework-res.apk res", "wait", "cd /sdcard/plasma/working/SystemUI", "mv SystemUI.apk SystemU.apk", "wait", "zipalign -v 4 SystemU.apk SystemUI.apk", "wait", "cp SystemUI.apk /system/app", "wait", "cd /sdcard/plasma/working/framework-res", "mv framework-res.apk frame.apk", "wait 3", "zipalign -v 4 frame.apk framework-res.apk", "wait 5", "cp framework-res.apk /system/framework", "wait 5", "chmod 644 /system/app/SystemUI.apk", "wait 3", "chmod 644 /system/framework/framework-res.apk", "wait 3", "rm -r /sdcard/plasma/mods", "wait", "rm /sdcard/plasma/dp.zip", "wait", "rm -r /sdcard/plasma/mods", "wait", "rm -r /sdcard/drawable", "wait 2", "rm -r /sdcard/layout", "wait 2", "rm -r /sdcard/layout-sw600dp", "wait 2", "rm -r /sdcard/plasma/working", "wait 2", "busybox killall system_server");
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
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		handler.sendEmptyMessage(0);
	}
	
	private static Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
		}
	};
	

}