package com.example.android.aryastarkswishlist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static com.example.android.aryastarkswishlist.R.id.imageView;

public class AddActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;

    EditText inputName,inputHouse;
    MyDBhandler db;
    ImageView Check_img;
    Bitmap myBitmap;
    TextView warn;
    int height=300;int width=300;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        inputName=(EditText)findViewById(R.id.Input_name);
        inputHouse=(EditText)findViewById(R.id.Input_house);

        Check_img=(ImageView)findViewById(R.id.Inputcheck);
        warn=(TextView) findViewById(R.id.warning);




        Check_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_gallery();
            }
        });

        db=new MyDBhandler(this);

        FloatingActionButton final_add=(FloatingActionButton) findViewById(R.id.final_add);
        final_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputName.getText().toString().equals("")){
                    warn.setText("Please enter name");
                    warn.setVisibility(View.VISIBLE);
                }
                else if(inputHouse.getText().toString().equals("")){
                    warn.setText("Please enter house");
                    warn.setVisibility(View.VISIBLE);
                }
                else if(myBitmap==null){
                    warn.setText("Please select image");
                    warn.setVisibility(View.VISIBLE);
                }
                else{
                db.addContact(new Contact(inputName.getText().toString(),inputHouse.getText().toString(),myBitmap));
                Intent intent=new Intent();

                setResult(RESULT_OK,intent);
                finish();}
            }
        });

    }
   private void open_gallery(){
        Intent gallery =
                new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {

            try {
                InputStream stream=getContentResolver().openInputStream(data.getData());
                myBitmap=BitmapFactory.decodeStream(stream);
                myBitmap = Bitmap.createScaledBitmap(myBitmap,width,height, true);
                Check_img.setImageBitmap(myBitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


    }
}
