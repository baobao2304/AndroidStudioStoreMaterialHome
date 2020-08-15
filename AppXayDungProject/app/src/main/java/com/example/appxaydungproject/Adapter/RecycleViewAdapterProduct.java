package com.example.appxaydungproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.example.appxaydungproject.Interface.ItemClickProductListener;
import com.example.appxaydungproject.MainActivityDetailProduct;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.ModuleHandle.LoadingImage;
import com.example.appxaydungproject.R;
import com.example.appxaydungproject.Retrofit.RetrofitClient;
import com.example.appxaydungproject.SettingAll.SettingAll;

import java.util.List;

public class RecycleViewAdapterProduct extends RecyclerView.Adapter<RecycleViewAdapterProduct.MyViewHolder>{
    Context mContext;
    public static int id;

    List<ProductModel> mData;
    private  ItemClickProductListener onNotListener;
    public static ProductModel productModel;
    public RecycleViewAdapterProduct(Context mContext, List<ProductModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_product,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return new MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_NamePR.setText(mData.get(position).getNamePR());
        holder.tv_Description.setText(mData.get(position).getDescriptionPR());
        holder.imgProduct.setImageResource(mData.get(position).getImagePR());

//        LoadingImage loadingImage = new LoadingImage(holder.imgProduct);
//        loadingImage.execute(SettingAll.Base_Url+mData.get(position).getImgPR());

        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(mContext);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();


        Glide.with(mContext)
                .load(SettingAll.Base_Url+mData.get(position).getImgPR())
                .centerCrop()
                .placeholder(circularProgressDrawable)
                .into(holder.imgProduct);

//        Glide.with(mContext).load(SettingAll.Base_Url+mData.get(position).getImgPR()).into(holder.imgProduct);

//        Glide.with(mContext)
//                .load(SettingAll.Base_Url+mData.get(position).getImgPR())
//                .override(200,300)
//                .into(holder.imgProduct);


        holder.setItemClickListener(new ItemClickProductListener() {
            @Override
            public void onClick(View view, int position) {
                id = position;
                productModel = mData.get(position);
                Toast.makeText(mContext,"click 1 "+position, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(view.getContext(), MainActivityDetailProduct.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_Description,tv_NamePR;
        private ImageView imgProduct;
        private ProductModel productModel;
        private ItemClickProductListener itemClickListener;
        public MyViewHolder (View itemView, ItemClickProductListener onNoteListener){
            super(itemView);
            tv_Description = (TextView) itemView.findViewById(R.id.textDescription);
            tv_NamePR = (TextView) itemView.findViewById(R.id.textNamePR);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
//            mOnNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Description = (TextView) itemView.findViewById(R.id.textDescription);
            tv_NamePR = (TextView) itemView.findViewById(R.id.textNamePR);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickProductListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
