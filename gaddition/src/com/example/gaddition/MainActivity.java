package com.example.gaddition;

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
		final EditText ed1 =(EditText) findViewById(R.id.editText1);
		//final EditText ed2 =(EditText) findViewById(R.id.editText2);
		//final TextView tv =(TextView) findViewById(R.id.textView3);
		final TextView tv2 =(TextView) findViewById(R.id.textView4);
		final Button b =(Button) findViewById(R.id.button1);
		
			
			@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
