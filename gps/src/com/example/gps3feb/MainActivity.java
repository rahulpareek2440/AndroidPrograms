package com.example.gps3feb;

import java.util.concurrent.TimeUnit;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements Runnable {
	private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 0; // in Meters
	private static final long MINIMUM_TIME_BETWEEN_UPDATES = 5;

	protected LocationManager locationManager;
	static double n=0;
	Long s1,r1;

	//double startLon, startLat, newLon, newLat;

	Thread t1;
	EditText e1;
	TextView tv;

	// TODO store location not lon lat
	Location startLocation;
	double totalDistance = 0.0;
	long startTime = 0;
	long stopTime = 0;
	long totalTime = 0;
	double totalSpeed = 0;
	boolean isStartButtonPressed = false;

	long totalPauseTime = 0;
	long startPauseTime = 0;
	long stopPauseTime = 0;
	MyLocationListener gpsListener = new MyLocationListener();

	Button btnCurrentPosition,btnStartMove,btnPause,btnResume,btnStop,btnGetDistance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnCurrentPosition=(Button)findViewById(R.id.button1);//current position
		btnStartMove=(Button)findViewById(R.id.button2);//start moving.. calculates distance on clicking this
		btnPause=(Button)findViewById(R.id.button3);//pause
		btnResume=(Button)findViewById(R.id.button4);//resume
		btnStop=(Button)findViewById(R.id.button5);// stop
		btnGetDistance=(Button)findViewById(R.id.button6);//get distance
		e1=(EditText)findViewById(R.id.editText1);
		e1.setVisibility(View.GONE);
		tv=(TextView) findViewById(R.id.textView1);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 
				MINIMUM_TIME_BETWEEN_UPDATES, 
				MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
				new MyLocationListener()
				);
		btnCurrentPosition.setVisibility(View.GONE);
		btnStartMove.setVisibility(View.VISIBLE);
		btnResume.setVisibility(View.GONE);
		btnPause.setVisibility(View.GONE);
		btnStop.setVisibility(View.GONE);
		btnGetDistance.setVisibility(View.GONE);
		btnCurrentPosition.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				// showCurrentLocation();
			}
		});  
		btnStartMove.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				start(v);
				btnStartMove.setVisibility(View.GONE);
				btnPause.setVisibility(View.VISIBLE);
				btnStop.setVisibility(View.VISIBLE);
				btnResume.setVisibility(View.GONE);
				btnCurrentPosition.setVisibility(View.GONE);
			}

		});
		btnPause.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				start(v); 
				btnStartMove.setVisibility(View.GONE);
				btnPause.setVisibility(View.GONE);
				btnStop.setVisibility(View.VISIBLE);
				btnResume.setVisibility(View.VISIBLE);
				btnCurrentPosition.setVisibility(View.GONE);
			}
		});
		btnResume.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				start(v); 
				btnStartMove.setVisibility(View.GONE);
				btnPause.setVisibility(View.VISIBLE);
				btnStop.setVisibility(View.VISIBLE);
				btnResume.setVisibility(View.GONE);
				btnCurrentPosition.setVisibility(View.GONE);
			}
		});
		btnStop.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				start(v); 
				
				btnStartMove.setVisibility(View.VISIBLE);
				btnResume.setVisibility(View.GONE);
				btnPause.setVisibility(View.GONE);
				btnStop.setVisibility(View.GONE);
			}
		});
		btnGetDistance.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				start(v);
			}
		});

	}

	protected void showCurrentLocation() 
	{
		if (startLocation != null)
		{
			tv.setText("Latitude:"+startLocation.getLatitude()+"\nLongitude:"+startLocation.getLongitude());
			totalTime = TimeUnit.MILLISECONDS.toSeconds(((stopTime - startTime) - totalPauseTime));
			//tv.setText("distance in metres:"+String.valueOf(totalDistance)+"Velocity in m/sec :"+String.valueOf(totalDistance/totalTime)+"Time :"+String.valueOf(totalTime)+"Time in min :"+String.valueOf(String.format( "%.2f", (((double)totalTime)/60) )));
		}
		else
		{
			boolean gpsIsEnabled = locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER);
			if (gpsIsEnabled)
			{
				locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER, 
						MINIMUM_TIME_BETWEEN_UPDATES, 
						MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
						gpsListener
						);
			}
			tv.setText("is gps enabled " + String.valueOf(gpsIsEnabled));
			tv.setText("Sorry!!! Location is not available. Please try again.");
		}   
	}

	public void start (View v){

		switch(v.getId()){
		
		case R.id.button1:
			showCurrentLocation();
			break;
		case R.id.button2:
			totalDistance = 0.0;
			startTime = 0;
			stopTime = 0;
			totalTime = 0;
			totalSpeed = 0;
			totalPauseTime = 0;
			startPauseTime = 0;
			stopPauseTime = 0;
			isStartButtonPressed = false;

			//startGpsListener();
			startLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

			// startTime = location.getTime();
			startTime = System.currentTimeMillis();

			//startLon = location.getLongitude();
			//startLat = location.getLatitude();

			//	tv.setText("Latitude:"+startLat+"\nLongitude:"+startLon);
			isStartButtonPressed = true;

			showCurrentLocation();

			//	t1=new Thread(this);
			//t1.start();

			break;
		case R.id.button3:

			startPauseTime = System.currentTimeMillis();

			isStartButtonPressed=false;
			break;
		case R.id.button4:

			stopPauseTime = System.currentTimeMillis();
			totalPauseTime += stopPauseTime - startPauseTime;

			isStartButtonPressed=true;
			break;
		case R.id.button6:
			//tv.setText("Latitude:"+startLat+"\nLongitude:"+startLon);
			totalTime = TimeUnit.MILLISECONDS.toSeconds((stopTime - startTime) - totalPauseTime);

			tv.setText("distance in metres:"+String.valueOf(totalDistance)+"Velocity in m/sec :"+String.valueOf(totalDistance/totalTime)+"Time :"+String.valueOf(totalTime)+"Time in min :"+String.valueOf(String.format( "%.2f", (((double)totalTime)/60) )));
			break;
		case R.id.button5:

			Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			if (location1 != null)
			{
				calculateDistance(location1);
			}
			isStartButtonPressed = false;

			if (locationManager != null)
			{
				locationManager.removeUpdates(gpsListener);
			}

			stopTime = System.currentTimeMillis();
			totalTime = TimeUnit.MILLISECONDS.toSeconds((stopTime - startTime) - totalPauseTime);

			tv.setText("distance in metres:"+String.valueOf(totalDistance)+"\nVelocity in m/sec :"+String.valueOf(totalDistance/totalTime)+"\nTime :"+String.valueOf(totalTime)+"\nTime in min :"+String.valueOf(String.format( "%.2f", (((double)totalTime)/60) )));

			//showCurrentLocation();
		}
	}

	private class MyLocationListener implements LocationListener {

		public void onLocationChanged(Location location) {

			calculateDistance(location);

			String message = String.format(
					"New Location \n Longitude: %1$s \n Latitude: %2$s",
					location.getLongitude(), location.getLatitude()
					);
			//Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
			tv.setText(message);
		}

		public void onStatusChanged(String s, int i, Bundle b) {
			Toast.makeText(MainActivity.this, "Provider status changed",
					Toast.LENGTH_LONG).show();
		}

		public void onProviderDisabled(String s) {
			Toast.makeText(MainActivity.this,
					"Provider disabled by the user. GPS turned off",
					Toast.LENGTH_LONG).show();
			tv.setText("Provider disabled by the user. GPS turned off");
			btnStartMove.setClickable(false);
		}

		public void onProviderEnabled(String s) {
			Toast.makeText(MainActivity.this,
					"Provider enabled by the user. GPS turned on",
					Toast.LENGTH_LONG).show();
			tv.setText("");
			btnStartMove.setClickable(true);
		}

	}

	public class MyCount extends CountDownTimer{
		public MyCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}
		@Override
		public void onFinish() {
			//      counter= new MyCount(30000,1000);
			// counter.start();
			n=n+1;
		}
		@Override
		public void onTick(long millisUntilFinished) {
			s1=millisUntilFinished;
			r1=(30000-s1)/1000;
			e1.setText(String.valueOf(r1));
		}
	}

	@Override
	public void run() 
	{		    
		while(isStartButtonPressed == true)
		{
			//calculateDistance();
		}
	}

	//public double getDistance(double lat1, double lon1, double lat2, double lon2) {
	//  double latA = Math.toRadians(lat1);
	//  double lonA = Math.toRadians(lon1);
	//  double latB = Math.toRadians(lat2);
	// double lonB = Math.toRadians(lon2);
	// double cosAng = (Math.cos(latA) * Math.cos(latB) * Math.cos(lonB-lonA)) +
	//               (Math.sin(latA) * Math.sin(latB));
	// double ang = Math.acos(cosAng);
	// double dist = ang *6371;
	// return dist;
	//}


	protected void calculateDistance(Location currentlocation) {

		//Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

		//newLon = location.getLongitude();
		//newLat = location.getLatitude();

		//if(currentlocation.hasAccuracy())
		if (startLocation != null)
		{
			if (!(startLocation.getLatitude() == currentlocation.getLatitude() && startLocation.getLongitude() == currentlocation.getLongitude()))
			{
				// Accuracy is in rage of 20 meters, stop listening we have a fix
				//if(currentlocation.getAccuracy() < 1)
				{
					String message = String.format(
							"in loop Location \n Longitude: %1$s \n Latitude: %2$s",
							currentlocation.getLongitude(), currentlocation.getLatitude()
							);
					//Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
					tv.setText(message);

					//Location oldLoc = new Location("");
					//oldLoc.setLatitude(startLat);
					//oldLoc.setLongitude(startLon);

					totalDistance += currentlocation.distanceTo(startLocation);
					//startLat = newLat;
					//startLon = newLon;
					startLocation = currentlocation;

					totalSpeed += currentlocation.getSpeed();
				}
			}
		}
		else
		{
			startLocation = currentlocation;
			totalSpeed += currentlocation.getSpeed();
		}
	}

	private void startGpsListener()
	{

		//   if(locationManager != null)
		// hit location update in intervals of 5sec and after 10meters offset
		// 	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5, 1, gpsListener);   
	}

	private void stopGpsListner()
	{
		// if(locationManager != null)
		// 	locationManager.removeUpdates(gpsListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
