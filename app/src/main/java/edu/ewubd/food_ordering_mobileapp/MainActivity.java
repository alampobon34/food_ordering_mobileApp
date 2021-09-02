package edu.ewubd.food_ordering_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database g = new Database(this);
        SQLiteDatabase db = g.getReadableDatabase();






        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, edu.ewubd.food_ordering_mobileapp.LoginActivity.class);
                startActivity(i);

            }
        });

        findViewById(R.id.buttonSignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, edu.ewubd.food_ordering_mobileapp.SignUpActivity.class);
                startActivity(i);

            }
        });
    }
}