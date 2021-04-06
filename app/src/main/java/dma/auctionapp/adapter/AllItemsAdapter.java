package com.dma.auctionapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class AllItemsAdapter extends RecyclerView.Adapter<AllItemsAdapter.AllItemsViewHolder> {

    Context context;
    List<AllItems> allItemsList;

    public AllItemsAdapter(Context context, List<AllItems> allItemsList) {
        this.context = context;
        this.allItemsList = allItemsList;
    }

    @NonNull
    @Override
    public AllItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allItems_recycler_items, parent, false);

        return new AllItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllItemsViewHolder holder, final int position) {

        holder.allItemsName.setText(allItemsList.get(position).getName());
        holder.allItemsPrice.setText("₹ "+allItemsList.get(position).getPrice());
        holder.allItemsTime.setText(allItemsList.get(position).getDeliveryTime());
        holder.allItemsRating.setText(allItemsList.get(position).getRating());
        holder.allItemsCharges.setText(allItemsList.get(position).getDeliveryCharges());
        holder.allItemsNote.setText(allItemsList.get(position).getNote());

        Glide.with(context).load(allItemsList.get(position).getImageUrl()).into(holder.allItemsImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FoodDetails.class);
                i.putExtra("name", allItemsList.get(position).getName());
                i.putExtra("price", allItemsList.get(position).getPrice());
                i.putExtra("rating", allItemsList.get(position).getRating());
                i.putExtra("image", allItemsList.get(position).getImageUrl());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return allItemsList.size();
    }

    public static class AllItemsViewHolder extends RecyclerView.ViewHolder{

        TextView allItemsName, allItemsNote, allItemsRating, allItemsTime, allItemsCharges, allItemsPrice;
        ImageView allItemsImage;

        public AllItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            allItemsName = itemView.findViewById(R.id.all_Items_name);
            allItemsNote = itemView.findViewById(R.id.all_Items_note);
            allItemsCharges = itemView.findViewById(R.id.all_Items_delivery_charge);
            allItemsRating = itemView.findViewById(R.id.all_Items_rating);
            allItemsTime = itemView.findViewById(R.id.all_Items_deliverytime);
            allItemsPrice = itemView.findViewById(R.id.all_Items_price);
            allItemsImage = itemView.findViewById(R.id.all_Items_image);
        }
    }

}
