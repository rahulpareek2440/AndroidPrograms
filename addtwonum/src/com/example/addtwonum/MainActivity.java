package com.example.addtwonum;

import android.app.Activity;
import android.graphics.Color;
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
		final Button b=(Button) findViewById(R.id.button1) ;
		final EditText  ed1= (EditText) findViewById(R.id.editText1);
		final EditText  ed2= (EditText) findViewById(R.id.editText2);
		final TextView tv=(TextView) findViewById(R.id.textView3);
		
		
	b.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			int val1 = Integer.parseInt(ed1.getText().toString()) ;
			int val2 = Integer.parseInt(ed2.getText().toString() );
			tv.setTextColor(Color.GREEN);
			tv.setBackgroundColor(Color.RED);
			tv.setText(" " + (val1 + val2) );
			//tv.setBackgroundColor(getResources().getColor(android.R.color.primary_text_light_nodisable));
			//tv.setTextColor(getResources().getColor(android.R.color.primary_text_light_nodisable));
								
		}
	}) ;   
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}