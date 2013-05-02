package com.cydeon.plasmamodz;

import java.io.File;
import java.io.IOException;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class BootFragment extends Fragment implements OnClickListener {{

	
		//Defining File Directory
	    File directory = new File(Environment.getExternalStorageDirectory() + "/plasma/boot");
	    if(directory.exists() && directory.isDirectory()){
	    //Do nothing. Directory is existent	
	    }else{
	    //Directory does not exist. Make directory (First time app users)
	    directory.mkdirs();
	    }
	    
	   
		
	    File bkup = new File(Environment.getExternalStorageDirectory() + "/plasma/boot/bkup");
	    if(bkup.exists() && bkup.isDirectory()){
	    //Do nothing. Directory is existent	
	    }else{
	    //Directory does not exist. Make directory (First time app users)
	    bkup.mkdirs();
	    }}
	
	
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 View view = inflater.inflate(R.layout.boot_frag,
		            container, false);
		 
		 ImageView image = (ImageView) view.findViewById(R.id.ivBoot);
		 image.setVisibility(View.VISIBLE);
		 Button select = (Button) view.findViewById(R.id.bSelect);		 
		 select.setOnClickListener(this);
		return view;
}
	
	private Drawable adjust(Drawable d)
	{
	    int to = Color.RED;

	    //Need to copy to ensure that the bitmap is mutable.
	    Bitmap src = ((BitmapDrawable) d).getBitmap();
	    Bitmap bitmap = src.copy(Bitmap.Config.ARGB_8888, true);
	    for(int x = 0;x < bitmap.getWidth();x++)
	        for(int y = 0;y < bitmap.getHeight();y++)
	            if(match(bitmap.getPixel(x, y))) 
	                bitmap.setPixel(x, y, to);

	    return new BitmapDrawable(getActivity().getResources(), bitmap);
	}

	private boolean match(int pixel)
	{
		int[] FROM_COLOR = new int[]{49, 179, 110};
		int THRESHOLD = 3;
	    return Math.abs(Color.red(pixel) - FROM_COLOR[0]) < THRESHOLD &&
	        Math.abs(Color.green(pixel) - FROM_COLOR[1]) < THRESHOLD &&
	        Math.abs(Color.blue(pixel) - FROM_COLOR[2]) < THRESHOLD;
	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.bSelect) {
			Intent a = new Intent(getActivity(), Boots1.class);
			BootFragment.this.startActivity(a);
		}
	}

}