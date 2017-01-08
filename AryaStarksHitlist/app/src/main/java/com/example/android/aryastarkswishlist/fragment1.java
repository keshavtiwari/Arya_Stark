package com.example.android.aryastarkswishlist;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment1 extends Fragment {
    String name;
    String house;
    Bitmap image;
    CheckBox checkit;
    boolean check;
    Animation myFadeInAnimation;
    Contact c;
    MyDBhandler db;

     TextView name_text, house_text;
    ImageView image_set,overlapp_set;



    public fragment1() {
    }

    public fragment1(Contact contact) {
        name = contact.getName();
        house = contact.getHouse();
        image = contact.get_image();
        check=contact.getKilled();
        c=contact;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.hitlist_item_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name_text=(TextView) view.findViewById(R.id.name);
        house_text=(TextView) view.findViewById(R.id.house);
        image_set=(ImageView) view.findViewById(R.id.imageView);
        checkit=(CheckBox)view.findViewById(R.id.checkIfDead);
        overlapp_set=(ImageView) view.findViewById(R.id.overlapp);
        image_set.setImageBitmap(image);


        db=new MyDBhandler(getContext());

        name_text.setText(name);
        house_text.setText(house);
        checkit.setChecked(check);
        if (checkit.isChecked()){
            c.setKilled(true);
            overlapp_set.setVisibility(View.VISIBLE);
        }
        else{

            c.setKilled(false);
            overlapp_set.setVisibility(View.GONE);
        }
         myFadeInAnimation= AnimationUtils.loadAnimation(getActivity(), R.anim.fadein);

        checkit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkit.isChecked()){
                    c.setKilled(true);
                    overlapp_set.setVisibility(View.VISIBLE);
                    overlapp_set.startAnimation(myFadeInAnimation);
                    db.updateContact(c);

                }
                else{

                    c.setKilled(false);
                    overlapp_set.setVisibility(View.GONE);
                    db.updateContact(c);


                }

            }
        });


            }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);


    }
}
