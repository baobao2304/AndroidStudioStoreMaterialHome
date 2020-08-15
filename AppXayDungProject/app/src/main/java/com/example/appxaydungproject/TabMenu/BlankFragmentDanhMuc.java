package com.example.appxaydungproject.TabMenu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.appxaydungproject.Adapter.RecycleViewAdapterProduct;
import com.example.appxaydungproject.Adapter.RecycleViewAdapterTypeProduct;
import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.MainActivityGioHang;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.Model.TypeProductModel;
import com.example.appxaydungproject.R;
import com.example.appxaydungproject.Retrofit.ApiUntils;
import com.example.appxaydungproject.Retrofit.DataClient;
import com.example.appxaydungproject.Retrofit.RetrofitClient;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentDanhMuc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentDanhMuc extends Fragment {
    View v;
    private RelativeLayout relativeLayoutSearch;
    private ImageView imgSearch,imgStore;

    public static RecyclerView myRecyclerViewTypePR,rcv_Product_PageType;
    public static RecycleViewAdapterTypeProduct recyclerViewAdapterTypePR;
    public static RecycleViewAdapterProduct recycleViewAdapterProduct;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentDanhMuc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentDanhMuc.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentDanhMuc newInstance(String param1, String param2) {
        BlankFragmentDanhMuc fragment = new BlankFragmentDanhMuc();
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
        MainActivity2.setChangePage(2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_blank_danh_muc, container, false);

        anhXa();
        handleSystem();
        return  v;

    }
    private  void anhXa(){

        //test
        relativeLayoutSearch = (RelativeLayout) v.findViewById(R.id.rlSearchBar);
        imgSearch =  (ImageView) v.findViewById(R.id.searchBar);
        imgStore = (ImageView) v.findViewById(R.id.imgStore);
    }
    private void handleSystem(){
//        handleRetrofitAPI();
        handleEvent();
        handleRCVTypePR();
        handleRCVProductPageType();
    }


    private void handleRCVTypePR(){

        myRecyclerViewTypePR = (RecyclerView) v.findViewById(R.id.rcvTypePR);
        RetrofitClient.getDataTypeProduct(v);
    }
    private void handleRCVProductPageType(){


        rcv_Product_PageType = (RecyclerView) v.findViewById(R.id.rcv_Product_PageType);
//        recycleViewAdapterProduct = new RecycleViewAdapterProduct(getActivity(),lsItemProductPageType);
//        rcv_Product_PageType.setLayoutManager(new GridLayoutManager(getActivity(),3));
//
//        rcv_Product_PageType.setHasFixedSize(true);
//        rcv_Product_PageType.setAdapter(recycleViewAdapterProduct);
    }
    private void handleEvent(){
        relativeLayoutSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                TabLayout.Tab tab;
//                tab = MainActivity2.tabLayout.getTabAt(2);
//                tab.select();
            }
        });
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(2);
//                System.out.println("chuyen trang mucluc : "+MainActivity2.getChangePage());

                TabLayout.Tab tab;
                tab = MainActivity2.tabLayout.getTabAt(2);
                tab.select();
            }
        });
        imgStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(2);
                Intent intent = new Intent(v.getContext(), MainActivityGioHang.class);
                startActivity(intent);
            }
        });
    }
//    private void handleRetrofitAPI() {
//        ProgressDialog progressDoalog;
//        progressDoalog = new ProgressDialog(v.getContext());
//        progressDoalog.setMessage("Loading....");
//        progressDoalog.show();
//
////        DataClient dataClient = ApiUntils.getDataTypeProduct();
//        /*Create handle for the RetrofitInstance interface*/
//        DataClient service = RetrofitClient.getClient(ApiUntils.Base_Url).create(DataClient.class);
//        Call<List<TypeProductModel>> call = service.doGetListTypeProduct();
//        call.enqueue(new Callback<List<TypeProductModel>>() {
//
//            @Override
//            public void onResponse(Call<List<TypeProductModel>> call, Response<List<TypeProductModel>> response) {
//                progressDoalog.dismiss();
//                lsItemTypeProduct = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<TypeProductModel>> call, Throwable t) {
//                progressDoalog.dismiss();
//                Toast.makeText(v.getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}