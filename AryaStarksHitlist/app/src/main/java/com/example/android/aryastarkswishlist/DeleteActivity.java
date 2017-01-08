package com.example.android.aryastarkswishlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    MyDBhandler db;
    String delete_name;
    Button del_btn;
    String selectedName="";
    ArrayList<Contact> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db=new MyDBhandler(this);
        Spinner spin=(Spinner)findViewById(R.id.spinner_name);
        ArrayList<String> my_array = new ArrayList<String>();
        my_array = db.getTableValues();

        ArrayAdapter my_Adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,
                my_array);
        spin.setAdapter(my_Adapter);
        spin.setOnItemSelectedListener(this);

        del_btn=(Button) findViewById(R.id.final_delete);
        items= db.getAllContacts();

        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete_name=selectedName;
                if(!selectedName.equals("")){
                for(int i=0;i<items.size();i++){
                    if(items.get(i).getName().equals(delete_name)){
                        db.deleteContact(items.get(i));
                        break;

                    }

                }
                Intent intent=new Intent();

                setResult(RESULT_OK,intent);
                finish();}
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    selectedName=adapterView.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }
}
