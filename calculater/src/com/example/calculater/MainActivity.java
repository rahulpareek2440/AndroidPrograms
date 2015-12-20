package com.example.calculater;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
public static int a;
public static String b;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
         Button b1 =(Button) findViewById(R.id.button1);
         Button b2 =(Button) findViewById(R.id.button2);
         Button b3 =(Button) findViewById(R.id.button3);
         Button b4 =(Button) findViewById(R.id.button4);
        Button b5 =(Button) findViewById(R.id.button5);
        Button b6 =(Button) findViewById(R.id.button6);
         Button b7 =(Button) findViewById(R.id.button7);
        Button b8 =(Button) findViewById(R.id.button8);
        Button b9 =(Button) findViewById(R.id.button9);
        Button b0 =(Button) findViewById(R.id.button10);
        Button b12 =(Button) findViewById(R.id.button12);
        final TextView tv1 =(TextView) findViewById(R.id.textView1);
         Button b11 = (Button) findViewById(R.id.button11);
         Button b13 = (Button) findViewById(R.id.button13);
         Button b14 = (Button) findViewById(R.id.button14);
         
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tv1 == null)
				tv1.setText("1");
				else 
					tv1.append("1");
					
			}
		});



b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("2");
			else
				tv1.append("2");
		}
	});
b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("3");
			else
				tv1.append("3");
		}
	});
b4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("4");
			else
				tv1.append("4");
		}
	});
b5.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("5");
			else
				tv1.append("5");
		}
	});
b6.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("6");
			else
				tv1.append("6");
		}
	});
b7.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("7");
			else
				tv1.append("8");
		}
	});
b8.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("7");
			else
				tv1.append("8");
		}
	});
b9.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("9");
			else
				tv1.append("9");
		}
	});
b0.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (tv1==null)
			tv1.setText("");
			else
				tv1.append("0");
		}
	});

b12.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			if (tv1==null)
			tv1.setText("");
			else
			{a = Integer.parseInt(tv1.getText().toString());
			tv1.setText("+");
			b="+";
			
			}
						
		}
	});  
b13.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			if (tv1==null)
			tv1.setText("");
			else
			{a = Integer.parseInt(tv1.getText().toString());
			tv1.setText("-");
			b="-";
			
			}
			
				
		}
	});  

b14.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			tv1.setText("");
									
		}
	});  
b11.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			int val1 = Integer.parseInt(tv1.getText().toString());
			if (b=="+")
			tv1.setText(""+(a+val1));
			if (b=="-")
				tv1.setText(""+(a-val1));
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
