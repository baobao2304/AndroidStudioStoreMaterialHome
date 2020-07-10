package com.example.appxaydungproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class MainActivityGioHang extends AppCompatActivity {
    private ImageView imgClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gio_hang);
        anhXa();
        setUpSystem();
    }
    private void anhXa(){
        imgClose = (ImageView) findViewById(R.id.imgClose);
    }
    private void setUpHandleEvent(){
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityGioHang.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
    private void setUpSystem(){
        setUpHandleEvent();
    }
}