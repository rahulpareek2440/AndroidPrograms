package com.example.video;



import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
 
public class MainActivity extends Activity {
   private VideoView v;
 
   @Override
   public void onCreate(Bundle icicle) {
     super.onCreate(icicle);
     setContentView(R.layout.activity_main);  
     v = (VideoView) findViewById(R.id.surface_view);
     v.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.a));
     v.setMediaController(new MediaController(this));
     v.requestFocus();
   }
}