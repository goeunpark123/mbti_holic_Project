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
        setContentView(R.layout.activity_main_tab);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        mainTabFragmentPagerAdapter = new MainTabFragmentPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        TabLayout tabLayout =(TabLayout)findViewById(R.id.tablayout);

        viewPager.setAdapter(mainTabFragmentPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.newcontract);
        tabLayout.getTabAt(2).setIcon(R.drawable.newheart);
        tabLayout.getTabAt(3).setIcon(R.drawable.newemail);

    }
}
