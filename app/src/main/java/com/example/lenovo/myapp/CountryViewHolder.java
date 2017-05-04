package com.example.lenovo.myapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by LENOVO on 03.05.2017.
 */
public class CountryViewHolder extends RecyclerView.ViewHolder {

        Context context;

    private TextView nameTv;
    // private TextView codeTv;
//    private TextView genderTv;
    private ImageView arrowView;
    private CheckBox checkBox;

    public CountryViewHolder(View itemView) {
        super(itemView);

        nameTv = (TextView) itemView.findViewById(R.id.item_country_name_tv);
        ///codeTv = (TextView) itemView.findViewById(R.id.item_user_lanme_tv);
        // genderTv = (TextView) itemView.findViewById(R.id.item_user_gender);
        arrowView = (ImageView) itemView.findViewById(R.id.item_country_flag_iv);
    checkBox=(CheckBox) itemView.findViewById(R.id.item_country_checkbox);
    }

    public void bind(final Country country){
        nameTv.setText(nameTv != null ? country.getName() : "");
        // lNameTv.setText(lNameTv != null ? user.getlName() : "");
        //genderTv.setText(genderTv != null ? user.getGender() : "");


        context=itemView.getContext();
        int resourceId = context.getResources().getIdentifier("s_flag_" + country.getCode(), "drawable",context.getApplicationContext().getPackageName());

        if (resourceId > 0) {
            arrowView.setImageResource(resourceId);
        } else {
            arrowView.setImageResource(R.drawable.s_flag_ad);
            // Do something is the resource does not exist
        }

        if (country.isSelected()){
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }

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
}
