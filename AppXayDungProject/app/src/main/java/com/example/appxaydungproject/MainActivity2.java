// Bạn đang dùng gì để lập trình dự án này vậy?
// Bạn có dùng những cái gì? của ai không? Bạn vui lòng tôn trọng tác phẩm và tác giả hãy để lại dẫn xuất những gì bạn mượn của người khác nhé.

package com.example.appxaydungproject;

// Import những cái này để làm gì tôi chưa hiểu bạn cần gì ở những thư viện này?
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

// Import những cái này để làm gì tôi chưa hiểu bạn cần gì ở những thư viện này?
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

// Import những cái này để làm gì tôi chưa hiểu bạn cần gì ở những thư viện này?
import com.example.appxaydungproject.Model.ItemSearch;
import com.example.appxaydungproject.TabMenu.BlankFragmentCaNhan;
import com.example.appxaydungproject.TabMenu.BlankFragmentDanhMuc;
import com.example.appxaydungproject.TabMenu.BlankFragmentHome;
import com.example.appxaydungproject.TabMenu.BlankFragmentTimKiem;
import com.google.android.material.tabs.TabLayout;

// Import những cái này để làm gì tôi chưa hiểu bạn cần gì ở những thư viện này?
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity2 extends AppCompatActivity {
// Bạn có thể mô tả sơ lược về class theo cấu trúc được không? Tôi không thể nhìn tổng thể class này dùng để làm gì. Mối quan hệ của class này với những cái khác.
    
    //  Inherited constants
    private ImageView bgapp;
    // Chức năng hoặc công dụng của nó là gì vậy? Quy tắc đặt tên của bạn là gì?
    private TabLayout.Tab tab;
    private ViewPager viewPager;
    private BlankFragmentHome homeFragment;
    private BlankFragmentDanhMuc danhmucFragment;
    private BlankFragmentTimKiem timkiemFragment;
    private BlankFragmentCaNhan canhanFragment;
    private ViewPagerAdapter viewPagerAdapter;
    
    // Hãy để 1 dòng trống để tôi hiểu nó theo từng nhóm bạn nhé, như vậy sẽ dễ nhìn hơn.
    //    Inherited fields
    public static int changePage = 0;
    public static TabLayout tabLayout;
    public static List<ItemSearch> lsItemSearch;
    
    //    Public constructors
    // Empty - Hãy để như vậy nếu không có gì ở nhóm này
    
    //    Protected methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhXa();
        setUpSystem();
    }
    
    //    Inherited methods
    // Empty
    
    //Public constructors
    // Empty    
    
    //Public methods
    private void anhXa(){
    // Công dụng:
    // Đầu vào:
    // Đầu ra:
    // Lưu ý:
        
        bgapp = (ImageView) findViewById(R.id.imgviewIntro);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }
    private void setUpSystem(){
        bgapp.animate().translationY(-2000).setDuration(800).setStartDelay(500);

        setUpViewPager();
    }
    private void setUpViewPager(){
        homeFragment = new BlankFragmentHome();
        danhmucFragment = new BlankFragmentDanhMuc();
        timkiemFragment = new BlankFragmentTimKiem();
        canhanFragment = new BlankFragmentCaNhan();
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),4);

        viewPagerAdapter.addFragment(homeFragment, "Home");
        viewPagerAdapter.addFragment(danhmucFragment, "Danh Mục");
        viewPagerAdapter.addFragment(timkiemFragment, "Tìm Kiếm");
        viewPagerAdapter.addFragment(canhanFragment, "Cá Nhân");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable._mucluc);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_search_24);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_person_24);

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#a8a8a8"), PorterDuff.Mode.SRC_IN);



        lsItemSearch = new ArrayList<>() ;
        lsItemSearch.add(new ItemSearch("sfsdfs"));
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
