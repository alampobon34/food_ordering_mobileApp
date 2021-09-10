package edu.ewubd.food_ordering_mobileapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.ewubd.food_ordering_mobileapp.CartActivity;
import edu.ewubd.food_ordering_mobileapp.Database;
import edu.ewubd.food_ordering_mobileapp.HomeActivity;
import edu.ewubd.food_ordering_mobileapp.LoginActivity;
import edu.ewubd.food_ordering_mobileapp.Models.FoodItem;
import edu.ewubd.food_ordering_mobileapp.R;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.viewholder> {

    ArrayList<FoodItem> list;
    Context context;

    String userid ;



    public FoodItemAdapter(ArrayList<FoodItem> list, Context context,String id) {
        this.list = list;
        this.context = context;
        this.userid = id;

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_fooditem,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final FoodItem item = list.get(position);
        holder.image.setImageResource(item.getImage());
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        holder.description.setText(item.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String total = String.valueOf(Integer.valueOf(item.getPrice()) * 1);

                Intent i = new Intent(context,CartActivity.class);
                i.putExtra("user_id",getUserid());
                i.putExtra("item_name",item.getName());
                i.putExtra("price",item.getPrice());
                i.putExtra("description",item.getDescription());
                i.putExtra("image",item.getImage());
                i.putExtra("quantity","1");
                i.putExtra("total",total);
                context.startActivity(i);

            }

        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class viewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,price,description;


        public viewholder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.imageView);


        }

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
