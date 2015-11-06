package com.saad.bankdb;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.*;
import java.util.ArrayList;
import java.util.List;
 
public class ViewAcc extends Activity {
    SQLiteDatabase db;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout2);
 

         try
        {
            db=openOrCreateDatabase("Banking1",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            Cursor c= db.rawQuery("SELECT * FROM bank",null);
 
            TextView v=(TextView)findViewById(R.id.v);
            c.moveToFirst();
 
            String temp="";
            while(! c.isAfterLast())
            {
                String s2=c.getString(0);
                String s3=c.getString(1);
                String s4=c.getString(2);
                temp=temp+"\n Id:"+s2+"\tType:"+s3+"\tBal:"+s4;
                c.moveToNext();
            }
            v.setText(temp);
        }
        catch(SQLiteException e)
        {
 
        }
    }
}