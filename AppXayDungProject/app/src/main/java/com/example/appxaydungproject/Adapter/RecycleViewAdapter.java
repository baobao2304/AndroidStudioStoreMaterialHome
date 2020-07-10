package com.example.appxaydungproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appxaydungproject.Interface.ItemClickListener;
import com.example.appxaydungproject.Model.ItemSearch;
import com.example.appxaydungproject.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    Context mContext;
    List<ItemSearch> mData;
    public static int id;
    public RecycleViewAdapter(Context mContext, List<ItemSearch> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_history_search,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_Title.setText(mData.get(position).getItemsearch());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                id = position;
                Toast.makeText(mContext,"click 1 "+position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_Title;
        private ItemSearch itemSearch;
        private ItemClickListener   itemClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Title = (TextView) itemView.findViewById(R.id.tv_Search);
            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
        public void bind(ItemSearch itemSearch) {

        }
    }
}
