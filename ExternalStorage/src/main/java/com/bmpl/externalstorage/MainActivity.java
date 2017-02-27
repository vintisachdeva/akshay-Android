package com.bmpl.externalstorage;

import android.media.session.MediaSession;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    EditText firstName, lastName;
    Button save, retrieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

    }

    public void initialize()
    {
        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);

        save = (Button)findViewById(R.id.saveButton);
        retrieve = (Button)findViewById(R.id.retreiveButton);

        save.setOnClickListener(this);
        retrieve.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String first = firstName.getText().toString();

        String last = lastName.getText().toString();

        switch (view.getId())
        {
            case R.id.saveButton:

                File pathOfSdCard = Environment.getExternalStorageDirectory();

                if(pathOfSdCard.canWrite()){

                    File file = new File(pathOfSdCard, "MyData.txt");
                    try
                    {

                        FileWriter fileWriter = new FileWriter(file);

                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        bufferedWriter.write(first + "\n");
                        bufferedWriter.write(last + "\n");

                        Toast.makeText(MainActivity.this, "Data is saved", Toast.LENGTH_LONG).show();

                        bufferedWriter.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                break;

            case R.id.retreiveButton:

                break;
        }
    }
}
