package com.example.allfunctions;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Message extends Activity {
	
	private String content;
	private String number;
	private TextView telnum;
	private TextView con;
	private Button send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		telnum =(TextView)findViewById(R.id.reciver);
		con = (TextView)findViewById(R.id.content);
		
		send = (Button)findViewById(R.id.send);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("smsto:"+ telnum.getText().toString()); 
				Intent it = new Intent(Intent.ACTION_SENDTO, uri); 
				it.putExtra("sms_body", con.getText().toString()); 
				startActivity(it); 
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.message, menu);
		return true;
	}

}
