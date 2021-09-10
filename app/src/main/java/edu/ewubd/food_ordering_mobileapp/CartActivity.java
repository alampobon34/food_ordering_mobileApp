package edu.ewubd.food_ordering_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

import static java.lang.Integer.parseInt;

public class CartActivity extends AppCompatActivity {

    public static int count=1;
    public static int total_price=0;
    Button buttonCheckout;
    private TextView tvItemName,tvDescription,tvQuantity,tvTotal;

    private ImageView plus,minus;
    CircleImageView item_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent i = getIntent();

        String user_id = i.getStringExtra("user_id");
        String item_name = i.getStringExtra("item_name");
        String price = i.getStringExtra("price");
        String description = i.getStringExtra("description");
        String image = i.getStringExtra("image");
        String quantity = i.getStringExtra("quantity");
        String total = i.getStringExtra("total");
        total_price = Integer.valueOf(total);

        //String total = String.valueOf(parseInt(price)*parseInt(quantity));




        //item_image = findViewById(R.id.item_image);
        //item_image.setImageResource(Integer.parseInt(image));


        tvItemName = findViewById(R.id.tvItemName);
        tvItemName.setText(item_name);

        tvDescription = findViewById(R.id.tvDescription);
        tvDescription.setText(description);

        tvQuantity = findViewById(R.id.tvQuantity);
        tvQuantity.setText(quantity);


        tvTotal = findViewById(R.id.tvTotal);
        tvTotal.setText(Integer.toString(total_price));


        plus = (ImageView)findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  count++;
                  tvQuantity.setText(Integer.toString(count));
                  total_price = Integer.valueOf(price) * count;
                  tvTotal.setText(Integer.toString(total_price));

                  //showDialog("Item added","Info","Okay",true);

              }

        });

        minus = (ImageView)findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count--;
                if(count>=1){
                    tvQuantity.setText(Integer.toString(count));
                    total_price = Integer.valueOf(price) * count;
                    tvTotal.setText(Integer.toString(total_price));

                }else{
                    count=1;
                    tvQuantity.setText(Integer.toString(count));
                    total_price = Integer.valueOf(price) * count;
                    tvTotal.setText(Integer.toString(total_price));

                }

            }

        });

        buttonCheckout = (Button)findViewById(R.id.buttonCheckout);
        buttonCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(CartActivity.this,CheckoutActivity.class);
               //System.out.println("Count"+count);
               //System.out.println("total"+total_price);
               //System.out.println("userID"+user_id);
               i.putExtra("user_id",user_id);
               i.putExtra("item_name",item_name);
               i.putExtra("quantity",String.valueOf(count));
               i.putExtra("total_price",String.valueOf(total_price));
               startActivity(i);



            }
        });
    }



    private void showDialog(String message, String title, String btnLabel, boolean isSuccess) {
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
                            Intent i = new Intent(CartActivity.this,LoginActivity.class);
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

