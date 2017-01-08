package com.example.android.aryastarkswishlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by dell on 12/25/2016.
 */

public class AddRemoveFragment extends Fragment {
    private Button add_button,delete_button;
    MyDBhandler db;

    interface AddRemoveFragment1{
        public WishlistFragment blankf();
    }
    AddRemoveFragment1 mCallback;

    public AddRemoveFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.add_remove_fragment, container, false);
        mCallback=(AddRemoveFragment1) getContext();
        db=new MyDBhandler(getContext());
        add_button=(Button) rootview.findViewById(R.id.add_button);
        delete_button=(Button)rootview.findViewById(R.id.delete_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(getActivity(), AddActivity.class);
                startActivityForResult(addIntent,2);  }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delIntent = new Intent(getActivity(), DeleteActivity.class);
                startActivityForResult(delIntent,2);

            }
        });

        return rootview;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode==2){
            WishlistFragment f=mCallback.blankf();
            f.words=db.getAllContacts();
            f.adapter.gotList=f.words;
            f.adapter.notifyDataSetChanged();


        }
    }

}
