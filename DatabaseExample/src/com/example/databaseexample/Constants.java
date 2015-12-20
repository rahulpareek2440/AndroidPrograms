package com.example.databaseexample;

import android.provider.BaseColumns;

public interface Constants extends BaseColumns {
	public static final String DATABASE_NAME = "player.db";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE_NAME = "player_stats";
	// Columns in the database
	public static final String NAME = "name";
	public static final String TEAM = "team";
	public static final String RUNS = "runs";
	public static final String WICKETS = "wickets";
	

}