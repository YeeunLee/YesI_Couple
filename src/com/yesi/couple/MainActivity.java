package com.yesi.couple;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button buttons[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Typeface typeface = Typeface.createFromAsset(getAssets(), "NanumPen.ttf");
		buttons = new Button[3];
		buttons[0] = (Button)findViewById(R.id.sub1Btn);
		buttons[1] = (Button)findViewById(R.id.sub2Btn);
		buttons[2] = (Button)findViewById(R.id.optionBtn);

		buttons[0].setTypeface(typeface);
		buttons[1].setTypeface(typeface);
		buttons[2].setTypeface(typeface);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void onClickSub1Btn(View v)
	{
		Intent intent = new Intent(MainActivity.this,SubActivity1.class);
		
		startActivity(intent);
	}
	public void onClickSub2Btn(View v)
	{
		Intent intent = new Intent(MainActivity.this,SubActivity2.class);
		
		startActivity(intent);
	}
	public void onClickOptBtn(View v)
	{
		Intent intent = new Intent(MainActivity.this,OptionActivity.class);
		
		startActivity(intent);
	}
}
