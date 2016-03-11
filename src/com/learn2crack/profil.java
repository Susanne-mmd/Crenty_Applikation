package com.learn2crack;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

public class profil extends Activity 
{
	//her importer vi knapperne ind i Java.
	ImageButton ibprofil;
	ImageButton ibupload;
	ImageButton ibcam;
	ImageButton ibgps;
	ImageButton iblogud;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        displayUser();
        
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

    //på profil siden har vi lavet en webview der betyder at derigere appen over på hjemmesiden som er linket til nedenfor.
	@SuppressLint("SetJavaScriptEnabled")
	private void displayUser() 
	{
	WebView mWebView = (WebView) findViewById(R.id.webview_profil);
        mWebView.getSettings().setJavaScriptEnabled(true);
        
        mWebView.loadUrl("http://www.cfuttrup.dk/instalinked/profile.php?username=Christian");
	}

}