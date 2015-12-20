package com.example.newpop;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
 
public class MainActivity extends Activity {
 
 Button popup_but;
 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  popup_but = (Button) findViewById(R.id.);
  popup_but.setOnClickListener(new OnClickListener() {
 
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    PopupMenu popup = new PopupMenu(PopupMenuDemo.this, popup_but);
    popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
 
    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
     public boolean onMenuItemClick(MenuItem item) {
      Toast.makeText(PopupMenuDemo.this,
        "You Clicked : " + item.getTitle(),
        Toast.LENGTH_SHORT).show();
      return true;
     }
    });
 
    popup.show();
   }
  });
 }
}
