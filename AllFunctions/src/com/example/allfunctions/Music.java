package com.example.allfunctions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Music extends Activity {

	private Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
		start = (Button) findViewById(R.id.start);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Intent.ACTION_VIEW);
				Uri uri = Uri.parse("file:///android_asset/Honor.mp3");
				it.setDataAndType(uri, "audio/mp3");
				startActivity(it);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.music, menu);
		return true;
	}

}
