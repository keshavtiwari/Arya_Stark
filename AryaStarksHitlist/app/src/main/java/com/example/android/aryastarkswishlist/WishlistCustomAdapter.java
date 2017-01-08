package com.example.android.aryastarkswishlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 12/19/2016.
 */

public class WishlistCustomAdapter extends ArrayAdapter<Contact> {
    MyDBhandler db;
    ArrayList<Contact> gotList;
    public WishlistCustomAdapter(Context context, ArrayList<Contact> words) {
        super(context, 0, words);
        gotList=words;


    }

    @Override
    public int getCount() {
        return gotList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.hitlistadapter_item, parent, false);
        }
        Contact currentWord=gotList.get(position);
        TextView name = (TextView) listItemView.findViewById(R.id.wishlist_text_view);
        ImageView img=(ImageView)  listItemView.findViewById(R.id.wishlist_image);
        name.setText(currentWord.getName());
        img.setImageBitmap(currentWord.get_image());
        return listItemView;
    }


}
