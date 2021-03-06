package com.example.lenovo.myapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by LENOVO on 03.05.2017.
 */
public class CountryViewHolder extends RecyclerView.ViewHolder {

        Context context;

    private TextView nameTv;
    private ImageView arrowView;
    private CheckBox checkBox;
    private Country country;

    public CountryViewHolder(View itemView) {
        super(itemView);

        nameTv = (TextView) itemView.findViewById(R.id.item_country_name_tv);
        arrowView = (ImageView) itemView.findViewById(R.id.item_country_flag_iv);
    checkBox=(CheckBox) itemView.findViewById(R.id.item_country_checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    country.setSelected(true);
                }
                else country.setSelected(false);
            }
        });

    }

    public void bind(final Country country){

        this.country=country;
        nameTv.setText(nameTv != null ? country.getName() : "");
        context=itemView.getContext();

        AssetManager assetManager=context.getAssets();

        try {

            InputStream ims = assetManager.open("s_flag_" + country.getCode()+".png");
            Drawable d = Drawable.createFromStream(ims, null);

            arrowView.setImageDrawable(d);        }

        catch(IOException ex) {

            return;

        }

//        int resourceId = context.getResources().getIdentifier("s_flag_" + country.getCode(), "drawable",context.getApplicationContext().getPackageName());
//
//        if (resourceId > 0) {
//            arrowView.setImageResource(resourceId);
//        } else {
//            arrowView.setImageResource(R.drawable.s_flag_ad);
//        }

        checkBox.setChecked(country.isSelected());
//        if (country.isSelected()){
//            checkBox.setChecked(true);
//        } else {
//            checkBox.setChecked(false);
//        }


    }







}
//listview
//w