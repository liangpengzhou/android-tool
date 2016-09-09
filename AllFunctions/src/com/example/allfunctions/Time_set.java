package com.example.allfunctions;

import java.io.IOException;

import android.R.integer;
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import applycation.SystemDateTime;

public class Time_set extends Activity {
	
	private Button set;
	private TextView hour_;
	private TextView min_;
	private TextView sec_;
	private int hour,min,sec;
	private Time NOWtime;
	private Time settime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_set);
		NOWtime = new Time();
		NOWtime.setToNow();
		
		hour_ = (TextView)findViewById(R.id.hour_set);
		hour_.setText(NOWtime.hour+"");
		
		min_ = (TextView)findViewById(R.id.min_set);
		min_.setText(NOWtime.minute+"");
		
		sec_ = (TextView)findViewById(R.id.sec_set);
		sec_.setText(NOWtime.second+"");		
		
		set = (Button)findViewById(R.id.set);
		set.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				integer number;
				CharSequence ss = hour_.getText();
				String shour = ss.toString().trim();
				
				ss = min_.getText();
				String smin = ss.toString().trim();
				
				ss = sec_.getText();
				String ssec = ss.toString().trim();
				
				if(shour.equals(""))
				{					
					Toast.makeText(getApplicationContext(), "请输入小时", 500).show();
					return;
				}
				else 
				{
					hour = Integer.parseInt(shour);
					if(hour<0||hour>23)
					{
						Toast.makeText(getApplicationContext(), "小时时间格式错误", 500).show();
						return;
					}
				}
				
				if(smin.equals(""))
				{					
					Toast.makeText(getApplicationContext(), "请输入分钟", 500).show();
					return;
				}
				else 
				{
					min = Integer.parseInt(smin);
					if(min<0||min>=60)
					{
						Toast.makeText(getApplicationContext(), "分钟时间格式错误", 500).show();
						return;
					}
				}
				
				if(ssec.equals(""))
				{					
					Toast.makeText(getApplicationContext(), "请输入秒", 500).show();
					return;
				}
				else 
				{
					sec = Integer.parseInt(ssec);
					if(sec<0||sec>=60)
					{
						Toast.makeText(getApplicationContext(), "秒时间格式错误", 500).show();
						return;
					}
				}
				
				try {
					SystemDateTime.setTime(hour, min);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Toast.makeText(getApplicationContext(), "时间设置正确", 500).show();
				
//				if();
				
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.time_set, menu);
		return true;
	}

}
