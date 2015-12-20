package com.example.viewinglist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ListView listView = (ListView) findViewById(R.id.listView1);
		List list = new ArrayList();
		String[] arr = new String[2];
	arr[0]="Riya";
	arr[1]="Avani";
	listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr));
	
	listView.setOnItemClickListener(new OnItemClickListener() {
		 @Override		 
         public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {           
         
          int itemPosition     = position;          
         
          String  itemValue    = (String) listView.getItemAtPosition(position);             
       
           Toast.makeText(getApplicationContext(),
             "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
             .show();}	
		
	});
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
