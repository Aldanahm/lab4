package com.example.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE" ;
    public static final String COLUMN_ID = "ID" ;
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME" ;
    public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE" ;
    public static final String COLUMN_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER" ;

    public DataBaseHelper(@Nullable Context context) {
        super (context, "customer.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_AGE + " INT, " + COLUMN_ACTIVE_CUSTOMER + " BOOL) ";
        sqLiteDatabase.execSQL(createTableStatement) ;
    }
public boolean addOne(customerModel cm)
{
    SQLiteDatabase db = this.getWritableDatabase() ;
    ContentValues cv = new ContentValues() ;

    cv.put(COLUMN_CUSTOMER_NAME, cm.getName());
    cv.put(COLUMN_CUSTOMER_AGE, cm.getAge());


    long insert = db.insert(CUSTOMER_TABLE, null, cv);
    if (insert == -1)
        return false;
    else
        return true ;
}
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
