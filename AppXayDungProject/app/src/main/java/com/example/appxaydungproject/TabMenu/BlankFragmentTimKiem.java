package com.example.appxaydungproject.TabMenu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appxaydungproject.Adapter.RecycleViewAdapter;
import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.Model.ItemSearch;
import com.example.appxaydungproject.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentTimKiem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentTimKiem extends Fragment {
    public static RecyclerView myRecyclerViewSearch;
    public static RecycleViewAdapter recyclerViewAdapterSearch;
    private ImageView backArrow;
    private TextView txtXoa,txtSearch;
    View v;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentTimKiem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentTimKiem.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentTimKiem newInstance(String param1, String param2) {
        BlankFragmentTimKiem fragment = new BlankFragmentTimKiem();
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
        v = inflater.inflate(R.layout.fragment_blank_tim_kiem, container, false);
        anhXa();
        handleSystem();

        return  v;
    }

    private  void handleSystem(){
        handleRecycleViewItemSearch();
        handleClickEvent();
    }

    private void anhXa(){
        txtXoa = (TextView) v.findViewById(R.id.txtXoa);
        txtSearch = (TextView) v.findViewById(R.id.txtSearch);
        backArrow = (ImageView) v.findViewById(R.id.backArrow);
    }

    private void handleClickEvent(){
        txtXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.lsItemSearch.clear();
                recyclerViewAdapterSearch = new RecycleViewAdapter(getActivity(), MainActivity2.lsItemSearch);
                myRecyclerViewSearch.setAdapter(recyclerViewAdapterSearch);
            }
        });
        //back with form   if home click search   return to home  and if click search in mucluc...
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout.Tab tab;
                if(MainActivity2.changePage != 0){
                    if(MainActivity2.changePage == 1){
                        MainActivity2.changePage = 0;
                        tab = MainActivity2.tabLayout.getTabAt(0);
                        tab.select();
                    }
                    if(MainActivity2.changePage == 2){
                        MainActivity2.changePage = 0;
                        tab = MainActivity2.tabLayout.getTabAt(1);
                        tab.select();
                    }

                }
            }
        });
//        txtSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        txtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    Toast.makeText(getActivity(),String.valueOf(MainActivity2.lsItemSearch.size()), Toast.LENGTH_SHORT).show();
                    MainActivity2.lsItemSearch.add(new ItemSearch(txtSearch.getText().toString()));

                    List<ItemSearch> lsSearch = new ArrayList<ItemSearch>();
                    for(int i = MainActivity2.lsItemSearch.size(); i >= 0; i--){
                        try {
                            lsSearch.add(MainActivity2.lsItemSearch.get(i));
                        }catch (Exception e){}
                    }

//                    SharedPreferences.Editor editor
                    recyclerViewAdapterSearch = new RecycleViewAdapter(getActivity(), lsSearch);
                    myRecyclerViewSearch.setAdapter(recyclerViewAdapterSearch);
                    txtSearch.setText("");
                    return true;
                }
                return false;

            }
        });
    }


    public static void setArrayPrefs(String arrayName, ArrayList<String> array, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.size());
        for(int i=0;i<array.size();i++)
            editor.putString(arrayName + "_" + i, array.get(i));
        editor.apply();
    }

    public static ArrayList<String> getArrayPrefs(String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        ArrayList<String> array = new ArrayList<>(size);
        for(int i=0;i<size;i++)
            array.add(prefs.getString(arrayName + "_" + i, null));
        return array;
    }


    private void handleRecycleViewItemSearch(){
        myRecyclerViewSearch = (RecyclerView) v.findViewById(R.id.contact_recycleview);
        recyclerViewAdapterSearch = new RecycleViewAdapter(getActivity(), MainActivity2.lsItemSearch);
        myRecyclerViewSearch.setLayoutManager(new LinearLayoutManager(getActivity()));

        myRecyclerViewSearch.setHasFixedSize(true);
        myRecyclerViewSearch.setAdapter(recyclerViewAdapterSearch);

    }
}