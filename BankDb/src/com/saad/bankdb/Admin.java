package com.saad.bankdb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.saad.bankdb.R;
 
public class Admin extends Activity
{
    Button create;
    Button del;
    Button view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);
        create=(Button)findViewById(R.id.create);
        del=(Button)findViewById(R.id.del);
        view=(Button)findViewById(R.id.view);
        final Context context=this;
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context,Create.class);
                startActivity(i);
            }
        });
 
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context,Del.class);
                startActivity(i);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context,ViewAcc.class);
                startActivity(i);
            }
        });
    }
}