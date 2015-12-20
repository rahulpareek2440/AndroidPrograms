package com.example.databaseexample;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;

public class Main2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		
		String[] queryParams = new String[1];
		queryParams[0] = "MI";
		PlayerDataBase pdb = new PlayerDataBase(this);
		pdb.open();
		Cursor result = pdb.getPlayerData(queryParams);
		if (result.moveToNext()) {
			String data1 = result.getString(0);
			String data2 = result.getString(1);
			String data3 = result.getString(2);
			TextView tv1 = (TextView) findViewById(R.id.textView1);
			tv1.setText(data1);
			TextView tv2 = (TextView) findViewById(R.id.textView2);
			tv2.setText(data2);
			TextView tv3 = (TextView) findViewById(R.id.textView3);
			tv3.setText(data3);
		}
		pdb.close();

	}
}
