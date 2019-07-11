package com.example.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class sliderAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList= new ArrayList<>();


    public sliderAdapter(FragmentManager fm) {
        super(fm);
    }

    public void AddFragment(Fragment fragment){
        fragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
