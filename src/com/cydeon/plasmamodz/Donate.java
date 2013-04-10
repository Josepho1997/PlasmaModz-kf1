package com.cydeon.plasmamodz;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Donate extends Activity {
	 
		private WebView webView;
		
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.donate);
	 
			webView = (WebView) findViewById(R.id.wvDonate);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadUrl("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=RHWY9QGVB3UMU&lc=US&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted");
			webView.setWebViewClient(new MyWebViewClient());
			
		}
	
		private class MyWebViewClient extends WebViewClient {
		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        if (Uri.parse(url).getHost().equals("www.paypal.com")) {
		            return false;
		        }
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		        startActivity(intent);
		        return true;
		    }
		}

}

