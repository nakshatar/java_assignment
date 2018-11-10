package com.assignment.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onCreate invoked");
        Toast.makeText(getApplicationContext(), "onCreate invoked", Toast.LENGTH_SHORT).show();
        final TextView create = (TextView)findViewById(R.id.textView);
        final EditText email = (EditText)findViewById(R.id.editText3);
        final EditText password = (EditText)findViewById(R.id.editText4);
        final Button login= (Button)findViewById(R.id.button2);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DBHelper(getApplicationContext());

                String e=email.getText().toString();
                String p=password.getText().toString();
                boolean valid=db.validate(e,p);
                if(valid == true) {
                    Toast.makeText(MainActivity.this,"login successful",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Details.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"not successful",Toast.LENGTH_LONG).show();
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
            }
        });

    }

}
