package com.example.appxaydungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivityDetailProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail_product);
        anhXa();
        setUpSystem();
    }
    ImageView imgbackPage;
    private void anhXa(){
        imgbackPage = (ImageView) findViewById(R.id.imgbackPage);
    }
    private void setUpHandleEvent(){
        imgbackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityDetailProduct.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
    private void setUpSystem(){
        setUpHandleEvent();
    }

}