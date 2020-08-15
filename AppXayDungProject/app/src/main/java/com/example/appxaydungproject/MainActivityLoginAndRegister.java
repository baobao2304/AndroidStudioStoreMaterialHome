package com.example.appxaydungproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appxaydungproject.PagerLogin.BlankFragmentLogin;
import com.example.appxaydungproject.PagerLogin.BlankFragmentRegister;

import java.util.ArrayList;
import java.util.List;

public class MainActivityLoginAndRegister extends AppCompatActivity {
    public static ViewPager viewPager ;

    private BlankFragmentLogin blankFragmentLogin;
    private BlankFragmentRegister blankFragmentRegister;
    public static TextView txtLogin,txtRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_and_register);

        AnhXa();
        Handle();

    }


    private void AnhXa() {
        viewPager = findViewById(R.id.viewPager);

        txtLogin = findViewById(R.id.txtLogin);
        txtRegister = findViewById(R.id.txtRegister);

    }
    private void Handle() {
        HandleEvent();
        HandleViewPager();
    }
    private void HandleViewPager() {
        blankFragmentLogin = new BlankFragmentLogin();
        blankFragmentRegister = new BlankFragmentRegister();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),3);
        viewPagerAdapter.addFragment(blankFragmentLogin, "Login");
        viewPagerAdapter.addFragment(blankFragmentRegister, "Register");
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.findViewWithTag(viewPager.getCurrentItem());
    }
    private void HandleEvent() {


        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if(viewPager.getCurrentItem() == 0){
                    MainActivityLoginAndRegister.txtLogin.setTextColor(Color.WHITE);
                    MainActivityLoginAndRegister.txtRegister.setTextColor(getResources().getColor(R.color.colorWhiteFill));
                }
                else{
                    MainActivityLoginAndRegister.txtRegister.setTextColor(Color.WHITE);
                    MainActivityLoginAndRegister.txtLogin.setTextColor(getResources().getColor(R.color.colorWhiteFill));
                }
            }
        });
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public  ViewPagerAdapter(@NonNull FragmentManager fm , int behavior){
            super(fm, behavior);
        }
        public  void addFragment(Fragment fragment , String title){
            fragments.add(fragment);
            fragmentTitle.add(title);
        }
        @NonNull
        @Override
        public Fragment getItem(int position){
            return  fragments.get(position);
        }

        @Override
        public int getCount(){
            return  fragments.size();
        }

        @NonNull
        @Override
        public CharSequence getPageTitle(int position){
            return  fragmentTitle.get(position);
        }
    }
}