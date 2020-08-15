package com.example.appxaydungproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appxaydungproject.Adapter.RCVAdapterDetailImgPr;
import com.example.appxaydungproject.Adapter.RecycleViewAdapterProduct;
import com.example.appxaydungproject.Model.ImageDetailProduct;
import com.example.appxaydungproject.Model.ItemGioHang;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.ModuleHandle.LoadingImage;
import com.example.appxaydungproject.PagerLogin.BlankFragmentLogin;
import com.example.appxaydungproject.Retrofit.RetrofitClient;
import com.example.appxaydungproject.SettingAll.SettingAll;
import com.example.appxaydungproject.TabMenu.BlankFragmentCaNhan;

import java.util.ArrayList;
import java.util.List;

public class MainActivityDetailProduct extends AppCompatActivity {
    // product big first in  activity product detail
    public static String imgProductMain;
    public static ImageView imgDetailPR;
    private TextView txtPriceDetailPR,txtNamePr,txtAddress;
    private Button btnChonMua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail_product);

        anhXa();
        setUpSystem();
        LoadingImage loadingImage = new LoadingImage(imgDetailPR);
        loadingImage.execute(SettingAll.Base_Url +RecycleViewAdapterProduct.productModel.getImgPR());
    }
    ImageView imgbackPage,imgsearchPage,imghomePage,imgstorePage;
    private void anhXa(){
        imgbackPage = (ImageView) findViewById(R.id.imgbackPage);
        imgsearchPage = (ImageView) findViewById(R.id.imgsearchPage);
        imghomePage = (ImageView) findViewById(R.id.imghomePage);
        imgstorePage = (ImageView) findViewById(R.id.imgstorePage);
        imgDetailPR = (ImageView) findViewById(R.id.imgDetailPR);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtPriceDetailPR = (TextView) findViewById(R.id.txtPriceDetailPR);
        txtNamePr = (TextView) findViewById(R.id.txtNamePr);

        btnChonMua = (Button) findViewById(R.id.btnChonMua);
        if(SettingAll.checkDNDX == 0)
            txtAddress.setText("");
        if(SettingAll.checkDNDX == 1){
            txtAddress.setText(SettingAll.userModel.getAddress());
        }
    }
    private void setUpHandleEvent(){
        imgbackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityDetailProduct.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        imgsearchPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityDetailProduct.this,MainActivitySearch.class);
                startActivity(intent);
            }
        });
        imghomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityDetailProduct.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        imgstorePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityDetailProduct.this,MainActivityGioHang.class);
                startActivity(intent);
            }
        });

        btnChonMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SettingAll.checkDNDX == 0){
                    dialogChonMua();
                }
                else{
                    MainActivityGioHang.checkMua = 1;
                    MainActivityGioHang.checkHang++;
                    MainActivityGioHang.lsItemGioHangProduct.add(new ItemGioHang(txtNamePr.getText().toString(),"1",String.valueOf(RecycleViewAdapterProduct.productModel.getPricePR()),"khong co"));

                    Intent intent = new Intent(MainActivityDetailProduct.this,MainActivityGioHang.class);
                    startActivity(intent);
                }

            }
        });
    }
    private void setUpSystem(){
        setUpHandleEvent();
        recycleViewHandle();

//        imgDetailPR.setBackground();
        txtNamePr.setText(RecycleViewAdapterProduct.productModel.getNamePR());
        txtPriceDetailPR.setText(String.valueOf(RecycleViewAdapterProduct.productModel.getPricePR()) + " VND");
    }
    public static RecyclerView myRecyclerViewPR;
    public static RCVAdapterDetailImgPr reRcvAdapterDetailImgPr;
    private void recycleViewHandle(){

        myRecyclerViewPR = (RecyclerView) findViewById(R.id.rcv_IMGProductDetail);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewPR.setLayoutManager(layoutManager);

//        List<ImageDetailProduct> lsItemIMGDetailProduct = new ArrayList<ImageDetailProduct>() ;
        RetrofitClient.getDataImageProduct(MainActivityDetailProduct.this);

        //////////////////////////////////
        //////////////////////////////////

    }

    private void dialogChonMua(){
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(this);
//Thiết lập tiêu đề
        b.setTitle("Thông Báo");
        b.setMessage("Bạn Chưa Đăng Nhập");
// Nút Ok
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
//Nút Cancel
//        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                dialog.cancel();
//            }
//        });
//Tạo dialog
        AlertDialog al = b.create();
//Hiển thị
        al.show();
    }


}