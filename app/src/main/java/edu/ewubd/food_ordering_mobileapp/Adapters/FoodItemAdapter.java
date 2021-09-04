package edu.ewubd.food_ordering_mobileapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.ewubd.food_ordering_mobileapp.Models.FoodItem;
import edu.ewubd.food_ordering_mobileapp.R;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.viewholder> {

    ArrayList<FoodItem> list;
    Context context;

    public FoodItemAdapter(ArrayList<FoodItem> list, Context context) {
        this.list = list;
        this.context = context;
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
}
