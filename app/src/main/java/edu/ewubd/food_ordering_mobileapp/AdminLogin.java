package edu.ewubd.food_ordering_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText userTF,passwordTF;
    Database g = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        userTF = findViewById(R.id.etUserId);
        passwordTF = findViewById(R.id.etPassword);


        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userID = userTF.getText().toString();
                String password = passwordTF.getText().toString();

                if(userID.isEmpty()){
                    //errormsg += "Please enter the user id";
                    Toast.makeText(AdminLogin.this,"Enter the user id",Toast.LENGTH_SHORT).show();
                }
                else if(userID.length() < 4){
                    Toast.makeText(AdminLogin.this,"User id is too short",Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty()){
                    //errormsg += "Please enter the password";
                    Toast.makeText(AdminLogin.this,"Enter the Password",Toast.LENGTH_SHORT).show();
                }
                else if(password.length() <4){
                    //errormsg += "Please enter the password";
                    Toast.makeText(AdminLogin.this,"Password is too short",Toast.LENGTH_SHORT).show();
                }else{

                    if(userID.matches("1111") && password.matches("1111")){
                        Intent i = new Intent(AdminLogin.this,addFoodItem.class);
                        startActivity(i);
                        finish();

                    }else{
                        Toast.makeText(AdminLogin.this,"Invalid userID or Password",Toast.LENGTH_SHORT).show();

                    }

                }

            }

        });




    }
}