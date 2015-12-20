package com.example.siomdb;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.*;
public class DB extends SQLiteOpenHelper 
{
    DB(Context context)
    {
    	super(context,"firstsiob.db",null,1);
    }
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table demotest(name text,addr text,cont text)");
			    
		
	}
.
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table  if exists demotest");
		  onCreate(db);
		  }
    public boolean isAdd(String f,String l,String m)throws Exception
    {
    	SQLiteDatabase db=this.getWritableDatabase();
    	ContentValues cv=new ContentValues();
    	cv.put("name",f);
    	cv.put("addr",l);
    	cv.put("cont",m);
    long l1=db.insert("demotest",null,cv);
      if(l1>0)
      {
    	  return true;
      }
      else
      {
    	
    	return false;
      }
    }
      
}
