package com.example.primenumber;

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
		final EditText ed = (EditText) findViewById(R.id.editText1);
		final TextView tv = (TextView) findViewById(R.id.textView2);
		Button b =(Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int val1 = Integer.parseInt(ed.getText().toString());
				int flag =0;
				int i;
				for(i=2;i<val1;i++)
				{
					if(val1%i==0)
					{ flag=1;
					break;
					}
				}
				
				if (flag==0)
				{tv.setText("Number is Prime");}
				else
				{tv.setText("Number is Not Prime");}	
				
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
