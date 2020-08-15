package com.example.appxaydungproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appxaydungproject.Interface.ItemClickGioHangListener;
import com.example.appxaydungproject.Interface.ItemClickProductListener;
import com.example.appxaydungproject.MainActivityDetailProduct;
import com.example.appxaydungproject.MainActivityGioHang;
import com.example.appxaydungproject.Model.ItemGioHang;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.R;

import java.util.List;

public class RecycleViewAdapterItemGioHang extends RecyclerView.Adapter<RecycleViewAdapterItemGioHang.MyViewHolder>{
    Context mContext;
    public static int id;

    List<ItemGioHang> mData;
    private ItemClickGioHangListener onNotListener;
    public static ProductModel productModel;
    public RecycleViewAdapterItemGioHang(Context mContext, List<ItemGioHang> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_gio_hang,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return new MyViewHolder(v);


    }
public static float tien;
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        tien = Float.parseFloat(mData.get(position).getPriceProduct());
        holder.tv_NameSP.setText(mData.get(position).getNameProduct());
        holder.tv_SoLuong.setText(mData.get(position).getSoLuong());
        holder.tv_GiaSP.setText(mData.get(position).getPriceProduct()+" VND");
        holder.btn_Tang.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                tien = Float.parseFloat(mData.get(position).getPriceProduct());
                holder.tv_SoLuong.setText(String.valueOf((Integer.parseInt(mData.get(position).getSoLuong())+1)));
                mData.get(position).setSoLuong(String.valueOf((Integer.parseInt(mData.get(position).getSoLuong())+1)));
                MainActivityGioHang.recycleViewAdapterItemGioHang.notifyDataSetChanged();
                tien = tien * Integer.parseInt(mData.get(position).getSoLuong());
            }
        });
        holder.btn_Giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tien = Float.parseFloat(mData.get(position).getPriceProduct());
                int sl = Integer.parseInt(mData.get(position).getSoLuong());
                if(Integer.parseInt(mData.get(position).getSoLuong()) <= 0 ){
                    holder.tv_SoLuong.setText("0");
                    tien = 0;
                }
                if(Integer.parseInt(mData.get(position).getSoLuong()) > 0 ){

                    holder.tv_SoLuong.setText(String.valueOf(sl-1));
                    mData.get(position).setSoLuong(String.valueOf(sl-1));

                    tien *= Integer.parseInt(mData.get(position).getSoLuong());

                }
                MainActivityGioHang.recycleViewAdapterItemGioHang.notifyDataSetChanged();
            }
        });
        holder.tv_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityGioHang.checkHang--;
                if(MainActivityGioHang.checkHang == 0)
                    MainActivityGioHang.lnTinhTien.setVisibility(View.GONE);

                MainActivityGioHang.lsItemGioHangProduct.remove(position);
                MainActivityGioHang.recycleViewAdapterItemGioHang.notifyDataSetChanged();
            }
        });

        float tongtienhienco = Float.parseFloat( MainActivityGioHang.txtThanhTien.getText().toString());
        float tongtien = tongtienhienco+tien;
        MainActivityGioHang.txtThanhTien.setText(String.valueOf(tongtien) );
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_NameSP,tv_GiaSP,tv_SoLuong,tv_Xoa;
        private ImageView imgProduct;
        private Button btn_Tang,btn_Giam;
        private ItemClickGioHangListener itemClickListener;
        public MyViewHolder (View itemView, ItemClickGioHangListener onNoteListener){
            super(itemView);
            tv_NameSP = (TextView) itemView.findViewById(R.id.txtTenSP);
            tv_GiaSP = (TextView) itemView.findViewById(R.id.txtGia);
            tv_SoLuong = (TextView) itemView.findViewById(R.id.txtSoluong);
            tv_Xoa = (TextView) itemView.findViewById(R.id.txtXoa);
            btn_Tang = (Button) itemView.findViewById(R.id.btnTang);
            btn_Giam = (Button) itemView.findViewById(R.id.btnGiam);
//            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
//            mOnNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NameSP = (TextView) itemView.findViewById(R.id.txtTenSP);
            tv_GiaSP = (TextView) itemView.findViewById(R.id.txtGia);
            tv_SoLuong = (TextView) itemView.findViewById(R.id.txtSoluong);
            btn_Tang = (Button) itemView.findViewById(R.id.btnTang);
            btn_Giam = (Button) itemView.findViewById(R.id.btnGiam);
            tv_Xoa = (TextView) itemView.findViewById(R.id.txtXoa);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickGioHangListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
