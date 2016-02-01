package com.yesi.couple;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SubActivity2 extends Activity {
	TextView textViews[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub2);
		Typeface typeface = Typeface.createFromAsset(getAssets(), "NanumPen.ttf");
		textViews = new TextView[4];
		
		textViews[0] = (TextView)findViewById(R.id.myNameTxt2);		
		textViews[1] = (TextView)findViewById(R.id.myAgeTxt2);		
		textViews[2] = (TextView)findViewById(R.id.yourNameTxt2);		
		textViews[3] = (TextView)findViewById(R.id.yourAgeTxt2);

		textViews[0].setTypeface(typeface);
		textViews[1].setTypeface(typeface);
		textViews[2].setTypeface(typeface);
		textViews[3].setTypeface(typeface);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_activity2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onClickSub2_1Btn(View v)
	{
		EditText myName = (EditText)findViewById(R.id.myNameEditTxt2);
		EditText yourName = (EditText)findViewById(R.id.yourNameEditTxt2);
		EditText myAge = (EditText)findViewById(R.id.myAgeEditTxt2);
		EditText yourAge = (EditText)findViewById(R.id.yourAgeEditTxt2);
		
		if(myName.getText().toString().equals(""))
		{
			Toast.makeText(getApplicationContext(), "당신의 이름을 쓰세요.", Toast.LENGTH_LONG).show();
		}
		else if(myAge.getText().toString().equals(""))
		{
			Toast.makeText(getApplicationContext(), "당신의 나이를 쓰세요.", Toast.LENGTH_LONG).show();
		}
		else if(yourName.getText().toString().equals(""))
		{
			Toast.makeText(getApplicationContext(), "상대방의 이름을 쓰세요.", Toast.LENGTH_LONG).show();
		}
		else if(yourAge.getText().toString().equals(""))
		{
			Toast.makeText(getApplicationContext(), "상대방의 나이를 쓰세요.", Toast.LENGTH_LONG).show();
		}
		else
		{
			Intent intent = new Intent(SubActivity2.this,SubActivity2_1.class);

			intent.putExtra("myName", myName.getText().toString());
			intent.putExtra("yourName", yourName.getText().toString());
			
			startActivity(intent);
		}
		
	}
}
