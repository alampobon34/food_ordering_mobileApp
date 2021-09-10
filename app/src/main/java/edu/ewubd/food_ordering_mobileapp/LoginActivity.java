package edu.ewubd.food_ordering_mobileapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText useridTF,passwordTF;

    Database g = new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SQLiteDatabase db = g.getReadableDatabase();

        useridTF = findViewById(R.id.etUserId);
        passwordTF = findViewById(R.id.etPassword);



        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userID = useridTF.getText().toString();
                String password = passwordTF.getText().toString();

                if(userID.isEmpty()){
                    //errormsg += "Please enter the user id";
                    Toast.makeText(LoginActivity.this,"Enter the user id",Toast.LENGTH_SHORT).show();
                }
                else if(userID.length() < 4){
                    Toast.makeText(LoginActivity.this,"User id is too short",Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty()){
                    //errormsg += "Please enter the password";
                    Toast.makeText(LoginActivity.this,"Enter the Password",Toast.LENGTH_SHORT).show();
                }
                else if(password.length() <6){
                    //errormsg += "Please enter the password";
                    Toast.makeText(LoginActivity.this,"Password is too short",Toast.LENGTH_SHORT).show();
                }else{

                    Boolean flag = g.check_login(userID,password);
                    if(flag==true){
                        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                        i.putExtra("userid",userID);
                        startActivity(i);
                        finish();

                    }else{
                        Toast.makeText(LoginActivity.this,"Invalid User ID or Password",Toast.LENGTH_SHORT).show();

                    }

                }

            }

        });




    }


}
