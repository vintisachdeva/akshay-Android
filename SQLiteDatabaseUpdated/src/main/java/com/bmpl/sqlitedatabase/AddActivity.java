package com.bmpl.sqlitedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{

    EditText firstName;
    Button saveButton, cancelButton;

    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initialize();

        databaseHandler = new DatabaseHandler(this);

    }

    private void initialize()
    {

        firstName = (EditText)findViewById(R.id.firstName);

        saveButton = (Button)findViewById(R.id.saveButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {

            case R.id.saveButton:

                databaseHandler.addData(new Data(firstName.getText().toString()));

                Toast.makeText(AddActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                break;


            case R.id.cancelButton:
                break;
        }

    }
}