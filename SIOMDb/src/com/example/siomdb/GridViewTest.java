package com.example.siomdb;

import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class GridViewTest extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gtest);
 	}
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
