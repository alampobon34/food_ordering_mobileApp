package edu.ewubd.food_ordering_mobileapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

import edu.ewubd.food_ordering_mobileapp.Adapters.MainAdapter;
import edu.ewubd.food_ordering_mobileapp.Models.MainModel;
import edu.ewubd.food_ordering_mobileapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.chicken_burger, "Burger","5","Chicken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.pepp_pizza, "Pizza","10","Beef Pepperoni Pizza"));
        list.add(new MainModel(R.drawable.chick_pizza, "Chicken Pizza","0","Chicken Pizza with Extra Cheese"));
        list.add(new MainModel(R.drawable.cheese_cake, "Cheese Cake","12","Cheese Cake with Blueberry Sauce"));
        list.add(new MainModel(R.drawable.chicken_wings, "Chicken Wings","5","Chicken Wings with Spices"));
        list.add(new MainModel(R.drawable.meat_balls, "Meat Balls","5","Spicy Meat Balls"));
        list.add(new MainModel(R.drawable.choco_cake, "Chocolate Cake","8","Chocolate Cake with Chocolate Frosting"));
        list.add(new MainModel(R.drawable.soft_drinks, "Soft Drinks","5","Pepsi/Sprite"));
        list.add(new MainModel(R.drawable.french_fries, "French Fry","10","French Fry with Spices"));
        list.add(new MainModel(R.drawable.kacchi, "Rice","20","Rice with mutton"));

        MainAdapter adapter = new MainAdapter(list , this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

}
