package com.learn2crack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Dette er menuen du kommer ind på når du vil registrer dig, som indeholder udelukkende knapper til de forskellige sider.
public class regmenu extends Activity 
{
	Button btnregister;
	Button btnglemtkodeord;
	Button btnskiftkodeord;
	Button btnback;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.regmenu);

	        btnregister = (Button) findViewById(R.id.btnregister);
	        btnglemtkodeord = (Button) findViewById(R.id.btnglemtkodeord);
	        btnskiftkodeord = (Button)findViewById(R.id.btnskiftkodeord);
	        btnback = (Button) findViewById(R.id.btnback);


	        btnregister.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), Register.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	        btnglemtkodeord.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), PasswordReset.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	        btnskiftkodeord.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), ChangePassword.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	        btnback.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                Intent myIntent = new Intent(view.getContext(), Activity_main.class);
	                startActivityForResult(myIntent, 0);
	                finish();
	             }});
	        
	 }
}
