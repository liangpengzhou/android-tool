package com.example.allfunctions;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import applycation.*;

public class MainActivity extends Activity {
	
	private Button Call;						//打电话
	private Button Message;						//发短信			
	private Button Email;						//打开系统邮箱
	private Button App;							//打开系统设置
	private Button Video;						//打开视频播放器
	private Button Music;						//音乐播放器
	private Button Recorder;					//录音机
	private Button Flash;						//电筒
	private Button FM;							//收音机
	private Button Light;						//亮度
	private Button GPS;							//GPS开关
	private Button WIFI;						//WIFI开关
	private Button Rotate;						//旋转
	private Button Fly;							//飞行模式
	private Button Blueteeth;						//蓝牙
	private Button Time_set;						//设置时间
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		getPackageManager
		Call =  (Button)findViewById(R.id.Call);
		Call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,Call.class );
				startActivity(intent);
			}
		});
		
		Message = (Button)findViewById(R.id.Message);
		Message.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,Message.class );
				startActivity(intent);
			}
		});
		
		Email = (Button)(findViewById(R.id.Email));
		Email.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 
				Intent data=new Intent(Intent.ACTION_SENDTO); 
				data.setData(Uri.parse("mailto:way.ping.li@gmail.com")); 
				data.putExtra(Intent.EXTRA_SUBJECT, "这是标题"); 
				data.putExtra(Intent.EXTRA_TEXT, "这是内容"); 
				startActivity(data); 
			}
		});
		
		App = (Button)findViewById(R.id.App);
		App.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				ArrayList<AppInfo> appList = new ArrayList<AppInfo>(); 
				List<PackageInfo> packages = getPackageManager().getInstalledPackages(0); 
				for(int i=0;i<packages.size();i++) { 
				PackageInfo packageInfo = packages.get(i); 
				AppInfo tmpInfo = new AppInfo(); 
				tmpInfo.appname = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString(); 
				tmpInfo.packagename = packageInfo.packageName; 
				tmpInfo.versionName = packageInfo.versionName; 
				tmpInfo.versionCode = packageInfo.versionCode; 
				tmpInfo.appicon = packageInfo.applicationInfo.loadIcon(getPackageManager()); 
				appList.add(tmpInfo); 
				}
			}
		});
		
		Video = (Button)findViewById(R.id.Video);
		Video.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Intent.ACTION_VIEW);
				Uri uri = Uri.parse("file:///android_asset/Meta7.flv");
				it.setDataAndType(uri, "audio/flv");
				startActivity(it);			
			}
		});
		
		Music = (Button)findViewById(R.id.Music);
		Music.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,Music.class );
				startActivity(intent);
				
			}
		});
		
		Recorder = (Button)findViewById(R.id.Record);
		Recorder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent mi = new Intent(Media.RECORD_SOUND_ACTION); 
				startActivity(mi);
			}
		});
		
		Flash = (Button)findViewById(R.id.Flash);
		Flash.setOnClickListener(new OnClickListener() {
			
			//待修改
			//http://www.eoeandroid.com/thread-185954-1-1.html
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,CameraAndFlash.class );
				startActivity(intent);    

			}
		});
		
		FM = (Button)findViewById(R.id.FM);
		FM.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Light = (Button)findViewById(R.id.Light);
		Light.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		GPS = (Button)findViewById(R.id.GPS);
		GPS.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,GPS.class );
				startActivity(intent);
			}
		});
		
		WIFI = (Button)findViewById(R.id.WIFI);
		WIFI.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Rotate = (Button)findViewById(R.id.Rotate);
		Rotate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Rotate.class);
				startActivity(intent);
				
			}
		});
		
		Fly = (Button)findViewById(R.id.Fly);
		Fly.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Blueteeth = (Button)findViewById(R.id.Blueteeth);
		Blueteeth.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,BuleTeeth.class );
				startActivity(intent);
			}
		});
		
		Time_set = (Button)findViewById(R.id.Time);
		Time_set.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this,Time_set.class );
				startActivity(intent);
				
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
