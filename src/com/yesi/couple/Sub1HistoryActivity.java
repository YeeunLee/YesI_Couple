package com.yesi.couple;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Sub1HistoryActivity extends ActivitySet {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub1_history);

		final SQLiteDBListHelper helper = new SQLiteDBListHelper(this);
		final List<TableSub1> historyList = helper.selectAllSub1();
		ArrayList<String> historyStrings = new ArrayList<String>();

		TableSub1 tmp;
		for (int i = historyList.size()-1;i>=0;i--) {
			tmp = historyList.get(i);
			historyStrings.add(tmp.getMyName() + " ♡ " + tmp.getYourName()
					+ " = " + tmp.getResult());
		}

		final ArrayAdapterSet<String> adapter = new ArrayAdapterSet<String>(this,
				R.layout.listview, historyStrings);

		ListView listView = (ListView) findViewById(R.id.listView1);
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
							helper.deleteSub1(historyList.get(position));
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
		getMenuInflater().inflate(R.menu.sub1_history, menu);
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
