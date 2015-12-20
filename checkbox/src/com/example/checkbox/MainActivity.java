package com.example.checkbox;

import android.os.Bundle;  
import android.app.Activity;  
import android.view.Menu;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.*;  
  
public class MainActivity extends Activity {  
    CheckBox Schiller,Talukdar,Wrox;  
    Button buttonOrder;  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        addListenerOnButtonClick();  
    }  
public void addListenerOnButtonClick(){  
    //Getting instance of CheckBoxes and Button from the activty_main.xml file  
    Schiller=(CheckBox)findViewById(R.id.checkBox1);  
    Talukdar=(CheckBox)findViewById(R.id.checkBox2);  
    Wrox=(CheckBox)findViewById(R.id.checkBox3);  
    buttonOrder=(Button)findViewById(R.id.button1);  
  
    //Applying the Listener on the Button click  
    buttonOrder.setOnClickListener(new OnClickListener(){  
  
        @Override  
        public void onClick(View view) {  
            int totalamount=0;  
            StringBuilder result=new StringBuilder();  
            result.append("Selected Items:");  
            if(Schiller.isChecked()){  
                result.append("\nSchiller 500Rs");  
                totalamount+=500;  
            }  
            if(Talukdar.isChecked()){  
                result.append("\nTalukdar 350Rs");  
                totalamount+=350;  
            }  
            if(Wrox.isChecked()){  
                result.append("\nWrox 600Rs");  
                totalamount+=600;  
            }  
            result.append("\nTotal: "+totalamount+"Rs");  
            //Displaying the message on the toast  
            Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();  
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