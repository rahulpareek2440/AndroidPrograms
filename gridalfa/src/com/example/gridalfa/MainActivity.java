package com.example.gridalfa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    static final String[] letters = new String[] {  

            "A", "B", "C", "D", "E", 
            "F", "G", "H", "I", "J", 
            "K", "L", "M", "N", "O", 
            "P", "Q", "R", "S", "T", 
            "U", "V", "W", "X", "Y", "Z"}; 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

GridView grid = (GridView) findViewById(R.id.gridview);
       ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, letters);
        grid.setAdapter(adapter);  
        grid.setOnItemClickListener(new OnItemClickListener() { 
  public void onItemClick(AdapterView parent, View v, int position, long id) { 

             
      Toast.makeText(getApplicationContext(), 

          ((TextView) v).getText(), Toast.LENGTH_SHORT).show(); 

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
