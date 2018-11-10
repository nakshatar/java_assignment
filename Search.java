package com.assignment.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
    EditText Name2;
    Button search;
    ListView list;
    List itm;
    String sex;
   String height;
    String weight;
    String age;
    String blood_group;
    DBHelper database;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Name2 = (EditText) findViewById(R.id.editText16);
        search = (Button) findViewById(R.id.button7);
        list = (ListView) findViewById(R.id.list);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchButtonClick();


            }
        });



        itm = new ArrayList<>();
        //String[] listItems = new String[]{name};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itm);
        list.setAdapter(adapter);
    }



    private void searchButtonClick() {
        String searchInoutText = Name2.getText().toString();
        database = new DBHelper(getApplicationContext());
        sex = database.fetchByID(searchInoutText);
        height=database.fetchByID1(searchInoutText);
        weight=database.fetchByID2(searchInoutText);
        age=database.fetchByID3(searchInoutText);
        blood_group=database.fetchByID5(searchInoutText);
        if (sex != null) {
            Toast.makeText(getApplicationContext(), sex, Toast.LENGTH_LONG).show();
            adapter.add(sex);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (height != null) {
            Toast.makeText(getApplicationContext(), height, Toast.LENGTH_LONG).show();
            adapter.add(height);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (weight != null) {
            Toast.makeText(getApplicationContext(), weight, Toast.LENGTH_LONG).show();
            adapter.add(weight);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (age != null) {
            Toast.makeText(getApplicationContext(), age, Toast.LENGTH_LONG).show();
            adapter.add(age);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (blood_group!=null) {
            Toast.makeText(getApplicationContext(), blood_group, Toast.LENGTH_LONG).show();
            adapter.add(blood_group);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
    }
}



