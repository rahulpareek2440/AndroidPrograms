package com.example.textchange;

import android.R.color;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView tv =(TextView) findViewById(R.id.textView1);
		final Button b1 =(Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
						
				tv.setTextColor(getResources().getColor(color.holo_blue_dark));
				tv.setText("this is new text");
				
				
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
