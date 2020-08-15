package com.example.appxaydungproject.TabMenu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.appxaydungproject.Adapter.RecycleViewAdapterProduct;
import com.example.appxaydungproject.Adapter.RecycleViewAdapterTypeProduct;
import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.MainActivityGioHang;
import com.example.appxaydungproject.MainActivityProduct;
import com.example.appxaydungproject.MainActivitySearch;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.Model.TypeProductModel;
import com.example.appxaydungproject.R;
import com.example.appxaydungproject.Retrofit.ApiUntils;
import com.example.appxaydungproject.Retrofit.DataClient;
import com.example.appxaydungproject.Retrofit.RetrofitClient;
import com.example.appxaydungproject.SettingAll.SettingAll;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.tabs.TabLayout;
import com.readystatesoftware.viewbadger.BadgeView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentHome extends Fragment {
    private LinearLayout  lnSearch,ln1,ln2;
    private Animation fromBottonTop1,fromBottonTop2;
    private ImageSlider imageSlider;
    private ImageView searchBar,imgStore;
    private HorizontalScrollView hrzview;
    private GridLayout gridLayout;
    private int checkAnimHome = 0 ;

    private LinearLayout lnMucLuc,lnCaNhan,lnTimKiem,lnThongBao;
    public static  TextView txtXemThem;
    public static RecyclerView myRecyclerViewPR;
    public static RecycleViewAdapterProduct recyclerViewAdapterPR;
    View v;
    private  int[] mImages = new int[]{
        R.drawable._1,R.drawable._2,R.drawable._3
    };
    private  String[] mImagesTitle = new String[]{
            "Image 1 ","Image 2 ","Image 3 "
    };
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentHome newInstance(String param1, String param2) {
        BlankFragmentHome fragment = new BlankFragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v =  inflater.inflate(R.layout.fragment_blank_home, container, false);

        anhXa();
        handleSystem();
        return  v;
    }

    private void anhXa(){
        lnSearch = (LinearLayout) v.findViewById(R.id.lnSearch);
        searchBar = (ImageView) v.findViewById(R.id.searchBar);
        imgStore = (ImageView) v.findViewById(R.id.imgStore);

        txtXemThem = (TextView) v.findViewById(R.id.txtXemThem);

        this.lnMucLuc = (LinearLayout) v.findViewById(R.id.lnMucLuc);
        this.lnCaNhan = (LinearLayout) v.findViewById(R.id.lnCaNhan);
        this.lnThongBao = (LinearLayout) v.findViewById(R.id.lnThongBao);
        this.lnTimKiem = (LinearLayout) v.findViewById(R.id.lnTimKiem);
//        BadgeView badge = new BadgeView(v.getContext(), imgStore);
//        badge.setText("1");
//        badge.show();
//        BadgeView
//          BadgeView d = new BadgeDrawable(v.getContext(),imgStore);
//
//                badgeDrawable = tab.getOrCreateBadge();
//        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorOrange));
//        badgeDrawable.setVisible(true);
//        badgeDrawable.setNumber(5);
//        badgeDrawable.setMaxCharacterCount(3);

        imageSlider = (ImageSlider) v.findViewById(R.id.imageSlider);

//        hrzview = (HorizontalScrollView) v.findViewById(R.id.hrzview);
//        ln2 = (LinearLayout) v.findViewById(R.id.ln2);
//        gridLayout = (GridLayout) v.findViewById(R.id.gridLayout);
    }

    private void handleSystem(){

        handleAnimation();
        handleClickEvent();
        handleImageSlider();
        handleRCVProduct();
//        BadgeDrawable badgeDrawable = v.
//        BadgeUtils.attachBadgeDrawable(badgeDrawable, 5, null);


    }
    public static List<ProductModel> lsItemProduct = new ArrayList<>();
    private void handleRCVProduct(){

        myRecyclerViewPR = (RecyclerView) v.findViewById(R.id.rcvPR);
        RetrofitClient.getDataProduct(v);


        System.out.println("list đã đỗ thành công "+SettingAll.lsProductHome.size());

    }
    private  void handleAnimation(){
        fromBottonTop1 =  AnimationUtils.loadAnimation(v.getContext(),R.anim.anim_upafterdown);
        fromBottonTop2 =  AnimationUtils.loadAnimation(v.getContext(),R.anim.anim_upafterdown2);
        if(checkAnimHome == 0){
            imageSlider.startAnimation(fromBottonTop1);
            lnSearch.startAnimation(fromBottonTop1);
//            hrzview.startAnimation(fromBottonTop1);
//            gridLayout.startAnimation(fromBottonTop1);
//            ln2.startAnimation(fromBottonTop1);
        }
        else{
            imageSlider.startAnimation(fromBottonTop2);
            lnSearch.startAnimation(fromBottonTop2);
//            hrzview.startAnimation(fromBottonTop2);
//            gridLayout.startAnimation(fromBottonTop2);
//            ln2.startAnimation(fromBottonTop2);
        }
        checkAnimHome = 1;
    }
    private void handleClickEvent(){
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(1);
//                System.out.println("chuyen trang home : "+MainActivity2.changePage);
                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(2);
                tab.select();
            }
        });
        imgStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(1);
                Intent intent = new Intent(v.getContext(), MainActivityGioHang.class);
                startActivity(intent);
            }
        });
        txtXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(1);
                tab.select();

            }
        });

        this.lnMucLuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(1);
                tab.select();
            }
        });

        this.lnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(2);
                tab.select();
            }
        });

        this.lnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(3);
                tab.select();
            }
        });

        this.lnCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(4);
                tab.select();
            }
        });

    }
    private void handleImageSlider(){
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable._capture1,"Thầy vinh đẹp trai :)) ", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._capture2,"Thầy vinh đẹp trai :)) ", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._capture3,"Thầy vinh đẹp trai :)) ", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._capture4,"Thầy vinh đẹp trai :)) ", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

    }

}