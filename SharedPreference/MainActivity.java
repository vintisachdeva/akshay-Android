package com.bmpl.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText firstName, lastName;
    Button login, cancel;
    TextView textView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText)findViewById(R.id.editTextFirstName);
        lastName = (EditText)findViewById(R.id.editTextLastName);
        login = (Button)findViewById(R.id.buttonLogin);
        cancel = (Button)findViewById(R.id.buttonCancel);

        textView = (TextView)findViewById(R.id.resultTextView);

        login.setOnClickListener(this);
        cancel.setOnClickListener(this);

        sharedPreferences = this.getSharedPreferences("user-data", MODE_PRIVATE);

        fetchingData();
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()){

            case R.id.buttonLogin:

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("firstName", firstName.getText().toString() );
                editor.putString("lastName", lastName.getText().toString());

                editor.commit();

                break;

            case R.id.buttonCancel:

                break;

        }
    }

    private void fetchingData(){

        String firstName = sharedPreferences.getString("firstName", "No-data");
        String lastName = sharedPreferences.getString("lastName", "No-data");

        textView.setText(firstName + " " + lastName);
    }
}
