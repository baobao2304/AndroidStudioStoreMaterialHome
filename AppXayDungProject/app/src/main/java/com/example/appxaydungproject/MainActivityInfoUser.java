package com.example.appxaydungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivityInfoUser extends AppCompatActivity {
    private ImageView backArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info_user);
        AnhXa();
        HandleSystem();
    }
    private  void AnhXa(){
        backArrow = (ImageView) findViewById(R.id.backArrow);
    }
    private  void HandleSystem(){
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(5);
                Intent intent = new Intent(MainActivityInfoUser.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}