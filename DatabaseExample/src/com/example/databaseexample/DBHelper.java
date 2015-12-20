package com.example.databaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context) {
		super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
	}

	public DBHelper(Context context, String dbname, CursorFactory cf,
			int version) {
		super(context, dbname, cf, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + Constants.TABLE_NAME + " ("
				+ Constants.NAME + " TEXT PRIMARY KEY," + Constants.TEAM
				+ " TEXT," + Constants.RUNS + " TEXT," + Constants.WICKETS
				+ " TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
		onCreate(db);
	}

}
