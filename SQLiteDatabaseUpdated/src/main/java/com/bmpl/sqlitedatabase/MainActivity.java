package com.bmpl.sqlitedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    DatabaseHandler databaseHandler;
    List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initialize();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        dataList = databaseHandler.readData();
        read();

    }


    public void initialize()
    {
        databaseHandler = new DatabaseHandler(this);
        listView = (ListView)findViewById(R.id.listView);
        dataList = new ArrayList<>();
    }

    public void read(){
        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, dataList);

        listView.setAdapter(arrayAdapter);
    }
}
