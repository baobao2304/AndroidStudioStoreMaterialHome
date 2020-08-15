package com.example.appxaydungproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appxaydungproject.Adapter.RecycleViewAdapterItemGioHang;
import com.example.appxaydungproject.Adapter.RecycleViewAdapterProduct;
import com.example.appxaydungproject.Model.ItemGioHang;
import com.example.appxaydungproject.Model.ProductModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivityGioHang extends AppCompatActivity {
    private ImageView imgClose;
    private LinearLayout lnGioHangChuaMua;
    public static LinearLayout lnTinhTien;
    private Button btnDatHang;
    public static  TextView txtThanhTien;
    public static int checkMua = 0 ;
    public static int checkHang = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gio_hang);
        anhXa();
        if(checkMua == 0 ){
            lnGioHangChuaMua.setVisibility(View.VISIBLE);
        }
        if(checkMua == 1){
            lnGioHangChuaMua.setVisibility(View.GONE);

        }
        setUpSystem();
    }
    private void anhXa(){
        imgClose = (ImageView) findViewById(R.id.imgClose);
        lnGioHangChuaMua =  (LinearLayout) findViewById(R.id.lnGioHangChuaMua);
        lnTinhTien=  (LinearLayout) findViewById(R.id.lnTinhTien);
        btnDatHang = (Button) findViewById(R.id.btnDatHang);
        txtThanhTien = (TextView) findViewById(R.id.txtThanhTien);
    }
    private void setUpHandleEvent(){
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityGioHang.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDatHang();

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivityGioHang.this,"chandle1" )
                        .setSmallIcon(R.drawable.ic_baseline_message_24)
                        .setContentTitle("Bạn Đã Đặt Hàng Thành Công")
                        .setContentText("Xin chờ xác nhận hóa đơn")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivityGioHang.this);

// notificationId is a unique int for each notification that you must define
                notificationManager.notify(Integer.parseInt("1"), mBuilder.build());
            }
        });
    }
    private void setUpSystem(){
        rcvItemGioHAng();
        setUpHandleEvent();
        if(checkHang == 0)
            lnTinhTien.setVisibility(View.GONE);
    }
    public static List<ItemGioHang> lsItemGioHangProduct = new ArrayList<>();
    public static RecycleViewAdapterItemGioHang recycleViewAdapterItemGioHang;
    private void rcvItemGioHAng(){

         RecyclerView myRecyclerViewPR;



        myRecyclerViewPR = (RecyclerView) findViewById(R.id.rcv_itemGioHang);
        recycleViewAdapterItemGioHang = new RecycleViewAdapterItemGioHang(this,lsItemGioHangProduct);
        myRecyclerViewPR.setLayoutManager(new LinearLayoutManager(this));

        myRecyclerViewPR.setHasFixedSize(true);
        myRecyclerViewPR.setAdapter(recycleViewAdapterItemGioHang);
    }
    private void dialogDatHang(){
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
//Thiết lập tiêu đề
        b.setTitle("Thông Báo");

        b.setMessage("Bạn co chac se dat hang");
// Nút Ok
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
//Nút Cancel
        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
//Tạo dialog
        AlertDialog al = b.create();
//Hiển thị
        al.show();
    }

}