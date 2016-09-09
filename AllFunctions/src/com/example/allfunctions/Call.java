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
import android.widget.Toast;

public class Call extends Activity {

	private Button call;
	private TextView telnum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.caaaaa);
		telnum = (TextView)findViewById(R.id.telnum);
		
		call = (Button)findViewById(R.id.call);
		call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CharSequence ss = telnum.getText();
				String tel = ss.toString().trim();
				if(tel.equals(""))
				{
					Toast.makeText(getApplicationContext(), "请输入号码", 500).show();
					return;
				}
				else
				{
//					int xx = Integer.parseInt(tel);
//					Uri uri = Uri.parse("tel:"+ tel); 
//					Intent it = new Intent(Intent.ACTION_DIAL, uri); 
//					startActivity(it); 
					Intent intent = new Intent();  
	                intent.setAction(Intent.ACTION_CALL);  
	                //url:统一资源定位符  
	                //uri:统一资源标示符（更广）  
	                intent.setData(Uri.parse("tel:" + tel));  
	                //开启系统拨号器  
	                startActivity(intent); 
				}				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.call, menu);
		return true;
	}

}
