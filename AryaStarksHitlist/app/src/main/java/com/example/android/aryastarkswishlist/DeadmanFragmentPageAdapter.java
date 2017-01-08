package com.example.android.aryastarkswishlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 12/19/2016.
 */

public class DeadmanFragmentPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    public DeadmanFragmentPageAdapter(FragmentManager fm){super(fm);}
    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }


    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
    }





