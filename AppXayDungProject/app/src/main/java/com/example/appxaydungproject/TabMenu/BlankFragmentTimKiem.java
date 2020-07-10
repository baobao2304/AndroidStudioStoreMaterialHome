package com.example.appxaydungproject.TabMenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appxaydungproject.Adapter.RecycleViewAdapter;
import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentTimKiem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentTimKiem extends Fragment {
    public static RecyclerView myRecyclerView;
    public static RecycleViewAdapter recyclerViewAdapter;
    private ImageView backArrow;
    private TextView txtXoa;
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
        System.out.println("1change page : "+MainActivity2.getChangePage());
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
        backArrow = (ImageView) v.findViewById(R.id.backArrow);
    }

    private void handleClickEvent(){
        txtXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.lsItemSearch.clear();
                recyclerViewAdapter = new RecycleViewAdapter(getActivity(), MainActivity2.lsItemSearch);
                myRecyclerView.setAdapter(recyclerViewAdapter);
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
    }

    private void handleRecycleViewItemSearch(){
        myRecyclerView = (RecyclerView) v.findViewById(R.id.contact_recycleview);
        recyclerViewAdapter = new RecycleViewAdapter(getActivity(), MainActivity2.lsItemSearch);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setAdapter(recyclerViewAdapter);

    }
}