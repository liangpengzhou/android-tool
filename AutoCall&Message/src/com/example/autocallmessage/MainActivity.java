package com.example.autocallmessage;

import java.util.List;

import android.R.string;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button BuCall = (Button) findViewById(R.id.Call);
		BuCall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < 100; i++) {
					Intent intent = new Intent(Intent.ACTION_CALL, Uri
							.parse("tel:" + "18729183427"));
					// 通知activtity处理传入的call服务
					startActivity(intent);
					Toast toast = Toast.makeText(getApplicationContext(),
							"Hello", 1000);
					toast.show();
				}

			}
		});
		Button BuMessage = (Button) findViewById(R.id.Message);
		BuMessage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String content = "此短信为测试短信，勿回";
				String phone = "18729183427";
				// Intent intent = new
				// Intent(Intent.ACTION_SENDTO,Uri.parse("smsto://"+phone));
				// intent.putExtra(content, "send detail");
				// startActivity(intent);
				for (int i = 0; i < 100; i++) {
					SmsManager smsManager = SmsManager.getDefault();
					List<String> divideContents = smsManager
							.divideMessage(content);
					for (String text : divideContents) {
						smsManager.sendTextMessage(phone, null, text, null,
								null);
					}
				}
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
