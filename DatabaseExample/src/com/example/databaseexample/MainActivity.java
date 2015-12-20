package com.example.databaseexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import static com.example.databaseexample.Constants.TABLE_NAME;
import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.databaseexample.PlayerDataBase;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
final PlayerDataBase pdb = new PlayerDataBase(this);
        
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText team = (EditText) findViewById(R.id.team);
        final EditText runs = (EditText) findViewById(R.id.runs);
        final EditText wickets = (EditText) findViewById(R.id.wickets);
        
        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ContentValues cv = new ContentValues();
				cv.put("name", name.getText().toString());
				cv.put("team", team.getText().toString());
				cv.put("runs", runs.getText().toString());
				cv.put("wickets", wickets.getText().toString());
				pdb.open();
				pdb.insertPlayerData(cv);
				pdb.close();
			}
		});
    }
}

		
	
