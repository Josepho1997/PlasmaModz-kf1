package com.cydeon.plasmamodz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.stericson.RootTools.RootTools;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.AlertDialog.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

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

	
	
    
    //Defining File Directory
    File directory = new File(Environment.getExternalStorageDirectory() + "/plasma");
    if(directory.exists() && directory.isDirectory()){
    //Do nothing. Directory is existent	
    }else{
    //Directory does not exist. Make directory (First time app users)
    directory.mkdirs();
    }
    
  //Defining File Directory
    File scripts = new File(Environment.getExternalStorageDirectory() + "/plasma/scripts");
    if(scripts.exists() && scripts.isDirectory()){
    //Do nothing. Directory is existent	
    }else{
    //Directory does not exist. Make directory (First time app users)
    scripts.mkdirs();
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

    tab = actionBar
        .newTab()
        .setText("Boot Animations")
        .setTabListener(new MyTabListener<BootFragment>(this, "album",
               BootFragment.class));
    actionBar.addTab(tab);

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
      } else {
        // If it exists, simply attach it in order to show it
        ft.attach(mFragment);
      }
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
      if (mFragment != null) {
        ft.detach(mFragment);
      }
    }

    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
  }
  
  
  
} 