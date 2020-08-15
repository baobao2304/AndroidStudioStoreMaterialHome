package com.example.appxaydungproject.TabMenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.MainActivityGioHang;
import com.example.appxaydungproject.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentThongBao#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentThongBao extends Fragment {
    private Button btnMuaSam;
    View v;
    private ImageView imgStore;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentThongBao() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentThongBao.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentThongBao newInstance(String param1, String param2) {
        BlankFragmentThongBao fragment = new BlankFragmentThongBao();
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
        v =  inflater.inflate(R.layout.fragment_blank_thong_bao, container, false);
        anhXa();
        handleSystem();
        return  v;
    }

    private void anhXa(){
        btnMuaSam = (Button) v.findViewById(R.id.btnMuaSam);
        imgStore = (ImageView) v.findViewById(R.id.imgStore);
    }
    private void handleSystem(){

        handleAnimation();
        handleClickEvent();

    }
    private  void handleAnimation(){

    }
    private void handleClickEvent(){
        btnMuaSam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(0);
                tab.select();
            }
        });
        imgStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(3);
                Intent intent = new Intent(getActivity(), MainActivityGioHang.class);
                startActivity(intent);

            }
        });
    }
}