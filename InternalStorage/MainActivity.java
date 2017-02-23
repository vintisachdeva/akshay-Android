package com.bmpl.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button saveButton, loadButton;
    EditText firstName, mobileNo;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button)findViewById(R.id.Save);
        loadButton = (Button)findViewById(R.id.Load);

        firstName = (EditText)findViewById(R.id.firstNameEditText);
        mobileNo = (EditText)findViewById(R.id.mobileNo);
        textView=(TextView)findViewById(R.id.Result);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String name = firstName.getText().toString();
        String mobile = mobileNo.getText().toString();

        switch (view.getId())
        {
            case R.id.Save:

                BufferedWriter bufferedWriter;

                try
                {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput("user_data", MODE_PRIVATE )));

                    bufferedWriter.write(name + "\n");

                    bufferedWriter.write(mobile + "\n");

                    Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();

                    bufferedWriter.flush();

                    bufferedWriter.close();
                }

                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                catch (Exception e)
                {
                    e.printStackTrace();
                }

                break;

            case R.id.Load:

                BufferedReader bufferedReader;

                try {

                    bufferedReader=new BufferedReader(new InputStreamReader(openFileInput("user_data")));

                    String line = null;

                    while ((line = bufferedReader.readLine())!=null)
                    {
                            Toast.makeText(MainActivity.this, "Data is = " +line, Toast.LENGTH_LONG).show();
                    }

                    bufferedReader.close();
                    /*    int s=bufferedReader.read();
                    while (s!=-1)
                    {
                         arr=bufferedReader.readLine();
                    }
                    String arr1= arr;
                    textView.setText(arr1);*/
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}