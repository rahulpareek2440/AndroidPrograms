package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView listview=(ListView) findViewById(R.id.listView1);
		String[] values = new String[] { "Ruapli", "Manisha","Smita" };
		final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
