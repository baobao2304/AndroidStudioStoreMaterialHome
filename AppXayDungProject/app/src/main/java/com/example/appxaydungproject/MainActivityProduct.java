package com.example.appxaydungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivityProduct extends AppCompatActivity {
    private ImageView imgBackArrow,imgStore;
    private RelativeLayout rlSearchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product);
        anhXa();
        handleClickEvent();
    }
    private void anhXa(){
        imgBackArrow = (ImageView) findViewById(R.id.imgbackPagePR);
        imgStore = (ImageView) findViewById(R.id.imgStore);
        rlSearchBar = (RelativeLayout) findViewById(R.id.rlSearchBar);
    }
    private void handleClickEvent(){
        imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
        imgStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivityGioHang.class);
                startActivity(intent);
            }
        });
        rlSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivitySearch.class);
                startActivity(intent);
            }
        });
    }
}