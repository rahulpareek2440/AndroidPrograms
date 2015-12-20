package com.example.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import static com.example.databaseexample.Constants.DATABASE_NAME;
import static com.example.databaseexample.Constants.NAME;
import static com.example.databaseexample.Constants.TEAM;
import static com.example.databaseexample.Constants.RUNS;
import static com.example.databaseexample.Constants.WICKETS;
import static com.example.databaseexample.Constants.TABLE_NAME;

public class PlayerDataBase {

	private SQLiteDatabase db;
	private final Context context;
	private final DBHelper dbHelper;

	public PlayerDataBase(Context c) {
		context = c;
		dbHelper = new DBHelper(context, DATABASE_NAME, null,
				Constants.DATABASE_VERSION);
	}

	public void close() {
		db.close();
	}

	public void open() throws SQLiteException {
		try {
			db = dbHelper.getWritableDatabase();
		} catch (SQLiteException ex) {
			db = dbHelper.getReadableDatabase();
		}
	}
	
	public Cursor getPlayerData(String[] params) {
		//Cursor result = db.query(TABLE_NAME, new String[] { NAME, TEAM, RUNS, WICKETS},  null,  null,  null,  null, null);
		//Cursor result=
		//	db.rawQuery("SELECT "+NAME+","+TEAM+","+RUNS+","+WICKETS+" FROM "+
		//			TABLE_NAME+" WHERE "+TEAM+" = ?",parms);
		Cursor result = db.query(TABLE_NAME, new String[] {NAME,TEAM, RUNS}, TEAM + "=?", params, null, null, null);
		return result;
	}
	
	public void insertPlayerData(ContentValues values) {
		db.insertOrThrow(TABLE_NAME, null, values);
	}
	
	public void updatePlayer(ContentValues values,String[] params) {
		db.update(TABLE_NAME, values, NAME+"=?", params);
	}
}
