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
		            Toast.makeText(BuleTeeth.this, "����û���ҵ�����Ӳ����������", Toast.LENGTH_SHORT).show(); 
		            
		        } 
		        // �����������û�п���������  
		        if (!mBluetoothAdapter.isEnabled())
		        { 
		            // ����ͨ��startActivityForResult()���������Intent������onActivityResult()�ص������л�ȡ�û���ѡ�񣬱����û�������Yes������  
		            // ��ô�����յ�RESULT_OK�Ľ����  
		            // ���RESULT_CANCELED������û���Ը�⿪������  
		            Intent mIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE); 
		            startActivityForResult(mIntent, 1); 
		            // ��enable()����������������ѯ���û�(ʵ������Ϣ�Ŀ��������豸),��ʱ����Ҫ�õ�android.permission.BLUETOOTH_ADMINȨ�ޡ�  
		            // mBluetoothAdapter.enable();  
		            // mBluetoothAdapter.disable();//�ر�����  
		        }
		        Toast.makeText(BuleTeeth.this, "�Ѵ�������", Toast.LENGTH_SHORT).show(); 
		      }
		});
		
		
		close = (Button)findViewById(R.id.close);
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mBluetoothAdapter.disable();
				Toast.makeText(BuleTeeth.this, "�ѹر�������", Toast.LENGTH_SHORT).show(); 
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
