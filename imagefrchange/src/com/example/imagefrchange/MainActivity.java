package com.example.imagefrchange;



import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.ImageView;




public class MainActivity extends Activity {
	Image Viewimage View;
	int []imageArray={R.drawable.h,R.drawable.tulips};

	@Override
	protectedvoidonCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView)findViewById(R.id.imageView1);

	final Handler handler = new Handler();
	    Runnable runnable = newRunnable()
	    {
	inti=0;
	publicvoid run() 
	                {
	imageView.setImageResource(imageArray[i]);
	i++;
	if(i>imageArray.length-1)
	                    {
	i=0;    
	                    }
	handler.postDelayed(this, 3000);  //for interval...
	                }

	    };
	handler.postDelayed(runnable, 1000); //for initial delay..
	  }


	

	@Override
	publicbooleanonCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		returntrue;
	}

}

