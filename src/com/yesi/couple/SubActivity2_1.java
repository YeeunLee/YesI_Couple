package com.yesi.couple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SubActivity2_1 extends Activity {

	private TextView resultTxt;
	private String myName;
	private String yourName;
	private Algorithm al;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub2_1);
		
		Intent intent = this.getIntent();
		myName = intent.getStringExtra("myName");
		yourName = intent.getStringExtra("yourName");
		resultTxt = (TextView)findViewById(R.id.percentTxt);
		
		al = new Algorithm();

		int myPercent = al.percent(myName, yourName);
		int yourPercent = al.percent(yourName, myName);
		String result;

		SQLiteDBListHelper helper = new SQLiteDBListHelper(this);
		
		if(myPercent>yourPercent)
		{
			result = myName+"(이)가 "+yourName+"을/를 \n더 좋아하지롱~";
			
		}
		else if(myPercent==yourPercent)
		{
			result="천생연분이네 \n결혼해";
		}
		else
		{
			result = yourName+"(이)가 "+myName+"을/를 \n더 좋아하지롱~";
		}	

		resultTxt.setText(result);
		helper.insertSub2(new TableSub2(myName,yourName,result));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_activity2_1, menu);
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
}
