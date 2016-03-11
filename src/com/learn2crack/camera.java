package com.learn2crack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class camera extends Activity {
	
	ImageButton ibprofil;
	ImageButton ibcamera;
	ImageButton ibupload;
	ImageButton ibgps;
	ImageButton iblogud;
	
ImageView imgTakenPhoto;
private static final int CAMERA_PIC_REQUEST = 1313;

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.camera);

imgTakenPhoto = (ImageView) findViewById(R.id.imageView1);

ibprofil = (ImageButton) findViewById(R.id.ibprofil);
ibgps = (ImageButton) findViewById(R.id.ibgps);
iblogud = (ImageButton) findViewById(R.id.iblogud);
ibcamera =(ImageButton) findViewById(R.id.ibcam);
ibupload = (ImageButton) findViewById(R.id.ibupload);


}


public void profil(View view){
    Intent myIntent = new Intent(view.getContext(), profil.class);
    startActivityForResult(myIntent, 0);
    finish();
};

public void gps(View view){
    Intent myIntent = new Intent(view.getContext(), gps.class);
    startActivityForResult(myIntent, 0);
    finish();
};

public void Upload(View view){
    Intent myIntent = new Intent(view.getContext(), upload.class);
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


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  
	super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == CAMERA_PIC_REQUEST) {
		  Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
		  imgTakenPhoto.setImageBitmap(thumbnail);
		  
		//Save image
		  File sdCardDirectory = Environment.getExternalStorageDirectory();
		  File image = new File(sdCardDirectory, "test.png");
		      		  
		  boolean success = false;

		  // Encode the file as a PNG image.
		  FileOutputStream outStream;
		  try {
		         outStream = new FileOutputStream(image);
		         thumbnail.compress(Bitmap.CompressFormat.PNG, 100, outStream); 
		         /* 100 to keep full quality of the image */

		         outStream.flush();
		         outStream.close();
		         success = true;
		      } catch (FileNotFoundException e) {
		      		e.printStackTrace();
		      	} catch (IOException e) {
		      		e.printStackTrace();
		      	}
		      		  
		      		  
		     if (success) {
		      	Toast.makeText(getApplicationContext(), "Image saved with success",
		      	Toast.LENGTH_LONG).show();
		      	} else {
		      	Toast.makeText(getApplicationContext(),
		      	"Error during image saving", Toast.LENGTH_LONG).show();
		      }

		  }
	}

public void ActivateCamera(View v) {
  Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
  startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
  
	}
}
