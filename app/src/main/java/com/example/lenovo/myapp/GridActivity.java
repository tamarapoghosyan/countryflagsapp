package com.example.lenovo.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    private static List<Country> countries;

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

    private GridView gridView;
    private CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

       Adapter adapter=new CountryGridAdapter(countries);
        gridView = (GridView) findViewById(R.id.act_grid_gridview);
       // gridView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));



        gridView.setAdapter((ListAdapter) adapter);
    }
}
