package com.adityadua.databasesqlite28mdemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.adityadua.databasesqlite28mdemo.model.BookData;
import com.adityadua.databasesqlite28mdemo.utils.Constants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AdityaDua on 13/06/18.
 * This class will be used for
 * 1) OPening OF DB
 * 2) To perform CURD Operations
 *          Create,Update,Read & Delete
 * 3)  Read : Count Of All the elements
 *            Reading All the elements
 *            Reading On Specific Conditions
 *
 */

public class DBHelper {

    private SQLiteDatabase db;
    private final Context context;
    private final TablesClass tablesClass;
    private static DBHelper db_helper;

    // DBHelper : DB operations ,
    // this class is used for DB interactions
    // I have made this class in such a way that I can create only 1 process can use it
    // We want only 1 instance of this class

    private DBHelper(Context context){
        this.context= context;
        tablesClass = new TablesClass(context, Constants.DATABASE_NAME,null,Constants.DB_VERSION);

    }

    public static DBHelper getInstance(Context context){

        if(db_helper == null){
            db_helper = new DBHelper(context);
            db_helper.open();
        }
        return db_helper;
    }
    public void open(){
        try {
            db = tablesClass.getWritableDatabase();
        }catch (Exception e){
            e.printStackTrace();
            db = tablesClass.getReadableDatabase();
        }
    }
    public void close(){
        if(db.isOpen()){
            db.close();
        }
    }

    // Insert into tablename (column 1, column2,....) values (1,2,3,4,....);
    // key value pair
    // column1 => value1
    // column2 => value2
    //....
    // tablename, key value pair

// To insert data in DB
    // Table Name :
    // Pair Of ContentValues
    public long insertContentValues(String tableName, ContentValues cv){

        long id = 0;

        try{
            db.beginTransaction();
            id = db.insert(tableName,null,cv);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

        return  id;
    }

    // To fetch values from DB : select * from tab where bookName = 'a'; result has 50 rows

    /**
     *
     * @param tabName => which table you want ot get the number of rows
     * @param where => any where condition on which you want to fetch the numbe rof rows
     *
     * @return No Of Rows : Int
     *
     * query (boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
     * do you data in table not to be repeated : ditinct
     * table : tableName
     * array of columns : any specific columns you want ot select, if you want all , PASS NULL
     * ex : slect name , age from table;
     * selection : where , between
     * Columns you want to perform your selection on
     * group by : groupby Name; otherwise pass NULL
     * having : having clause or NULL
     *  orderby : order by NAme ASC;
     *  limit : to see how many rows you want to fetch at once
     *
     *  Returns : Cursor :
     */
    public int getFullContent(String tabName,String where){

        int rowCount = 0;


        Cursor c = db.query(false,tabName,null,where,null,null,null,null,null);

        try{
            c.moveToFirst();

            if(c!=null){
                rowCount = c.getCount();

            }
        }finally {
            c.close();
        }
        return rowCount;
    }

    // Update : How to update the row
    public int updateRecord(String tabName,ContentValues cv,String where , String [] whereArgs){

        int rowCount = 0;
        try{
            db.beginTransaction();
            rowCount = db.update(tabName,cv,where,whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

        return  rowCount;
    }

    public void deleteRecord(String tabName,String where,String [] whereArgs){

        try{
            db.beginTransaction();
            db.delete(tabName,where,whereArgs);
            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
    }

    public List<BookData> getAllBooks(){
        List<BookData> books = new LinkedList<>();
        String query ="select * from "+Constants.BOOK_TABLE;

        Cursor c = db.rawQuery(query,null);

        BookData book = null;

        if(c.moveToFirst()){

            do{
                book = new BookData();
                book.setId(c.getInt(0));
                book.setBookName(c.getString(1).toString());
                book.setBookAuthor(c.getString(2).toString());
                book.setBookId(c.getString(3).toString());

                books.add(book);
            }while(c.moveToNext());

            c.close();

        }
        return  books;
    }










}
