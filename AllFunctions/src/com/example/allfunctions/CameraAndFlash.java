package com.example.allfunctions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CameraAndFlash extends Activity {

	private Button Camera_;
	private Button Flash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera_and_flash);
		Camera_ = (Button)findViewById(R.id.Camere);
		Camera_.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(); //调用照相机      
				intent.setAction("android.media.action.STILL_IMAGE_CAMERA");      
				startActivity(intent);  
			}
		});
		
		Flash = (Button)findViewById(R.id.Flash_f);
		Flash.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Camera  camera = Camera.open();
				camera.startPreview();
				Parameters parameters = camera.getParameters();
				//打开闪光灯关键代码：
				if(Parameters.FLASH_MODE_TORCH.equals(parameters.getFlashMode()))
				{
					parameters = camera.getParameters();
					parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
					camera.setParameters(parameters);					
				}
				else
				{
					parameters = camera.getParameters();				
					parameters.setFlashMode(Parameters.FLASH_MODE_OFF);				
					camera.setParameters(parameters);
				}			
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera_and_flash, menu);
		return true;
	}

}
