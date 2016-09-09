package com.example.allfunctions;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BuleTeeth extends Activity {

	private Button open;
	private Button close;
	private BluetoothAdapter mBluetoothAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bule_teeth);
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter(); 
		
		open = (Button)findViewById(R.id.open);
		open.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				
		        if (mBluetoothAdapter == null) 
		        { 
		            Toast.makeText(BuleTeeth.this, "本机没有找到蓝牙硬件或驱动！", Toast.LENGTH_SHORT).show(); 
		            
		        } 
		        // 如果本地蓝牙没有开启，则开启  
		        if (!mBluetoothAdapter.isEnabled())
		        { 
		            // 我们通过startActivityForResult()方法发起的Intent将会在onActivityResult()回调方法中获取用户的选择，比如用户单击了Yes开启，  
		            // 那么将会收到RESULT_OK的结果，  
		            // 如果RESULT_CANCELED则代表用户不愿意开启蓝牙  
		            Intent mIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE); 
		            startActivityForResult(mIntent, 1); 
		            // 用enable()方法来开启，无需询问用户(实惠无声息的开启蓝牙设备),这时就需要用到android.permission.BLUETOOTH_ADMIN权限。  
		            // mBluetoothAdapter.enable();  
		            // mBluetoothAdapter.disable();//关闭蓝牙  
		        }
		        Toast.makeText(BuleTeeth.this, "已打开蓝牙！", Toast.LENGTH_SHORT).show(); 
		      }
		});
		
		
		close = (Button)findViewById(R.id.close);
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mBluetoothAdapter.disable();
				Toast.makeText(BuleTeeth.this, "已关闭蓝牙！", Toast.LENGTH_SHORT).show(); 
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bule_teeth, menu);
		return true;
	}

}
