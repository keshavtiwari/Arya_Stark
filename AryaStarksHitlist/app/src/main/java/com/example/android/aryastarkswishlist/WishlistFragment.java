package com.example.android.aryastarkswishlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishlistFragment extends Fragment {
    ArrayList<Contact> words;
    MyDBhandler db;
    WishlistCustomAdapter adapter;
    ListView listView;

    public WishlistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hitlist_fragment, container, false);
        db=new MyDBhandler(getActivity());
        words=db.getAllContacts();


        adapter = new WishlistCustomAdapter(getActivity(), words);
        listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent deadIntent = new Intent(getActivity(), Deadman_Activity.class);
                deadIntent.putExtra("yo",position);

                getActivity().startActivity(deadIntent);




            }
        });



        return rootView;

    }

}
