package com.bmpl.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{

    EditText firstName, lastName;
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
        lastName = (EditText)findViewById(R.id.lastName);

        saveButton = (Button)findViewById(R.id.saveButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String first = firstName.getText().toString();
        String last = lastName.getText().toString();

        switch (view.getId())
        {
            case R.id.saveButton:

                databaseHandler.addData();

                break;


            case R.id.cancelButton:
                break;
        }

    }
}