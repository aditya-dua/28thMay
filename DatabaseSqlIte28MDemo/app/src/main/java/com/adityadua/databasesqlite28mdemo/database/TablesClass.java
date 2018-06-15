package com.adityadua.databasesqlite28mdemo.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.adityadua.databasesqlite28mdemo.utils.Constants;

/**
 * Created by AdityaDua on 13/06/18.
 */

public class TablesClass extends SQLiteOpenHelper {
/* Context : for pacakge and app related info
    Query : The query to create the table
 */
    Context context;
    String query = "Create table IF NOT EXISTS "+ Constants.BOOK_TABLE+" ("+
                    Constants.ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    Constants.BOOK_NAME+" TEXT, "+
                    Constants.BOOK_AUTHOR+" TEXT, "+
                    Constants.BOOK_ID+" TEXT);";

    // Constructor will simply create
    public TablesClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // onCreate : Once DB is created , we call the onCreate to actually
    // to actually create the tables in the DB.
    // That's why we have , execSQL to execute the query that
    // will create the table the DB.

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(sqLiteDatabase);

    }
}
