package com.example.appxaydungproject.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appxaydungproject.TabMenu.BlankFragmentCaNhan;
import com.example.appxaydungproject.TabMenu.BlankFragmentDanhMuc;
import com.example.appxaydungproject.TabMenu.BlankFragmentHome;
import com.example.appxaydungproject.TabMenu.BlankFragmentThongBao;
import com.example.appxaydungproject.TabMenu.BlankFragmentTimKiem;

public class OrdersPagerAdapter extends FragmentStateAdapter {

    public OrdersPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BlankFragmentHome();
            case 1:
                return new BlankFragmentDanhMuc();
            case 2:
                return new BlankFragmentTimKiem();
            case 3:
                return new BlankFragmentThongBao();
//            case 4:
//                return new BlankFragmentCaNhan();
            default:
                return new BlankFragmentCaNhan();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
