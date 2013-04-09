package com.cydeon.plasmamodz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

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
			CommandCapture command = new CommandCapture(0, "su", "#!/system/bin/sh", "busybox mount -o remount, rw /system", "rm -r /sdcard/plasma/working", "wait", "cd /sdcard/plasma", "mkdir working", "mkdir mods", "wait", "mv /sdcard/Download/batterymod.zip /sdcard/plasma/mods/", "mv /sdcard/Download/softkey.zip /sdcard/plasma/mods/", "mv /sdcard/Download/wifi.zip /sdcard/plasma/mods/", "mv /sdcard/Download/dp.zip /sdcard/plasma/", "mv /sdcard/Download/stat.zip /sdcard/plasma/mods/", "unzip -o /sdcard/plasma/mods/batterymod.zip -d /sdcard/plasma/working", "wait", "unzip -o /sdcard/plasma/mods/wifi.zip -d /sdcard/plasma/working", "wait", "unzip -o /sdcard/plasma/mods/softkey.zip -d /sdcard/plasma/working", "unzip -o /sdcard/plasma/dp.zip -d /sdcard/", "unzip -o /sdcard/plasma/mods/stat.zip -d /sdcard/plasma/working", "wait", "cd working", "cd SystemUI", "cp /system/app/SystemUI.apk /sdcard/plasma/working/SystemUI", "wait", "cd res", "cp -r /sdcard/layout /sdcard/plasma/working/SystemUI/res", "wait", "cp -r /sdcard/drawable /sdcard/plasma/working/SystemUI/res",  "wait", "cp -r /sdcard/layout-sw600dp /sdcard/plasma/working/SystemUI/res", "wait",  "cp /sdcard/plasma/zip /system/bin", "cp /sdcard/plasma/zipalign /system/bin", "chmod 777 /system/bin/zip", "chmod 777 /system/bin/zipalign", "cd /sdcard/plasma/working/SystemUI", "zip -r SystemUI.apk res", "wait", "mv SystemUI.apk SystemU.apk", "wait", "zipalign -v 4 SystemU.apk SystemUI.apk", "wait", "rm /sdcard/plasma/working/System/res/drawable/stat_sys_battery.xml", "wait", "cp SystemUI.apk /system/app", "wait", "wait", "chmod 644 /system/app/SystemUI.apk", "wait", "rm -r /sdcard/plasma/mods", "rm /sdcard/plasma/dp.zip", "rm -r /sdcard/plasma/mods", "rm -r /sdcard/plasma/working", "rm -r /sdcard/drawable", "rm -r /sdcard/layout", "rm -r /sdcard/layout-sw600dp", "busybox killall system_server");
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
