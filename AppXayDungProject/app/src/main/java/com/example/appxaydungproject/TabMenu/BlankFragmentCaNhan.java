package com.example.appxaydungproject.TabMenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appxaydungproject.Adapter.RecycleViewAdapter;
import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.MainActivityGioHang;
import com.example.appxaydungproject.MainActivityInfoUser;
import com.example.appxaydungproject.MainActivityLoginAndRegister;
import com.example.appxaydungproject.Model.UserModel;
import com.example.appxaydungproject.PagerLogin.BlankFragmentLogin;
import com.example.appxaydungproject.R;
import com.example.appxaydungproject.SettingAll.SettingAll;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentCaNhan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentCaNhan extends Fragment {
    public static Button btnDN,btnDX;
    private LinearLayout lnUser,lnMenu;
    private TextView txtName,txtEmail;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View v;
    private ImageView imgStore;
    public BlankFragmentCaNhan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentCaNhan.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentCaNhan newInstance(String param1, String param2) {
        BlankFragmentCaNhan fragment = new BlankFragmentCaNhan();
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
        v =  inflater.inflate(R.layout.fragment_blank_ca_nhan, container, false);



        anhXa();


        if(SettingAll.checkDNDX == 0){
            lnUser.setVisibility(View.GONE);
            lnMenu.setVisibility(View.GONE);
            btnDX.setVisibility(View.GONE);
            btnDN.setVisibility(View.VISIBLE);
        }
        else if(SettingAll.checkDNDX == 1) {
            lnUser.setVisibility(View.VISIBLE);
            lnMenu.setVisibility(View.VISIBLE);
            btnDX.setVisibility(View.VISIBLE);
            btnDN.setVisibility(View.GONE);
            txtName.setText( SettingAll.userModel.getName());
            txtEmail.setText(SettingAll.userModel.getEmail());
        }
        handleSystem();

        return  v;
    }

    private void anhXa(){
        lnUser = (LinearLayout) v.findViewById(R.id.lnMenu);
        lnMenu = (LinearLayout) v.findViewById(R.id.lnUser);
        imgStore = (ImageView) v.findViewById(R.id.imgStore);
        btnDX = (Button) v.findViewById(R.id.btnDX);
        btnDN = (Button) v.findViewById(R.id.btnDN);

        txtName =  (TextView) v.findViewById(R.id.txtName);
        txtEmail =  (TextView) v.findViewById(R.id.txtEmail);


    }
    private void handleClickEvent(){
        lnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivityInfoUser.class);
                startActivity(intent);
            }
        });
        imgStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(5);
                Intent intent = new Intent(getActivity(), MainActivityGioHang.class);
                startActivity(intent);
            }
        });

        btnDX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingAll.checkDNDX = 0;
                lnUser.setVisibility(View.GONE);
                lnMenu.setVisibility(View.GONE);



                SharedPreferences sharedPreferences = v.getContext().getSharedPreferences("data_user", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit= sharedPreferences.edit();
                edit.putString("id", "");
                edit.putString("pass", "");
                edit.putString("email", "");
                edit.putString("numberPhone", "");
                edit.putString("address", "");
                edit.putString("name", "");
                edit.commit();

                SettingAll.checkDNDX = 0;
//                Intent intent = new Intent(getActivity(), MainActivityLoginAndRegister.class);
//                startActivity(intent);
            }
        });
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivityLoginAndRegister.class);
                startActivity(intent);
            }
        });
    }
    private  void handleSystem(){
        handleClickEvent();



    }




    private void handleRecycleViewItemSearch(){


    }
}