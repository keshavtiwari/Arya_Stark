package com.example.android.aryastarkswishlist;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements AddRemoveFragment.AddRemoveFragment1 {
    CoverFragmentPageAdapter adapter;
    @Override
    public  WishlistFragment blankf(){
        WishlistFragment f=(WishlistFragment) adapter.getFragment(1);
        return f; 

    }

    MyDBhandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new MyDBhandler(this);
        if(db.getAllContacts().size()==0){
        db.addContact(new Contact(getString(R.string.item1),"Frey",BitmapFactory.decodeResource(this.getResources(),R.drawable.item1)));
        db.addContact(new Contact(getString(R.string.item2),"Lannister",BitmapFactory.decodeResource(this.getResources(),R.drawable.item2)));
        db.addContact(new Contact(getString(R.string.item3),"Clegane",BitmapFactory.decodeResource(this.getResources(),R.drawable.item3)));
        db.addContact(new Contact(getString(R.string.item4),"Payne",BitmapFactory.decodeResource(this.getResources(),R.drawable.item4)));
        db.addContact(new Contact(getString(R.string.item9),"Lannister",BitmapFactory.decodeResource(this.getResources(),R.drawable.item5)));}



        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
         adapter= new CoverFragmentPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout=(TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
