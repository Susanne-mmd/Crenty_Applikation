package com.learn2crack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// dette er menuen du kommer ind på efter at have logget ind, som indeholder udelukkende knapper til de forskellige sider.
public class menu extends Activity 
{
	Button btnprofil;
	Button btncamera;
	Button btnupload;
	Button btngps;
	Button btnlog_ud;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu);

	        btnprofil = (Button) findViewById(R.id.btnprofil);
	        btncamera = (Button) findViewById(R.id.btncamera);
	        btnupload = (Button)findViewById(R.id.btnupload);
	        btngps = (Button) findViewById(R.id.btngps);
	        btnlog_ud = (Button) findViewById(R.id.btnlog_ud);


	        btnprofil.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(),profil.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	        btncamera.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), camera.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	        btnupload.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), upload.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	        btngps.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), gps.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	        btnlog_ud.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), Activity_main.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	 }
}
