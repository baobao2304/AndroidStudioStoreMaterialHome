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
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.Model.TypeProductModel;
import com.example.appxaydungproject.R;

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
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_iten_type_pr,parent,false);
        RecycleViewAdapterProduct.MyViewHolder vHolder = new RecycleViewAdapterProduct.MyViewHolder(v);
        return new RecycleViewAdapterTypeProduct.MyViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterTypeProduct.MyViewHolder holder, int position) {
        holder.tv_NameTypePR.setText(mData.get(position).getTypeNamePr());
        holder.imgTypeProduct.setImageResource(mData.get(position).getImgTypeNamePr());

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
