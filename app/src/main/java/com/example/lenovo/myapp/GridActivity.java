package com.example.lenovo.myapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GridActivity extends AppCompatActivity {
    private static List<Country> countries;

//    static {
//        countries = new ArrayList<>();
//
//        countries.add(new Country("Armenia,Armйnie","am",false));
//        countries.add(new Country("Russian Federation,Russie","ru",false));
//        countries.add(new Country("Andorra,Andorre","ad",false));
//        countries.add(new Country("Albania,Albanie","al",false));
//        countries.add(new Country("Angola,Angola","ao",true));
//        countries.add(new Country("Italy,Italie","it",false));
//        countries.add(new Country("Sweden,Suиde","se",false));
//        countries.add(new Country("Vatican,Vatican","va",false));
//        countries.add(new Country("Greece,Grиce","gr",false));
//        countries.add(new Country("Georgia,Gйorgie","ge",false));

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
//    }

    RecyclerView recyclerView;
    private CountryGridAdapter adapter;
    AssetManager assetManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        recyclerView = (RecyclerView) findViewById(R.id.act_grid_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        countries = new ArrayList<>();
        context=recyclerView.getContext();
        assetManager=context.getAssets();
        InputStream input;

        try {

            input = assetManager.open("countries.txt");

            int size = input.available();

            byte[] buffer = new byte[size];

            input.read(buffer);

            input.close();

            List<String> lines=new ArrayList<>();
            // byte buffer into a string

            String text = new String(buffer);
            // StringBuilder stringBuilder=new StringBuilder(text);
            Scanner scanner = new Scanner(text);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
                // process the line
            }
            scanner.close();

            for (String a :lines) {
                String[] parts=a.split(",");
                String code=parts[0].toLowerCase();
                String name=parts[1];
                countries.add(new Country(name,code,false));
            }


            // txtContent.setText(text);

        } catch (IOException e) {

            e.printStackTrace();

        }





        adapter=new CountryGridAdapter(countries);






        // gridView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
    }
}
