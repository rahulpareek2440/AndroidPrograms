package com.example.anima;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;


public class MainActivity extends Activity {
	AnimatorSet wheelSet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView wheel = (ImageView) findViewById(R.id.wheel);
		wheelSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.wheel_spin);
		wheelSet.setTarget(wheel);
		wheelSet.start();
		ImageView sun = (ImageView)findViewById(R.id.sun);
		//load the sun movement animation
		AnimatorSet sunSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.sun_swing);
		//set the view as target
		sunSet.setTarget(sun);
		//start the animation
		sunSet.start();
		ValueAnimator skyAnim = ObjectAnimator.ofInt
			    (findViewById(R.id.car_layout), "backgroundColor", 
			    Color.rgb(0x66, 0xcc, 0xff), Color.rgb(0x00, 0x66, 0x99));
		skyAnim.setDuration(3000);
		skyAnim.setRepeatCount(ValueAnimator.INFINITE);
		skyAnim.setRepeatMode(ValueAnimator.REVERSE);
		skyAnim.setEvaluator(new ArgbEvaluator());
		skyAnim.start();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
