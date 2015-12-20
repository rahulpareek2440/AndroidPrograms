package com.example.username;

import android.app.Activity;
import android.content.Intent;
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
		final EditText ed = (EditText) findViewById(R.id.editText1);
		final EditText ed1 = (EditText) findViewById(R.id.editText2);
		final TextView tv = (TextView) findViewById(R.id.textView1);
		Button b = (Button) findViewById(R.id.button1);
		
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
							
					String user = ed.getText().toString();
					String pass = ed1.getText().toString();
					if((user.equals("siom"))&& (pass.equals("123")))
					{tv.setText("Username/Password is correct.");
					Intent i;
					i = new Intent(getApplicationContext(),MainActivity2.class);
					startActivity(i);}
					else
					{tv.setText("Username/Password is not correct.");}
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
