package hu.py82c7.homework.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TAKI on 2016.12.10..
 */

public class DatabaseHelperContact extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="contacts.db";
    private static final String TABLE_NAME ="contacts";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_NAME ="name";
    private static final String COLUMN_EMAIL ="email";
    private static final String COLUMN_ADDRESS ="address";
    private static final String COLUMN_PASS ="pass";
    private static final String COLUMN_ADMIN ="isadmin";
    SQLiteDatabase db;
    private static final String TABLE_CREATE= "create table "+TABLE_NAME
            +" (id integer primary key not null ," +
            " name text not null, email text not null , address text not null , " +
            "pass text not null , isadmin integer not null);";

    public DatabaseHelperContact(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cur = db.rawQuery(query,null);
        int count = cur.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_ADDRESS,c.getAddress());
        values.put(COLUMN_PASS,c.getPass());
        values.put(COLUMN_ADMIN,c.getAdmin());
        db.insert(TABLE_NAME,null,values);
        db.close();

    }
    public String searchPass(String email){
        db= this.getReadableDatabase();
        String query = "select email, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a;
        String b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(email)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        db.close();
        return b;
    }
    public String searchName(String email){
        db= this.getReadableDatabase();
        String query = "select email, name from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a;
        String b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(email)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        db.close();
        return b;
    }

    public int searchAdmin(String email){
        db= this.getReadableDatabase();
        String query = "select email, isadmin from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a;
        int b = 2;
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(email)){
                    b = cursor.getInt(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        db.close();
        return b;
    }
}
