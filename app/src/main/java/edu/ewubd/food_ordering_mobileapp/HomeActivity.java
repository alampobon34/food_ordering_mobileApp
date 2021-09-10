package edu.ewubd.food_ordering_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import edu.ewubd.food_ordering_mobileapp.Adapters.FoodItemAdapter;
import edu.ewubd.food_ordering_mobileapp.Models.FoodItem;
import edu.ewubd.food_ordering_mobileapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        //Database db = new Database(this);
        ArrayList<FoodItem> list = new ArrayList<>();
        list.add(new FoodItem("Burger","Cheese Burger","150",R.drawable.burger));
        list.add(new FoodItem("Pizza","9 inch Pizza","500",R.drawable.pizza));


        list.add(new FoodItem("Basmati Kacchi","basmati kacchi with borhani","350",R.drawable.basmati));
        list.add(new FoodItem("Chicken Fried","3 pcs chicken fried","270",R.drawable.chicken_fried));
        list.add(new FoodItem("Cake","Cup Cake","100",R.drawable.cake));
        //list.add(new FoodItem("Cake","Cup Cake","100",R.drawable.cake));

        Intent i = getIntent();
        String id = i.getStringExtra("userid");


        FoodItemAdapter adapter = new FoodItemAdapter(list,this,id);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.cart){
            Intent i = new Intent(HomeActivity.this,CartActivity.class);
            startActivity(i);
        }
        else if(id==R.id.orders){
            Intent i = new Intent(HomeActivity.this,orderListActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
