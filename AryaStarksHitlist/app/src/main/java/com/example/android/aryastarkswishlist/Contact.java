package com.example.android.aryastarkswishlist;

import android.graphics.Bitmap;

public class Contact {

    //private variables
    int _id;
    String _name;
    String _house;
    Bitmap _image;
    Boolean _killed;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name, String house,Bitmap image){
        this._id = id;
        this._name = name;
        this._house = house;
        this._image=image;
        this._killed=false;

    }
    public Contact(int id, String name, String house,Bitmap image,boolean b){
        this._id = id;
        this._name = name;
        this._house = house;
        this._image=image;
        this._killed=b;

    }

    // constructor
    public Contact(String name, String house, Bitmap image,boolean killed){
        this._name = name;
        this._house = house;
        this._image=image;
        this._killed=killed;
    }
    public Contact(String name, String house, Bitmap image){
        this._name = name;
        this._house = house;
        this._image=image;
        this._killed=false;
    }


    public Bitmap get_image() {
        return _image;
    }

    public void set_image(Bitmap _image) {
        this._image = _image;


    }

    // getting ID

    public void setKilled(Boolean _killed) {
        this._killed = _killed;
    }

    public int getID(){
        return this._id;
    }

    public Boolean getKilled() {
        return _killed;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getHouse(){
        return this._house;
    }

    // setting phone number
    public void setHouse(String house){
        this._house = house;
    }
}