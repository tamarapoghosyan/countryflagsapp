package com.example.lenovo.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
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

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent=getIntent();
        recyclerView = (RecyclerView) findViewById(R.id.act_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new CountryAdapter(countries);

        recyclerView.setAdapter(adapter);
    }
}
