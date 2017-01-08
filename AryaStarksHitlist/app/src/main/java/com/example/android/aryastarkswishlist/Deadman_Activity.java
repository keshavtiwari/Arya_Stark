package com.example.android.aryastarkswishlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by dell on 12/19/2016.
 */

public class Deadman_Activity extends AppCompatActivity {

   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.deadman_main);

        ViewPager viewPager1 = (ViewPager) findViewById(R.id.deadman_pager);
        int pos=getIntent().getIntExtra("yo",0);



        DeadmanFragmentPageAdapter adapter = new DeadmanFragmentPageAdapter(getSupportFragmentManager());
        MyDBhandler db = new MyDBhandler(this);
        ArrayList<Contact> list1 = db.getAllContacts();
        for (int i = 0; i < list1.size(); i++) {
            adapter.addFragment(new fragment1(list1.get(i)), (list1.get(i)).getName());
        }
        viewPager1.setAdapter(adapter);
       viewPager1.setCurrentItem(pos);

        TabLayout tabLayout1 = (TabLayout) findViewById(R.id.deadman_sliding_tabs);
        tabLayout1.setupWithViewPager(viewPager1);

    }}
