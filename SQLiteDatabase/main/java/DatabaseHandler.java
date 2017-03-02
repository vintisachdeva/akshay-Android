package com.bmpl.crudsqlitedatabase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final String TAG = DatabaseHandler.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myDataValues";
    private static final String TABLE_NAME = "records";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_VALUE = "FirstColumn";

    private static final String TABLE_QUERY = "CREATE TABLE " + TABLE_NAME +
            "( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_VALUE + " TEXT " + ");";


    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i(TAG, "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(TABLE_QUERY);
        Log.i(TAG, " Table created ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addRecord(Record record)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_VALUE, record.getData());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();
        Log.i(TAG, "Data inserted");
    }

    public List<String> getAllRecords(){
        List<String> recordList = new ArrayList<String>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{COLUMN_VALUE}, null, null, null, null, null);

        if(cursor.moveToFirst()){
            do{
                String data = cursor.getString(cursor.getColumnIndex(COLUMN_VALUE));
                recordList.add(data);
            }while (cursor.moveToNext());
        }
        Log.i(TAG, "recordList=" +recordList);
        return recordList;
    }
}
