package edu.ewubd.food_ordering_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    Button buttonPlaceOrder;
    EditText etNameTF,etPhoneTF,etAddressTF;
    TextView tvItemName,tvTotalQuantity,tvTotalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Database g = new Database(this);
        //SQLiteDatabase db = g.getReadableDatabase();


        etNameTF = findViewById(R.id.etName);
        etPhoneTF = findViewById(R.id.etPhone);
        etAddressTF = findViewById(R.id.etAddress);



        Intent i = getIntent();
        String user_id = i.getStringExtra("user_id");
        String item_name = i.getStringExtra("item_name");
        String quantity = i.getStringExtra("quantity");
        String total_price = i.getStringExtra("total_price");


        tvItemName = findViewById(R.id.tvItemName);
        tvItemName.setText(item_name);

        tvTotalQuantity = findViewById(R.id.tvTotalQuantity);
        tvTotalQuantity.setText(quantity);

        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        tvTotalPrice.setText(total_price);


        //System.out.println("Count"+quantity);
        //System.out.println("total"+total_price);
        //System.out.println("userID"+user_id);

        buttonPlaceOrder = (Button)findViewById(R.id.buttonPlaceOrder);
        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database g = new Database(CheckoutActivity.this);
                SQLiteDatabase db = g.getReadableDatabase();

                Intent i = getIntent();
                String user_id = i.getStringExtra("user_id");
                String item_name = i.getStringExtra("item_name");
                String quantity = i.getStringExtra("quantity");
                String total_price = i.getStringExtra("total_price");
                String user_name = etNameTF.getText().toString();
                String phone = etPhoneTF.getText().toString();
                String address = etAddressTF.getText().toString();

                if(user_name.isEmpty()){
                    //errormsg += "Please enter the user id";
                    Toast.makeText(CheckoutActivity.this,"user name can not be empty",Toast.LENGTH_SHORT).show();
                }
                else if(phone.isEmpty()){
                    //errormsg += "Please enter the user id";
                    Toast.makeText(CheckoutActivity.this,"phone number can not be empty",Toast.LENGTH_SHORT).show();
                }
                else if(address.isEmpty()){
                    //errormsg += "Please enter the user id";
                    Toast.makeText(CheckoutActivity.this,"address can not be empty",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean flag = g.order_insert(user_id,user_name,phone,address,item_name,quantity,total_price);

                    if(flag==true){
                        showDialog("Your order has been placed Successfully","Info","Okay",false,user_id);


                    }else{
                        Toast.makeText(CheckoutActivity.this,"Order not placed",Toast.LENGTH_SHORT).show();
                    }
                }


            }

        });
    }


    private void showDialog(String message, String title, String btnLabel, boolean isSuccess,String user_id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        builder.setMessage(message).setTitle(title);

        //Setting message manually and performing action on button click
        builder.setMessage(message)
                .setCancelable(false)
                .setNegativeButton(btnLabel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (isSuccess) {
                            dialog.cancel();
                        } else {
                            //dialog.cancel();
                            Intent i = new Intent(CheckoutActivity.this,HomeActivity.class);
                            i.putExtra("userid",user_id );
                            startActivity(i);
                            finish();
                        }
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
//        alert.setTitle("Error Dialog");
        alert.show();
    }
}