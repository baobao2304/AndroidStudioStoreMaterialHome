package com.example.appxaydungproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.example.appxaydungproject.Interface.ItemClickListener;
import com.example.appxaydungproject.Model.TypeProductModel;
import com.example.appxaydungproject.R;
import com.example.appxaydungproject.Retrofit.RetrofitClient;
import com.example.appxaydungproject.SettingAll.SettingAll;
import com.example.appxaydungproject.TabMenu.BlankFragmentDanhMuc;

import java.util.List;

public class RecycleViewAdapterTypeProduct extends RecyclerView.Adapter<RecycleViewAdapterTypeProduct.MyViewHolder>{
    Context mContext;
    public static int id;
    List<TypeProductModel> mData;

    public RecycleViewAdapterTypeProduct(Context mContext, List<TypeProductModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecycleViewAdapterTypeProduct.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_type_pr,parent,false);
        RecycleViewAdapterProduct.MyViewHolder vHolder = new RecycleViewAdapterProduct.MyViewHolder(v);
        return new RecycleViewAdapterTypeProduct.MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterTypeProduct.MyViewHolder holder, int position) {
        holder.tv_NameTypePR.setText(mData.get(position).getTypeNamePr());
//        holder.imgTypeProduct.setImageResource(mData.get(position).getImgTypeNamePr());

        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(mContext);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();


        Glide.with(mContext)
                .load(SettingAll.Base_Url+mData.get(position).getImgTypeNamePr())
                .centerCrop()
                .placeholder(circularProgressDrawable)
                .into(holder.imgTypeProduct);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                id = position;
                Toast.makeText(mContext,"click 1 "+position, Toast.LENGTH_LONG).show();
                RetrofitClient.getDataProductOfType(mData.get(position).getId());
                BlankFragmentDanhMuc.recycleViewAdapterProduct = new RecycleViewAdapterProduct(view.getContext(),SettingAll.lsProductOfTypeProduct);
                BlankFragmentDanhMuc.rcv_Product_PageType.setLayoutManager(new GridLayoutManager(view.getContext(),3));

                BlankFragmentDanhMuc.rcv_Product_PageType.setHasFixedSize(true);
                BlankFragmentDanhMuc.rcv_Product_PageType.setAdapter(BlankFragmentDanhMuc.recycleViewAdapterProduct);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_NameTypePR;
        private ImageView imgTypeProduct;
        private TypeProductModel typeproductModel;
        private ItemClickListener itemClickListener;
//        public MyViewHolder (View itemView, RecycleViewAdapterProduct.ItemClickListener onNoteListener){
//            super(itemView);
//            tv_NameTypePR = (TextView) itemView.findViewById(R.id.txtTypeNamePR);
//            imgTypeProduct = (ImageView) itemView.findViewById(R.id.imgTypePR);
//            itemView.setOnClickListener(this);
//        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NameTypePR = (TextView) itemView.findViewById(R.id.txtTypeNamePR);
            imgTypeProduct = (ImageView) itemView.findViewById(R.id.imgTypePR);
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
    }
}
