package com.yesi.couple;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Sub2HistoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub2_history);
		
		final SQLiteDBListHelper helper = new SQLiteDBListHelper(this);
		final List<TableSub2> historyList = helper.selectAllSub2();
		ArrayList<String> historyStrings = new ArrayList<String>();

		for (TableSub2 tmp : historyList) {
			historyStrings.add(tmp.getMyName() + " ♡ " + tmp.getYourName()
					+ " = " + tmp.getResult());
		}
		

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, historyStrings);

		ListView listView = (ListView) findViewById(R.id.listView2);
		listView.setAdapter(adapter);

		SwipeDismissListViewTouchListener touchListener = new SwipeDismissListViewTouchListener(
				listView,
				new SwipeDismissListViewTouchListener.DismissCallbacks() {

					@Override
					public void onDismiss(ListView listView,
							int[] reverseSortedPositions) {
						// TODO Auto-generated method stub
						for (int position : reverseSortedPositions) {
							adapter.remove(adapter.getItem(position));
							helper.deleteSub2(historyList.get(position));
						}
						adapter.notifyDataSetChanged();
						
					}

					@Override
					public boolean canDismiss(int position) {
						// TODO Auto-generated method stub
						return true;
					}
				});
		listView.setOnTouchListener(touchListener);
		listView.setOnScrollListener(touchListener.makeScrollListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub2_history, menu);
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
