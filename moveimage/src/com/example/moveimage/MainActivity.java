package com.example.moveimage;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button.setOnTouchListener(new OnTouchListener(){

	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            // TODO Auto-generated method stub
	            switch(event.getAction()){
	                case MotionEvent.ACTION_MOVE:
	                    RelativeLayout.LayoutParams relativeLayout=(RelativeLayout.LayoutParams) oneButton.getLayoutParams();
	                    int x=(int)event.getRawX();
	                    int y=(int)event.getRawY();

	                    relativeLayout.leftMargin=x-50;
	                    relativeLayout.rightMargin=x-50;
	                    relativeLayout.topMargin=y-50;
	                    relativeLayout.bottomMargin=y-50;
	                    oneButton.setLayoutParams(relativeLayout);
	                    break;
	                    default:
	                        break;
	            }
	            return true;
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
