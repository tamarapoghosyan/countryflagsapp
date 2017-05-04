package com.example.lenovo.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static List<Country> countries;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    static {
        countries = new ArrayList<>();

        countries.add(new Country("Armenia,Armйnie","am",false));
        countries.add(new Country("Russian Federation,Russie","ru",false));
        countries.add(new Country("Andorra,Andorre","ad",false));
        countries.add(new Country("Albania,Albanie","al",false));
        countries.add(new Country("Angola,Angola","ao",true));
        countries.add(new Country("Italy,Italie","it",false));
        countries.add(new Country("Sweden,Suиde","se",false));
        countries.add(new Country("Vatican,Vatican","va",false));
        countries.add(new Country("Greece,Grиce","gr",false));
        countries.add(new Country("Georgia,Gйorgie","ge",false));

//
//        for(int i = 0; i < 1000; i++){
//
//            countries.add(new Country(
//                    String.format("Name %s", i),
//                    String.format("Code %s", i),
//                    // i % 2 == 0 ? "M" : "F",
//                    i % 2 != 0
//            ));
//        }
    }

    Button btnList;
    Button btnGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnList= (Button) findViewById(R.id.act_main_btn_list);
        btnGrid= (Button) findViewById(R.id.act_main_btn_grid);

        btnList.setOnClickListener(this);
        btnGrid.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.act_main_btn_list:{
                Intent intent = new Intent(MainActivity.this, ListActivity.class);

                //intent.putExtra(EXTRA_MESSAGE,"aaa");
                MainActivity.this.startActivity(intent);
                break;
            }
            case R.id.act_main_btn_grid: {
                Intent intent = new Intent(MainActivity.this, GridActivity.class);

               // intent.putExtra(EXTRA_MESSAGE,"aaa");
                MainActivity.this.startActivity(intent);
            break;
            }
        }

    }
}
