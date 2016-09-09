package com.example.allfunctions;

import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GPS extends Activity {

	private Button open;
	private Button close;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);
		
		open = (Button)findViewById(R.id.Open_GPS);
		open.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean gpsEnabled = Settings.Secure.isLocationProviderEnabled( 
						getContentResolver(), LocationManager.GPS_PROVIDER );
				 
			    if(gpsEnabled)
			    {

			    //关闭GPS
			    Toast toast=Toast.makeText(getApplicationContext(), "GPS已打开", Toast.LENGTH_SHORT);
			    toast.show();
			    }
			    else
			    {
			     //打开GPS  www.2cto.com
			    Toast toast=Toast.makeText(getApplicationContext(), "GPS正在打开", Toast.LENGTH_SHORT);
				toast.show();
			     Settings.Secure.setLocationProviderEnabled( getContentResolver(), 
			    		 LocationManager.GPS_PROVIDER, true);
			   
			    }
			}
		});
		
		close = (Button)findViewById(R.id.Close_GPS);
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean gpsEnabled = Settings.Secure.isLocationProviderEnabled( 
						getContentResolver(), LocationManager.GPS_PROVIDER );
				 
			    if(gpsEnabled)
			    {

			    //关闭GPS
			    Toast toast=Toast.makeText(getApplicationContext(), "GPS正在关闭", Toast.LENGTH_SHORT);
			    toast.show();
			     Settings.Secure.setLocationProviderEnabled( getContentResolver(), 
			    		 LocationManager.GPS_PROVIDER, false );
			    }
			    else
			    {
			     //打开GPS  www.2cto.com
			    Toast toast=Toast.makeText(getApplicationContext(), "GPS已关闭", Toast.LENGTH_SHORT);
				toast.show();			   
			    }
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.g, menu);
		return true;
	}

}
