package com.assignment.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText Name,Email,NewPassword,mobile,login_id;
    Button ok,login_again;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Name = (EditText) findViewById(R.id.editText6);
        Email = (EditText) findViewById(R.id.editText7);
        NewPassword = (EditText)findViewById(R.id.editText8);
        mobile = (EditText)findViewById(R.id.editText9);
        login_id = (EditText)findViewById(R.id.editText10);
        ok = (Button) findViewById(R.id.button3);
        login_again = (Button)findViewById(R.id.button4);

        db = new DBHelper(this);

        ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String s1 = Name.getText().toString();
                String s2 = Email.getText().toString();
                String s3 = NewPassword.getText().toString();
                int s4 = Integer.parseInt(mobile.getText().toString());
                int s5 = Integer.parseInt(login_id.getText().toString());
                boolean isInserted = db.insert1(s1,s2,s3,s4,s5);
                if(isInserted == true)
                {
                    Toast.makeText(getApplicationContext(),"data is inserted ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"data is not inserted ",Toast.LENGTH_LONG).show();
                }


            }
        });

        login_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
