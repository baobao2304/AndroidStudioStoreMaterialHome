package com.example.appxaydungproject.TabMenu;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.MainActivitySearch;
import com.example.appxaydungproject.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentHome extends Fragment {
    private LinearLayout  lnSearch,ln1,ln2,ln3,ln4,ln5,ln6,ln7;
    private Animation fromBottonTop;
    private ImageSlider imageSlider;
    private ImageView searchBar;
    private int checkAnimHome = 0 ;
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
        imageSlider = (ImageSlider) v.findViewById(R.id.imageSlider);

        ln1 = (LinearLayout) v.findViewById(R.id.ln1);
        ln2 = (LinearLayout) v.findViewById(R.id.ln2);
        ln3 = (LinearLayout) v.findViewById(R.id.ln3);
        ln4 = (LinearLayout) v.findViewById(R.id.ln4);
        ln5 = (LinearLayout) v.findViewById(R.id.ln5);
        ln6 = (LinearLayout) v.findViewById(R.id.ln6);
        ln7 = (LinearLayout) v.findViewById(R.id.ln7);
    }
    private void handleSystem(){

        handleAnimation();
        handleClickEvent();
        handleImageSlider();
    }
    private  void handleAnimation(){
        if(checkAnimHome == 0){
            fromBottonTop =  AnimationUtils.loadAnimation(v.getContext(),R.anim.anim_upafterdown);
            lnSearch.startAnimation(fromBottonTop);
            ln1.startAnimation(fromBottonTop);
            ln2.startAnimation(fromBottonTop);
            ln3.startAnimation(fromBottonTop);
            ln4.startAnimation(fromBottonTop);
            ln5.startAnimation(fromBottonTop);
            ln6.startAnimation(fromBottonTop);
            ln7.startAnimation(fromBottonTop);
        }

    }
    private void handleClickEvent(){
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(1);
                System.out.println("chuyen trang home : "+MainActivity2.changePage);
                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(2);
                tab.select();
            }
        });
    }
    private void handleImageSlider(){
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable._1,"Image 1 ", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._2,"Image 1 ", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable._3,"Image 1 ", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        imageSlider.startAnimation(fromBottonTop);
    }
}