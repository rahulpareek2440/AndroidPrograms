package com.example.videodemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 final VideoView myv = (VideoView) findViewById(R.id.videoView1);
		 myv.setVideoURI(Uri.parse("android.resource://"+ getPackageName()+"/"+R.raw.frozen));
		 myv.setMediaController(new MediaController(this));
		 myv.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
