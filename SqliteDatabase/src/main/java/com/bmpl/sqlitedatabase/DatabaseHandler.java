package com.bmpl.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class DatabaseHandler extends SQLiteOpenHelper
{

    EditText editText;

    private final String TAG = DatabaseHandler.class.getSimpleName();

    private static final String DATABASE_NAME = "MY_DATABASE.db";

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = " USER_DATA ";

    private static final String COLUMN_ID = " _ID ";

    private static final String COLUMN_FIRST = " FIRST_NAME ";

    private static final String COLUMN_LAST = " LAST_NAME ";

    private static final String TEXT = "TEXT";

    private static final String COMMA = ",";

    private static final String CREATE_ENTRY = " CREATE TABLE " + TABLE_NAME + "( " +
                                                COLUMN_ID + " Auto_increment PRIMARY KEY " + COMMA +
                                                COLUMN_FIRST + TEXT + COMMA +
                                                COLUMN_LAST + TEXT + " );";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        // creating table in database

        sqLiteDatabase.execSQL(CREATE_ENTRY);
        Log.i(TAG, "Table created in database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
        // upgrade already created table in database
        sqLiteDatabase.execSQL("DROP " + TABLE_NAME + " IF EXISTS");

        onCreate(sqLiteDatabase);
    }


    public void addData()
    {


    }
}