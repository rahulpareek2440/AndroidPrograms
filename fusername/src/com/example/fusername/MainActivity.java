package com.example.fusername;

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
		final EditText ed1 = (EditText) findViewById(R.id.editText1);
		final EditText ed2 = (EditText) findViewById(R.id.editText2);
		final TextView tv = (TextView) findViewById(R.id.textView3);
		Button b1 = (Button) findViewById(R.id.button1 );
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String user = ed1.getText().toString();
				String pass = ed2.getText().toString();
				if(user.equals("SIOM") && (pass.equals("123")))
				{
					tv.setText("Usrname and Pasward is correct");
					Intent i;
					i =new Intent( getApplicationContext(),MainActivity2.class) ;
					startActivity(i);
				}
				else {
					tv.setText("Usrname and Pasward is  not correct");
				}
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
