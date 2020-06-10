package com.example.mobileprogramming_mbtiholic.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mobileprogramming_mbtiholic.R;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;

public class MainTabActivity extends AppCompatActivity {

    private MainTabFragmentPagerAdapter mainTabFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_main_tab);

        //액션바 숨기는 코드
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        mainTabFragmentPagerAdapter = new MainTabFragmentPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        TabLayout tabLayout =(TabLayout)findViewById(R.id.tablayout);

        viewPager.setAdapter(mainTabFragmentPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_library_books);
        tabLayout.getTabAt(2).setIcon(R.drawable.heart);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_mail_outline);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_check);

    }
}
