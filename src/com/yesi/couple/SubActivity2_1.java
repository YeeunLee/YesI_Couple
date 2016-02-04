package com.yesi.couple;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SubActivity2_1 extends ActivitySet {

	private LinearLayout capLayout;
	private TextView resultTxt;
	private String myName;
	private String yourName;
	private Algorithm al;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub2_1);

		Button button = (Button) findViewById(R.id.shareBtn2);
		capLayout = (LinearLayout) findViewById(R.id.linearLayout2);

		Intent intent = this.getIntent();
		myName = intent.getStringExtra("myName");
		yourName = intent.getStringExtra("yourName");
		resultTxt = (TextView)findViewById(R.id.percentTxt);
		
		al = new Algorithm();

		int myPercent = al.percent(myName, yourName);
		int yourPercent = al.percent(yourName, myName);
		String result;

		if(myPercent==-1||yourPercent==-1)
		{
			resultTxt.setText( "한글이름을 입력하세요.");
			return;
		}
		else if(myPercent>yourPercent)
		{
			result = myName+"(이)가 "+yourName+"을/를 \n더 좋아하지롱~";
			
		}
		else if(myPercent==yourPercent)
		{
			result= myName+"와 "+yourName+"는 천생연분이네 \n결혼해";
		}
		else
		{
			result = yourName+"(이)가 "+myName+"을/를 \n더 좋아하지롱~";
		}	

		resultTxt.setText(result);

		SQLiteDBListHelper helper = new SQLiteDBListHelper(this);
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
					Uri.parse("file://" + Environment.getExternalStorageDirectory())));

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
