package com.example.sms1;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         
        final Button b1 = (Button) findViewById(R.id.button1);
        final EditText ed1 =(EditText) findViewById(R.id.editText1);
        final EditText ed2 =(EditText) findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               sendSMSMessage();
            }
         });

    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        String phoneNo = ed1.getText().toString();
        String message = ed2.getText().toString();

        try {
           SmsManager smsManager = SmsManager.getDefault();
           smsManager.sendTextMessage(phoneNo, null, message, null, null);
           Toast.makeText(getApplicationContext(), "SMS sent.",
           Toast.LENGTH_LONG).show();
        } catch (Exception e) {
           Toast.makeText(getApplicationContext(),
           "SMS faild, please try again.",
           Toast.LENGTH_LONG).show();
           e.printStackTrace();
        }
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
