packagecom.example.intentimage;

importandroid.app.Activity;
importandroid.content.Intent;
importandroid.os.Bundle;
importandroid.view.Menu;
importandroid.view.View;
importandroid.view.View.OnClickListener;
importandroid.widget.Button;
importandroid.widget.EditText;
importandroid.widget.TextView;

publicclassMainActivityextends Activity {

	@Override
	protectedvoidonCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		finalEditTexted = (EditText) findViewById(R.id.editText1);
		finalEditText ed1 = (EditText) findViewById(R.id.editText2);
		finalTextViewtv = (TextView) findViewById(R.id.textView1);
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(newOnClickListener() {
			
			@Override
			publicvoidonClick(View arg0) {
				// TODO Auto-generated method stub
				String user = ed.getText().toString();
				String pass = ed1.getText().toString();
				if((user.equals("siom"))&& (pass.equals("123")))
				{Intent i;
				i = newIntent(getApplicationContext(),Main2Activity.class);
				startActivity(i);}
				else
				{tv.setText("Username/Password is not correct.");}
			}
		});
	}

	@Override
	publicbooleanonCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		returntrue;
	}

}

