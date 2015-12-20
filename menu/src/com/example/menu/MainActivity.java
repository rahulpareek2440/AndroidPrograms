package com.example.menu;


import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  Button btn = (Button) findViewById(R.id.btn);
  registerForContextMenu(btn);
 }
 @Override
 public void onCreateContextMenu(ContextMenu menu, View v,
   ContextMenuInfo menuInfo) {
  super.onCreateContextMenu(menu, v, menuInfo);
  menu.setHeaderTitle("Context Menu");
  menu.add(0, v.getId(), 0, "Action 1");
  menu.add(0, v.getId(), 0, "Action 2");
  menu.add(0, v.getId(), 0, "Action 3");
 }
 @Override
 public boolean onContextItemSelected(MenuItem item) {
  if (item.getTitle() == "Action 1") {
   Toast.makeText(this, "Action 1 invoked", Toast.LENGTH_SHORT).show();
  } else if (item.getTitle() == "Action 2") {
   Toast.makeText(this, "Action 2 invoked", Toast.LENGTH_SHORT).show();
  } else if (item.getTitle() == "Action 3") {
   Toast.makeText(this, "Action 3 invoked", Toast.LENGTH_SHORT).show();
  } else {
   return false;
  }
  return true;
 }

}


