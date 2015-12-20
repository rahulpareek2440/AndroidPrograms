package com.example.addtwonumbers;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button b1=(Button) findViewById(R.id.button1);
		final EditText ed1=(EditText) findViewById(R.id.editText1);
		final EditText ed2=(EditText) findViewById(R.id.editText2);
		final TextView tv1= (TextView) findViewById(R.id.textView3);
	//	final EditText ed3=(EditText) findViewById(R.id.editText3);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String a = EditTexttxtbox1.getText().toString();  
		            b = txtbox2.getText().toString();  
		            vis = Integer.parseInt(a)+Integer.parseInt(b);
								
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
