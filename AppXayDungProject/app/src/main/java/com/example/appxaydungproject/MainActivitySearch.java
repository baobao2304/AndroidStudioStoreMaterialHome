package com.example.appxaydungproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appxaydungproject.Adapter.RecycleViewAdapter;
import com.example.appxaydungproject.Model.ItemSearch;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivitySearch extends AppCompatActivity {
    public static RecyclerView myRecyclerViewSearch;
    public static RecycleViewAdapter recyclerViewAdapterSearch;
    private ImageView backArrow;
    private TextView txtXoa,txtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_search);
        anhXa();
        handleSystem();
    }

    private  void handleSystem(){
        handleRecycleViewItemSearch();
        handleClickEvent();
    }

    private void anhXa(){
        txtXoa = (TextView) findViewById(R.id.txtXoa);
        txtSearch = (TextView) findViewById(R.id.txtSearch);
        backArrow = (ImageView) findViewById(R.id.backArrow);
    }

    private void handleClickEvent(){
        txtXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.lsItemSearch.clear();
                recyclerViewAdapterSearch = new RecycleViewAdapter(MainActivitySearch.this, MainActivity2.lsItemSearch);
                myRecyclerViewSearch.setAdapter(recyclerViewAdapterSearch);
            }
        });
        //back with form   if home click search   return to home  and if click search in mucluc...
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity2.class);
                startActivity(intent);
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
                    Toast.makeText(MainActivitySearch.this,String.valueOf(MainActivity2.lsItemSearch.size()), Toast.LENGTH_SHORT).show();
                    MainActivity2.lsItemSearch.add(new ItemSearch(txtSearch.getText().toString()));

                    List<ItemSearch> lsSearch = new ArrayList<ItemSearch>();
                    for(int i = MainActivity2.lsItemSearch.size(); i >= 0; i--){
                        try {
                            lsSearch.add(MainActivity2.lsItemSearch.get(i));
                        }catch (Exception e){}
                    }

//                    SharedPreferences.Editor editor
                    recyclerViewAdapterSearch = new RecycleViewAdapter(MainActivitySearch.this, lsSearch);
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
        myRecyclerViewSearch = (RecyclerView) findViewById(R.id.contact_recycleview);
        recyclerViewAdapterSearch = new RecycleViewAdapter(MainActivitySearch.this, MainActivity2.lsItemSearch);
        myRecyclerViewSearch.setLayoutManager(new LinearLayoutManager(MainActivitySearch.this));

        myRecyclerViewSearch.setHasFixedSize(true);
        myRecyclerViewSearch.setAdapter(recyclerViewAdapterSearch);

    }
}