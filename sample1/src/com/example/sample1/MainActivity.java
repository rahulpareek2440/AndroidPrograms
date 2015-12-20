package com.example.sample1;

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
        final TextView tv1 =(TextView) findViewById(R.id.textView1);
        final EditText ed1 =(EditText) findViewById(R.id.editText1);
        final EditText ed2 =(EditText) findViewById(R.id.editText2);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			int val1 =	Integer.parseInt(ed1.getText().toString());
			int val2 =	Integer.parseInt(ed2.getText().toString());
			tv1.setText(""+(val1+val2));
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
