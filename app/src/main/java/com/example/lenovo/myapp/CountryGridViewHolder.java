package com.example.lenovo.myapp;

import android.content.Context;
import android.content.Intent;
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
 * Created by LENOVO on 06.05.2017.
 */
public class CountryGridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView nameTv;
    private ImageView imageView;
    private CheckBox checkBox;
    private Country country;
    private Context context;

    public CountryGridViewHolder(View itemView) {
        super(itemView);
        nameTv = (TextView) itemView.findViewById(R.id.item_country_grid_name_tv);
        imageView = (ImageView) itemView.findViewById(R.id.item_country_grid_flag_iv);
        checkBox=(CheckBox) itemView.findViewById(R.id.item_country_grid_checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    country.setSelected(true);
                }
                else country.setSelected(false);
            }
        });
        nameTv.setOnClickListener(this);
    }
    public void bind(final Country country){

        this.country=country;
        nameTv.setText(nameTv != null ? country.getName() : "");
        context=itemView.getContext();

        AssetManager assetManager=context.getAssets();

        try {

            InputStream ims = assetManager.open("s_flag_" + country.getCode()+".png");
            Drawable d = Drawable.createFromStream(ims, null);

            imageView.setImageDrawable(d);        }

        catch(IOException ex) {

            return;

        }
        checkBox.setChecked(country.isSelected());
    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(context,ResultActivity.class );
        intent.putExtra("aaa","s_flag_" + country.getCode()+".png");
        context.startActivity(intent);

    }
}
