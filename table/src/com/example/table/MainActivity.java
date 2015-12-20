package com.example.table;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ScrollViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView view =  (TextView) findViewById(R.id.TextView02);
        String s="";
        for (int i=0; i < 500; i++) {
          s += "vogella.com ";
        }
        view.setText(s);
    }
} 