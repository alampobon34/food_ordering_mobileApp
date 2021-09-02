package edu.ewubd.food_ordering_mobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String dbname = "food_ordering_app.db";


    public Database(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String user_query = "CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,user_id VARCHAR(50) UNIQUE,email VARCHAR(255) UNIQUE,password VARCHAR(100))";
        db.execSQL(user_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean user_insert(String user_id, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id",user_id);
        values.put("email",email);
        values.put("password",password);
        Boolean user = check_user(user_id);
        long r = db.insert("users",null,values);
        if(r==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean check_user(String user_id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where user_id=?",new String[] {user_id});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean check_email(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email=?",new String[] {email});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean check_login(String user_id, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where user_id = ? and password = ?",new String[]{user_id,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }


}
