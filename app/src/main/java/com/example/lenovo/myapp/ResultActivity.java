package com.example.lenovo.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ResultActivity extends AppCompatActivity {
    Context context;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        String imagePath=intent.getStringExtra("aaa");
        imageView= (ImageView) findViewById(R.id.act_result_imageview);
        context=this.getApplicationContext();
        AssetManager assetManager=context.getAssets();

        try {

            InputStream ims = assetManager.open(imagePath);
            Drawable d = Drawable.createFromStream(ims, null);

            imageView.setImageDrawable(d);        }

        catch(IOException ex) {

            return;

        }
    }
}
