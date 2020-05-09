package com.example.mobileprogramming_mbtiholic;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainTabFragmentPagerAdapter extends FragmentPagerAdapter {
//이렇게 4개를 만든다.
    private HomeTabFragment homTabFragment = new HomeTabFragment();
    private PostTabFragment postTabFragment = new PostTabFragment();
    private RelationshipTabFragment relationshipTabFragment = new RelationshipTabFragment();
    private MessageTabFragment messageTabFragment = new MessageTabFragment();
    private final int count = 4;

    public MainTabFragmentPagerAdapter(FragmentManager fragmentManager){
        //부모생성자 있음
        super(fragmentManager);

    }
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return homTabFragment;
            case 1:
                return postTabFragment;
            case 2:
                return relationshipTabFragment;
            case 3:
                return messageTabFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return count;
    }


}
