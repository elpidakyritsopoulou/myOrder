package com.example.myorder.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.myorder.Model.Food;
import com.example.myorder.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private final OnFoodListener mOnFoodListener;
    ArrayList<Food> list;
    Context context;

    public FoodAdapter(Context context, ArrayList<Food> mList, OnFoodListener onFoodListener) {
        this.list = mList;
        this.context = context;
        this.mOnFoodListener = onFoodListener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items_food, parent, false);
        return new FoodViewHolder(v, mOnFoodListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = list.get(position);
        holder.item_name.setText(food.getName());
        holder.item_price.setText(food.getPrice() + " \u20ac");
        Picasso.get().load(food.getImage())
                .into(holder.item_image);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnFoodListener {
        void onFoodClick(int position);
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView item_name;
        TextView item_price;
        ImageView item_image;
        ElegantNumberButton elegantNumberButton;
        Button add1;
        OnFoodListener onFoodListener;

        public FoodViewHolder(View itemView, OnFoodListener onFoodListener) {
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            item_image = itemView.findViewById(R.id.item_image);
            elegantNumberButton = itemView.findViewById(R.id.btn_quantity);
            add1 = itemView.findViewById(R.id.add1);

            this.onFoodListener = onFoodListener;

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            onFoodListener.onFoodClick(getAdapterPosition());
        }
    }


}
