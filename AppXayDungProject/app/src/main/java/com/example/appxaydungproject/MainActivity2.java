package com.example.appxaydungproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.appxaydungproject.Model.ItemSearch;
import com.example.appxaydungproject.TabMenu.BlankFragmentCaNhan;
import com.example.appxaydungproject.TabMenu.BlankFragmentDanhMuc;
import com.example.appxaydungproject.TabMenu.BlankFragmentHome;
import com.example.appxaydungproject.TabMenu.BlankFragmentThongBao;
import com.example.appxaydungproject.TabMenu.BlankFragmentTimKiem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity2 extends AppCompatActivity {
//    Summary
    //  Inherited constants
    private ImageView bgapp;
    private TabLayout.Tab tab;
    private ViewPager viewPager;
    private BlankFragmentHome homeFragment;
    private BlankFragmentDanhMuc danhmucFragment;
    private BlankFragmentTimKiem timkiemFragment;
    private BlankFragmentCaNhan canhanFragment;
    private BlankFragmentThongBao thongbaoFragment;
    private ViewPagerAdapter viewPagerAdapter;
    //    Inherited fields
    public static int changePage = 0;

    public static TabLayout tabLayout;
    public static List<ItemSearch> lsItemSearch;
    //    Public constructors
    //    Protected methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhXa();
        setUpSystem();
        //        chứa ánh xạ id qua  void anhXa()
        //                và sử lý qua setUpSystem();


    }
//    Inherited methods
//Public constructors



    //Public methods
    private void anhXa(){
        bgapp = (ImageView) findViewById(R.id.imgviewIntro);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        Input :bgapp   (ImageView) ,
//              tabLayout(TabLayout),
//              viewPager(ViewPager)
//        Output:  định nghĩa biến hiểu id của layout xml đang dùng
    }
    private void setUpSystem(){

        if(changePage == 0){
            bgapp.animate().translationY(-3000).setDuration(800).setStartDelay(500);
        }
        else{
            bgapp.animate().translationY(-3000).setDuration(0).setStartDelay(0);
        }
//        Input: bgapp (ImageView)
//        Output: bgapp sử dụng được animation kéo từ hiện tại đến vị trí y = -2000 với thời gian 800 và thời gian bắt đầu 500
        setUpViewPager();
    }
    private void setUpViewPager(){
//        Input : homeFragment,
//                danhmucFragment,
//                ,canhanFragment,
//                viewPagerAdapter,
//                lsItemSearch
//        Output :         viewPagerAdapter.addFragment,
//                         tabLayout add viewpager
//                         tabLayout add icon
//                         tablayout add text color,
//                          lsItemSearch add item
        homeFragment = new BlankFragmentHome();
        danhmucFragment = new BlankFragmentDanhMuc();
        timkiemFragment = new BlankFragmentTimKiem();
        canhanFragment = new BlankFragmentCaNhan();
        thongbaoFragment = new BlankFragmentThongBao();

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),4);

        viewPagerAdapter.addFragment(homeFragment, "Home");
        viewPagerAdapter.addFragment(danhmucFragment, "Danh Mục");
        viewPagerAdapter.addFragment(timkiemFragment, "Tìm Kiếm");
        viewPagerAdapter.addFragment(thongbaoFragment, "Thong Bao");
        viewPagerAdapter.addFragment(canhanFragment, "Cá Nhân");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable._mucluc);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_search_24);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_notifications_none_24);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_baseline_person_24);

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        if(changePage == 1){
            changePage = 0;
            TabLayout.Tab tab;
            tab = MainActivity2.tabLayout.getTabAt(changePage);
            tab.select();
        }
        if(changePage == 2){
            changePage = 1;
            TabLayout.Tab tab;
            tab = MainActivity2.tabLayout.getTabAt(changePage);
            tab.select();
        }
        if(changePage == 4){
            changePage = 3;
            TabLayout.Tab tab;
            tab = MainActivity2.tabLayout.getTabAt(changePage);
            tab.select();
        }if(changePage == 5){
            changePage = 4;
            TabLayout.Tab tab;
            tab = MainActivity2.tabLayout.getTabAt(changePage);
            tab.select();
        }


        lsItemSearch = new ArrayList<>() ;
        lsItemSearch.add(new ItemSearch("sfsdfrthfghffggfffghfghgfhhdfghfghs"));
        lsItemSearch.add(new ItemSearch("sfsdfs"));
        lsItemSearch.add(new ItemSearch("sfsdfs"));
        lsItemSearch.add(new ItemSearch("sfsdfs"));
        lsItemSearch.add(new ItemSearch("sfsdfs"));



    }

    public static int getChangePage() {
        return changePage;
    }

    public static void setChangePage(int changePage) {
        MainActivity2.changePage = changePage;
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