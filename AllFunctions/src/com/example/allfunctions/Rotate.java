package com.example.allfunctions;

import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Rotate extends Activity {

	private Button rotate;
	private int flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rotate);
		rotate = (Button)findViewById(R.id.Rotate);
		flag = Settings.System.getInt(getContentResolver(),
	            Settings.System.ACCELEROMETER_ROTATION, 0);
		
		if (flag == 1) 
		{
			rotate.setText("���Զ���ת");
		}
		else 
		{
			rotate.setText("δ������ת");
		}
		
		rotate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
				//0���ر�   1������
				//Settings.System.putInt(getContentResolver(),Settings.System.ACCELEROMETER_ROTATION, 1);
				//�õ��Ƿ���
				//flag = Settings.System.getInt(getContentResolver(),Settings.System.ACCELEROMETER_ROTATION, 0);
				
				
				if(flag == 1)
				{
					Settings.System.putInt(getContentResolver(),Settings.System.ACCELEROMETER_ROTATION, 0);
					rotate.setText("δ������ת");
					Toast.makeText(getApplicationContext(), "�ѹر���ת", 1000).show();
					flag = Settings.System.getInt(getContentResolver(),
				            Settings.System.ACCELEROMETER_ROTATION, 0);
				}
				else
				{
					Settings.System.putInt(getContentResolver(),Settings.System.ACCELEROMETER_ROTATION, 1);
					rotate.setText("���Զ���ת");
					Toast.makeText(getApplicationContext(), "�ѿ�����ת", 1000).show();
					flag = Settings.System.getInt(getContentResolver(),
				            Settings.System.ACCELEROMETER_ROTATION, 0);
					
				}
				
				
				
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rotate, menu);
		return true;
	}

}
