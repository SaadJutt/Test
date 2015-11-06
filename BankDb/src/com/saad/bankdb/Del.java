package com.saad.bankdb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class Del extends Activity {
    Button b;
    EditText e;
    SQLiteDatabase db;
    SQLiteOpenHelper d;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.del_layout);
 
        b=(Button)findViewById(R.id.bdel);
        e=(EditText)findViewById(R.id.acciddel);
        final Context context=this;
        try
        {
           db=openOrCreateDatabase("Banking1",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        }
        catch(SQLiteException e)
        {
          e.printStackTrace();
          System.out.print("ERROR.............");
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=(e.getText().toString());
               try
                {
                   String d="DELETE FROM bank WHERE id="+t;
                    db.execSQL(d);
                }
                catch(Exception e)
                {
                   System.out.print("Error..................");
                }
               
                e.setText("");
                Toast.makeText(Del.this, "Deleted...", 2000).show();
                Intent i=new Intent(context,Admin.class);
                startActivity(i);
            }
        });
    }
}