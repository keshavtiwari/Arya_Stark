package com.example.android.aryastarkswishlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dell on 12/18/2016.
 */

public class CoverFragmentPageAdapter extends FragmentPagerAdapter {
    CoverFragment coverFragment;
    WishlistFragment wishlistFragment;
    AddRemoveFragment addRemoveFragment;
    public CoverFragmentPageAdapter(FragmentManager fm){super(fm);}
    String[] tabTitles={"Home","Hitlist","Add/remove"};
    public Fragment getItem(int position) {
        if (position == 0) {
            if (coverFragment==null)
                coverFragment=new CoverFragment();
            return coverFragment;
        } else if (position==1){
            if (wishlistFragment==null)
                wishlistFragment=new WishlistFragment();
            return wishlistFragment;
        }else{
            if (addRemoveFragment==null)
                addRemoveFragment=new AddRemoveFragment();
            return addRemoveFragment;
        }
    }
    public Fragment getFragment(int position){
        if (position == 0) {
            return coverFragment;
        } else if (position==1){
            return wishlistFragment;
        }else{
            return addRemoveFragment;
        }
    }

    @Override
    public int getCount(){
        return 3;
    }
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}



