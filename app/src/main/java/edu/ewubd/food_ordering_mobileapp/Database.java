package edu.ewubd.food_ordering_mobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.ewubd.food_ordering_mobileapp.Models.FoodItem;

public class Database extends SQLiteOpenHelper {
    private static final String dbname = "food_ordering_app.db";


    public Database(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String user_query = "CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,user_id VARCHAR(50) UNIQUE,email VARCHAR(255) UNIQUE,password VARCHAR(100))";
        db.execSQL(user_query);

        String fooditem_query = "CREATE TABLE foodItems(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(100),description VARCHAR(200),price VARCHAR(100))";
        db.execSQL(fooditem_query);

        String cart_query = "CREATE TABLE cart(id INTEGER PRIMARY KEY AUTOINCREMENT, user_id VARCHAR(50) UNIQUE,item_name VARCHAR(50), quantity VARCHAR(50))";
        db.execSQL(cart_query);

        String order_query = "CREATE TABLE orders(id INTEGER PRIMARY KEY AUTOINCREMENT, user_id VARCHAR(50), user_name VARCHAR(100),phone VARCHAR(100),address VARCHAR(50), item_name VARCHAR(100)," +
                "quantity VARCHAR(50), total_price VARCHAR(50))";
        db.execSQL(order_query);

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
        //Boolean user = check_user(user_id);
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



    public boolean check_item(String user_id,String item_name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from cart where user_id=? and item_name=?",new String[]{user_id,item_name});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }


    public boolean order_insert(String user_id, String user_name,String phone, String address,String item_name,String quantity,String total_price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id",user_id);
        values.put("user_name",user_name);
        values.put("phone",phone);
        values.put("address",address);
        values.put("item_name",item_name);
        values.put("quantity",quantity);
        values.put("total_price",total_price);
        long r = db.insert("orders",null,values);
        if(r==-1){
            return false;
        }
        else{
            return true;
        }
    }


    public boolean cart_insert(String user_id, String item_name, String quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id",user_id);
        values.put("item_name",item_name);
        values.put("quantity",quantity);
        Boolean item = check_item(user_id,item_name);
        if(item==false){
            long r = db.insert("cart",null,values);
            if(r==-1){
                return false;
            }
            else{
                return true;
            }

        }
        else{
            return true;
        }

    }



    public ArrayList<FoodItem> get_foodItems(){
        ArrayList<FoodItem> foodItems = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from foodItems",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToFirst()){
                FoodItem item = new FoodItem();
                item.setName(cursor.getString(1));
                item.setDescription(cursor.getString(2));
                item.setPrice(cursor.getString(3));
                item.setImage(R.drawable.burger);
                foodItems.add(item);

            }
        }
        cursor.close();
        db.close();
        return foodItems;
    }









}
