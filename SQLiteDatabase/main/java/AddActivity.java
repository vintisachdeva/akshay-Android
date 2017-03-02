package com.bmpl.crudsqlitedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText dataEditText;
    Button saveButton;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dataEditText = (EditText)findViewById(R.id.valueEditText);
        saveButton = (Button)findViewById(R.id.saveButton);

        databaseHandler = new DatabaseHandler(AddActivity.this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                databaseHandler.addRecord(new Record(dataEditText.getText().toString()));

                Toast.makeText(AddActivity.this, "Data inserted", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}