package com.learn2crack;

import android.R.string;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;



	public class gps extends Activity implements LocationListener {
		private LocationManager mgr;
		private String best;
		
		ImageButton ibprofil;
		ImageButton ibupload;
		ImageButton ibcam;
		ImageButton ibgps;
		ImageButton iblogud;

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.gps);

			mgr = (LocationManager) getSystemService(LOCATION_SERVICE);

			Criteria criteria = new Criteria();
			best = mgr.getBestProvider(criteria, true);
			Location location = mgr.getLastKnownLocation(best);
			dumpLocation(location);
		}

		@Override
		protected void onResume() {
			super.onResume();
			// Start updates (doc recommends delay >= 60000 ms)
			mgr.requestLocationUpdates(best, 15000, 1, this);
		}

		@Override
		protected void onPause() {
			super.onPause();
			// Stop updates to save power while app paused
			mgr.removeUpdates(this);
		}

		public void onLocationChanged(Location location) {
			dumpLocation(location);
		}

		public void onProviderDisabled(String provider) {
			// This function is mandatory
		}

		public void onProviderEnabled(String provider) {
			// This function is mandatory
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			// This function is mandatory
		}

		private void displayPHPFeedback(String Latitude, String Longitude) 
		{
		WebView mWebView = (WebView) findViewById(R.id.webview);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl("http://10.0.2.2/learn2crack_login_api/gps.php?Latitude="+Latitude+"&Longitude="+Longitude); //example URL adress (10.0.2.2 = localhost)
		}

		/** Output the given location, which might be null */
		private void dumpLocation(Location location) {
			EditText latitude = (EditText) findViewById(R.id.latitude);
			EditText longitude = (EditText) findViewById(R.id.longitude);

			if (location == null) {
				latitude.setText("Unknown");
				longitude.setText("Unknown");
				
			} else {

				latitude.setText(Double.toString(location.getLatitude()));
				longitude.setText(Double.toString(location.getLongitude()));
				displayPHPFeedback(Double.toString(location.getLatitude()),Double.toString(location.getLatitude()));
			}
			
			ibprofil = (ImageButton) findViewById(R.id.ibprofil);
	        ibupload = (ImageButton) findViewById(R.id.ibupload);
	        ibcam = (ImageButton)findViewById(R.id.ibcam);
	        ibgps = (ImageButton) findViewById(R.id.ibgps);
	        iblogud = (ImageButton) findViewById(R.id.iblogud);

		}
		
		 public void profil(View view){
		        Intent myIntent = new Intent(view.getContext(), profil.class);
		        startActivityForResult(myIntent, 0);
		        finish();
		    };
		    
		    public void upload(View view){
		        Intent myIntent = new Intent(view.getContext(), upload.class);
		        startActivityForResult(myIntent, 0);
		        finish();
		    };
		    
		    public void gps(View view){
		        Intent myIntent = new Intent(view.getContext(), gps.class);
		        startActivityForResult(myIntent, 0);
		        finish();
		    };
		    
		    public void logud(View view){
		        Intent myIntent = new Intent(view.getContext(), Activity_main.class);
		        startActivityForResult(myIntent, 0);
		        finish();
		    };
		    
		    public void cam(View view){
		        Intent myIntent = new Intent(view.getContext(), camera.class);
		        startActivityForResult(myIntent, 0);
		        finish();
		    };
	}
