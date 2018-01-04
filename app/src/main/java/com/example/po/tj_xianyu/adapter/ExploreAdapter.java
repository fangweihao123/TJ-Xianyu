package com.example.po.tj_xianyu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.po.tj_xianyu.R;
import com.example.po.tj_xianyu.gson.Item;
import com.example.po.tj_xianyu.service.photoservice.PhotoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13701 on 2017/12/28.
 */

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ItemHolder>{
    private ArrayList<Item> itemsList;
    private Context context;

    public ExploreAdapter(ArrayList<Item> _itemsList,Context _context){
        itemsList = _itemsList;
        context = _context;
    }

    static class ItemHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView item_photo;
        TextView item_name;
        TextView item_desc;
        TextView item_price;
        public ItemHolder(final View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            item_photo = itemView.findViewById(R.id.item_photo);
            item_name = itemView.findViewById(R.id.item_name);
            item_desc = itemView.findViewById(R.id.item_desc);
            item_price = itemView.findViewById(R.id.item_price);
        }
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.object_item,parent,false);
        ItemHolder itemHolder = new ItemHolder(v);
        return  itemHolder;
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, int position) {
        //super.onBindViewHolder(holder, position, payloads);
        //Bitmap bit = PhotoService.convertStringToIcon(itemsList.get(position).getBitMapString());
        holder.item_name.setText(itemsList.get(position).getItemName());
        holder.item_desc.setText(itemsList.get(position).getDescription());
        holder.item_price.setText("价格" + Integer.toString(itemsList.get(position).getPrice()));
        Glide.with(context).load(R.drawable.google_assistant).centerCrop().into(holder.item_photo);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"start cardview",Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
