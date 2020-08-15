package com.example.appxaydungproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.appxaydungproject.ModuleHandle.LoadingImage;
import com.example.appxaydungproject.Retrofit.RetrofitClient;
import com.example.appxaydungproject.TabMenu.BlankFragmentCaNhan;
import com.example.appxaydungproject.TabMenu.BlankFragmentDanhMuc;
import com.example.appxaydungproject.TabMenu.BlankFragmentHome;
import com.example.appxaydungproject.TabMenu.BlankFragmentTimKiem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView bgapp;
    private LinearLayout lnSearch;
    private Animation fromBottonTop;
    public static  TextView txtview;
    private Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RetrofitClient.handleAPI2();
        setContentView(R.layout.activity_main);
        anhXa();
        setUpSystem();


    }
    private void anhXa(){
        bgapp = (ImageView) findViewById(R.id.imgviewIntro);
         txtview = (TextView) findViewById(R.id.txtview);
//        txtview.setVisibility(View.GONE);
//        bgapp.setVisibility(View.INVISIBLE);
        lnSearch = (LinearLayout) findViewById(R.id.lnSearch);
        fromBottonTop =  AnimationUtils.loadAnimation(this,R.anim.anim_upafterdown);
        btnClick = (Button) findViewById(R.id.btnClick);
//        LoadingImage loadingImage = new LoadingImage(bgapp);
//        loadingImage.execute("http://10.99.33.143:800/img_ds/product-48.jpg");

        Glide.with(this).load("http://192.168.1.8:800/img_ds/product-48.jpg").into(bgapp);
    }
    private void setUpSystem(){
        // set up anim
//                bgapp.startAnimation(bganim);
        bgapp.animate().translationY(-1500).setDuration(800).setStartDelay(500);
        lnSearch.startAnimation(fromBottonTop);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient a = new RetrofitClient();
                a.sendPostLogin("admin","123456789");
            }
        });
    }
//        animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.myanim);
//
//        mVideoView = (VideoView) findViewById(R.id.videoView);


//        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw._videointro);
//
//        mVideoView.setVideoURI(uri);
//        mVideoView.start();
//        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//            }
//        });
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
////                startActivity(intent);
////                finish();
//            }
//        },10000);




}