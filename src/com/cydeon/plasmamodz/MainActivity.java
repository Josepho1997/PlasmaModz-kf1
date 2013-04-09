package com.cydeon.plasmamodz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.CommandCapture;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.AlertDialog.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
		
    
	//Checking For BusyBox
	if (RootTools.isBusyboxAvailable()){
		//Do nothing. Busybox is installed
	} else {
		//Offer them to install busybox (Might want to let them know that if they don't install, the app won't work
		RootTools.offerBusyBox(MainActivity.this);
	}
	
	CommandCapture command = new CommandCapture(0, "su");
	try {
		RootTools.getShell(true).add(command).waitForFinish();
		File zip = new File("/system/bin/zip");
	    if(zip.exists() && zip.isDirectory()){
	    //Do nothing. Directory is existent	
	    }else{
	    //Directory does not exist. Make directory (First time app users)
	    	Toast.makeText(MainActivity.this, "Moving necessary files", Toast.LENGTH_SHORT).show();
	    	CommandCapture command1 = new CommandCapture(0, "su", "cd /sdcard", "busybox mount -o remount, rw /system", "cp zip /system", "chmod 777 /system/zip", "mv /system/zip /system/bin", "cp zipalign /system", "chmod 777 /system/zipalign", "mv /system/zipalign /system/bin");
	    	try {
	    		RootTools.getShell(true).add(command1).waitForFinish();
	    	} catch (InterruptedException e) {
	    		e.printStackTrace();
	        	Toast.makeText(MainActivity.this, "Unknown Error! Please reboot and try again", Toast.LENGTH_SHORT).show();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    		Toast.makeText(MainActivity.this, "Unknown Error! Please reboot and try again", Toast.LENGTH_SHORT).show();
	    	} catch (TimeoutException e) {
	    		e.printStackTrace();
	    		Toast.makeText(MainActivity.this, "Unknown Error! Please reboot and try again", Toast.LENGTH_SHORT).show();
	    	} catch (RootDeniedException e) {
	    		e.printStackTrace();
	        Toast.makeText(MainActivity.this, "Error! SU not granted!", Toast.LENGTH_SHORT).show();
	    	}
	    	Toast.makeText(MainActivity.this, "Binaries Moved and Installed!", Toast.LENGTH_SHORT).show();
	    }
	} catch (InterruptedException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (TimeoutException e) {
		e.printStackTrace();
	} catch (RootDeniedException e) {
		e.printStackTrace();
	}
	
	
    
    //Defining File Directory
    File directory = new File(Environment.getExternalStorageDirectory() + "/plasma");
    if(directory.exists() && directory.isDirectory()){
    //Do nothing. Directory is existent	
    }else{
    //Directory does not exist. Make directory (First time app users)
    directory.mkdirs();
    }
    
    File boot = new File(Environment.getExternalStorageDirectory() + "/plasma/boot");
    if(boot.exists() && boot.isDirectory()){
    //Do nothing. Directory is existent	
    }else{
    //Directory does not exist. Make directory (First time app users)
    boot.mkdirs();
    }
    
    // setup action bar for tabs
    ActionBar actionBar = getActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    actionBar.setDisplayShowTitleEnabled(false);

    Tab tab = actionBar
        .newTab()
        .setText("Themes")
        .setTabListener(new MyTabListener<ThemeFragment>(this, "artist",
                ThemeFragment.class));
    actionBar.addTab(tab);

    Tab tab2 = actionBar
        .newTab()
        .setText("Boot Animations")
        .setTabListener(new MyTabListener<BootFragment>(this, "album",
               BootFragment.class));
    actionBar.addTab(tab2);
    
    Tab tab3 = actionBar
    		.newTab()
    		.setText("Shortcuts")
    		.setTabListener(new MyTabListener<ListFragment>(this, "song", ListFragment.class));
    actionBar.addTab(tab3);

  }

  public static class MyTabListener<T extends Fragment> implements
      TabListener {
    private Fragment mFragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;

    /**
     * Constructor used each time a new tab is created.
     * 
     * @param activity
     *            The host Activity, used to instantiate the fragment
     * @param tag
     *            The identifier tag for the fragment
     * @param clz
     *            The fragment's Class, used to instantiate the fragment
     */

    public MyTabListener(Activity activity, String tag, Class<T> clz) {
      mActivity = activity;
      mTag = tag;
      mClass = clz;
    }

    /* The following are each of the ActionBar.TabListener callbacks */

    public void onTabSelected(Tab tab, FragmentTransaction ft) {
      // Check if the fragment is already initialized
      if (mFragment == null) {
        // If not, instantiate and add it to the activity
        mFragment = Fragment.instantiate(mActivity, mClass.getName());
        ft.add(android.R.id.content, mFragment, mTag);
        ft.show(mFragment);
      } else {
        // If it exists, simply attach it in order to show it
        ft.attach(mFragment);
        ft.show(mFragment);
      }
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
      if (mFragment != null) {
        ft.detach(mFragment);
        ft.hide(mFragment);
      }
    }

    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
  }

	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	      MenuInflater menuInflater = getMenuInflater();
	      menuInflater.inflate(R.layout.menu, menu);
	      return true;
	  	}
  
  /**
   * Event Handling for Individual menu item selected
   * Identify single menu item by it's id
   * */
	
  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {

      switch (item.getItemId())
      {
      case R.id.menu_About:
          // Single menu item is selected do something
          // Ex: launching new activity/screen or show alert message
          Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
          Intent about = new Intent(MainActivity.this, About1.class);
          startActivity(about);
          return true;

      case R.id.menu_Credits:
          Toast.makeText(MainActivity.this, "Credits is Selected", Toast.LENGTH_SHORT).show();
          return true;

      case R.id.menu_Donate:
          Toast.makeText(MainActivity.this, "Donate is Selected", Toast.LENGTH_SHORT).show();
          return true;
          
      default:
          return super.onOptionsItemSelected(item);
      }
  }  
  
} 