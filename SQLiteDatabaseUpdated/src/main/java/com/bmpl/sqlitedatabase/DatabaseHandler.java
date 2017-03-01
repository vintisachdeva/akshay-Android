package com.bmpl.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper
{

    private final String TAG = DatabaseHandler.class.getSimpleName();

    private static final String DATABASE_NAME = "MY_DATABASE";

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = " USER_DATA ";

    private static final String COLUMN_ID = " _ID ";

    private static final String COLUMN_FIRST = " FIRST_NAME ";

    private static final String TEXT = "TEXT";

    private static final String COMMA = ",";

    private static final String CREATE_ENTRY = " CREATE TABLE " + TABLE_NAME + "( " +
                                                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + COMMA +
                                                COLUMN_FIRST + TEXT + " );";

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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(sqLiteDatabase);
    }


    public void addData(Data data)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_FIRST, data.getFirstName());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();

        Log.i(TAG, " Data inserted ");

    }

    public List<String> readData()
    {
        ArrayList<String> dataList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{COLUMN_FIRST}, null, null, null, null, null);

        if(cursor.moveToFirst()){

            do {
                String data = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST));

                dataList.add(data);

            }while (cursor.moveToNext());
        }

        return dataList;
    }
}