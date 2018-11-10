package com.assignment.myapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.assignment.myapp.R.id.editText11;
import static com.assignment.myapp.R.id.editText12;
import static com.assignment.myapp.R.id.editText14;

public class Details extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //final EditText user_id=(EditText)findViewById(editText5);
        final EditText sex=(EditText)findViewById(editText11);
        final EditText weigth=(EditText)findViewById(editText12);
        final EditText height=(EditText)findViewById(R.id.editText13);
        final EditText bloodgroup=(EditText)findViewById(editText14);
        final EditText age=(EditText)findViewById(R.id.editText15);
        final EditText name=(EditText) findViewById(R.id.editText17);


        Button save=(Button)findViewById(R.id.button5);
        Button next=(Button)findViewById(R.id.button6);

        SQLiteDatabase.CursorFactory context;
        db= new DBHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1= name.getText().toString();
                String s2 = sex.getText().toString();
                String s3 = weigth.getText().toString();
                String s4 = height.getText().toString();
                String s5 = bloodgroup.getText().toString();
                String s6 = age.getText().toString();


                boolean isInserted1 = db.insertUserDetails(s1,s2,s3,s4,s5,s6);
                if (isInserted1 == true) {
                    Toast.makeText(getApplicationContext(), "data inserted",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "data not inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener()
        {

               public void onClick(View view) {

                   Intent i = new Intent(getApplicationContext(), Search.class);

                   startActivity(i);
                }
            });


        }
    }

