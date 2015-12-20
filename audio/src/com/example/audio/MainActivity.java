package com.example.audio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	static MediaPlayer media;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b= (Button) findViewById(R.id.button1);
		Button b1= (Button) findViewById(R.id.button2);
		new MediaPlayer();
		media = MediaPlayer.create(getBaseContext(), R.raw.b);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				media.reset();
				new MediaPlayer();
				media = MediaPlayer.create(getBaseContext(), R.raw.b);
				media.start();
				
				
			}
			
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				media.stop(); 
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
