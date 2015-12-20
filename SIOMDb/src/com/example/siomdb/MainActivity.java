package com.example.siomdb;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener
{
   EditText n,a,c;
   Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SQLiteOpenHelper sqh=new DB(this);
		sqh.getWritableDatabase();
       btn=(Button)this.findViewById(R.id.button1);
       n=(EditText)this.findViewById(R.id.editText1);
       a=(EditText)this.findViewById(R.id.editText2);
       c=(EditText)this.findViewById(R.id.editText3);
       btn.setOnClickListener(this);
	}
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void onClick(View v)
	{
		try
		{
			DB db=new DB(this);
			String f=n.getText().toString();
			String l=a.getText().toString();
			String m=c.getText().toString();
			
			boolean b=db.isAdd(f, l, m);
			if(b)
			{
	Toast.makeText(this,"save",Toast.LENGTH_LONG).show();
			}
			else
			{
				Toast.makeText(this,"Some problem is there",Toast.LENGTH_LONG).show();
							
			}
		}
		catch(Exception e)
		{
			Toast.makeText(this,"event fire"+e.toString(),Toast.LENGTH_LONG).show();
				
		}
	}

}
