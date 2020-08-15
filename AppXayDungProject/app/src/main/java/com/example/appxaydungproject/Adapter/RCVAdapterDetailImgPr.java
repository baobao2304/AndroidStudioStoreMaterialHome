package com.example.appxaydungproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.example.appxaydungproject.Interface.ItemClickImgPrDetail;
import com.example.appxaydungproject.Interface.ItemClickProductListener;
import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.MainActivityDetailProduct;
import com.example.appxaydungproject.Model.ImageDetailProduct;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.ModuleHandle.LoadingImage;
import com.example.appxaydungproject.ModuleHandle.LoadingImageBitmap;
import com.example.appxaydungproject.R;
import com.example.appxaydungproject.SettingAll.SettingAll;

import java.util.List;



public class RCVAdapterDetailImgPr extends RecyclerView.Adapter<RCVAdapterDetailImgPr.MyViewHolder>{
    Context mContext;
    public static int id;
    List<ImageDetailProduct> mData;


    public RCVAdapterDetailImgPr(Context mContext, List<ImageDetailProduct> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_imageoproduct,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return new MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgProduct.setScaleType(ImageView.ScaleType.FIT_XY);

//        LoadingImage loadingImage = new LoadingImage(holder.imgProduct);
//        loadingImage.execute(SettingAll.Base_Url+mData.get(position).getPath());

        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(mContext);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

        Glide.with(mContext)
                .load(SettingAll.Base_Url+mData.get(position).getPath())
                .centerCrop()
                .placeholder(circularProgressDrawable)
                .into(holder.imgProduct);
        holder.setItemClickListener(new ItemClickImgPrDetail() {
            @Override
            public void onClick(View view, int position) {
                id = position;
//                MainActivityDetailProduct.imgProductMain = mData.get(position);
//                LoadingImage loadingImage = new LoadingImage(MainActivityDetailProduct.imgDetailPR);
//                loadingImage.execute(SettingAll.Base_Url +mData.get(position).getPath());
                Glide.with(mContext).load(SettingAll.Base_Url+mData.get(position).getPath()).into(MainActivityDetailProduct.imgDetailPR);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgProduct;
        private ItemClickImgPrDetail itemClickListener;
        public MyViewHolder (View itemView, ItemClickProductListener onNoteListener){
            super(itemView);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);

            itemView.setOnClickListener(this);
        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickImgPrDetail itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}