package com.yesi.couple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubActivity1_1 extends ActivitySet {

	LinearLayout capLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub1_1);
		Intent intent = this.getIntent();
		String myName = intent.getStringExtra("myName");
		String yourName = intent.getStringExtra("yourName");
		TextView resultTxt = (TextView) findViewById(R.id.resultTxt);
		Algorithm al = new Algorithm();
		String result = al.message(myName, yourName);

		Button button = (Button) findViewById(R.id.captureBtn);
		capLayout = (LinearLayout) findViewById(R.id.linearLayout);

		if(result.equals(""))
		{
			resultTxt.setText("한글 이름을 입력하세요.");
			return;
		}
		else {
			resultTxt.setText(myName + "과 " + yourName + "은\n" + result);
		}
		SQLiteDBListHelper helper = new SQLiteDBListHelper(this);

		helper.insertSub1(new TableSub1(myName, yourName, result));


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_activity1_1, menu);
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

	public void onClickCaptureBtn(View v) {

		try {
			String dirName = "YouAndI_Dir";
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

			String imgName = format.format(new Date());
			
			File sdCardPath = Environment.getExternalStorageDirectory();
			File dirs = new File(sdCardPath,dirName);

			if (!dirs.exists()) {
				dirs.mkdirs();
			}

			capLayout.buildDrawingCache();
			Bitmap captureView = capLayout.getDrawingCache();
			
			File img = new File(sdCardPath.getAbsolutePath() + "/" + dirName + "/" + imgName
					+ ".jpeg");

			FileOutputStream fos = new FileOutputStream(img);

			captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);
			sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
					Uri.parse("file://"+ Environment.getExternalStorageDirectory())));

			shareImge(img);			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private void shareImge(File img) {
		// TODO Auto-generated method stub
		
		Uri mSaveImageUri = Uri.fromFile(img); // file의 경로를 uri로 변경
		Intent intent = new Intent(Intent.ACTION_SEND); // 전송 메소드를 호출.
														// Intent.ACTION_SEND
		intent.setType("image/jpeg"); // jpg 이미지를 공유 하기 위해 Type을 정의
		intent.putExtra(Intent.EXTRA_STREAM, mSaveImageUri); // 사진의 Uri를 가지고 옴
		startActivity(Intent.createChooser(intent, "Choose")); // Activity를 이용하여
																// 호출
	}
}
