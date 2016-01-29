package com.yesi.couple;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDBListHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "DATABASE_TMP";
	private static final int DATABASE_VERSION = 1;

	private static final String TABLE_SUB1 = "TableSub1";
	private static final String SUB1_PRIMARY_KEY_ID = "id";
	private static final String SUB1_MYNAME = "myname";
	private static final String SUB1_YOURNAME = "yourname";
	private static final String SUB1_RESULT = "result";

	private static final String TABLE_SUB2 = "TableSub2";
	private static final String SUB2_PRIMARY_KEY_ID = "id";
	private static final String SUB2_MYNAME = "myname";
	private static final String SUB2_YOURNAME = "yourname";
	private static final String SUB2_RESULT = "result";

	public SQLiteDBListHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		String sqlQuery =  "CREATE TABLE " + TABLE_SUB2 + "("
				+ SUB2_PRIMARY_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ SUB2_MYNAME + " TEXT," + SUB2_YOURNAME + " TEXT,"
				+ SUB2_RESULT + " TEXT)";

		db.execSQL(sqlQuery);
		
		sqlQuery = "CREATE TABLE " + TABLE_SUB1 + "("
				+ SUB1_PRIMARY_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ SUB1_MYNAME + " TEXT," + SUB1_YOURNAME + " TEXT,"
				+ SUB1_RESULT + " TEXT)";

		db.execSQL(sqlQuery);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		String sqlQuery = "DROP TABLE IF CREATE EXISTS " + TABLE_SUB1;
		db.execSQL(sqlQuery);

		sqlQuery = "DROP TABLE IF CREATE EXISTS " + TABLE_SUB2;
		db.execSQL(sqlQuery);

		onCreate(db);
	}

	public void insertSub1(TableSub1 sub1) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put(SUB1_MYNAME, sub1.getMyName());
		values.put(SUB1_YOURNAME, sub1.getYourName());
		values.put(SUB1_RESULT, sub1.getResult());

		db.insert(TABLE_SUB1, null, values);
		db.close();
	}

	public void deleteSub1(TableSub1 sub1) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_SUB1, SUB1_PRIMARY_KEY_ID + " = ?",
				new String[] { String.valueOf(sub1.getId()) });

		db.close();
	}

	public List<TableSub1> selectAllSub1() {
		List<TableSub1> sub1s = new ArrayList<TableSub1>();

		String sqlQuery = "SELECT * FROM " + TABLE_SUB1;
		SQLiteDatabase db = this.getWritableDatabase();

		Cursor cs = db.rawQuery(sqlQuery, null);

		if (cs.moveToFirst()) {
			do {
				sub1s.add(new TableSub1(Integer.parseInt(cs.getString(0)), cs
						.getString(1), cs.getString(2), cs.getString(3)));
			} while (cs.moveToNext());
		}
		cs.close();
		db.close();
		
		return sub1s;
	}
	public void insertSub2(TableSub2 sub2) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put(SUB2_MYNAME, sub2.getMyName());
		values.put(SUB2_YOURNAME, sub2.getYourName());
		values.put(SUB2_RESULT, sub2.getResult());

		db.insert(TABLE_SUB2, null, values);
		db.close();
	}

	public void deleteSub2(TableSub2 sub2) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_SUB2, SUB2_PRIMARY_KEY_ID + " = ?",
				new String[] { String.valueOf(sub2.getId()) });

		db.close();
	}

	public List<TableSub2> selectAllSub2() {
		List<TableSub2> sub2s = new ArrayList<TableSub2>();

		String sqlQuery = "SELECT * FROM " + TABLE_SUB2;
		SQLiteDatabase db = this.getWritableDatabase();

		Cursor cs = db.rawQuery(sqlQuery, null);

		if (cs.moveToFirst()) {
			do {
				sub2s.add(new TableSub2(Integer.parseInt(cs.getString(0)), cs
						.getString(1), cs.getString(2), cs.getString(3)));
			} while (cs.moveToNext());
		}
		cs.close();
		db.close();
		
		return sub2s;
	}
}
