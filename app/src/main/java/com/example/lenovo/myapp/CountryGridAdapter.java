package com.example.lenovo.myapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by LENOVO on 04.05.2017.
 */
public class CountryGridAdapter extends RecyclerView.Adapter<CountryGridViewHolder> {
    private List<Country> countries;

    Country country;
    Context context;


    public CountryGridAdapter(List<Country> countryList) {
        this.countries=countryList;
    }

    @Override
    public CountryGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_country_grid, parent, false);
        return new CountryGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryGridViewHolder holder, int position) {
        holder.bind(countries.get(position));

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

//    @Override
//    public int getCount() {
//        return countries.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        country=countries.get(position);
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.item_country_grid, parent, false);
//
//
//        nameTv= (TextView) view.findViewById(R.id.item_country_grid_name_tv);
//        checkBox= (CheckBox) view.findViewById(R.id.item_country_grid_checkbox);
//        imageView= (ImageView) view.findViewById(R.id.item_country_grid_flag_iv);
//
//        nameTv.setText(nameTv != null ? country.getName() : "");
//
//        context=view.getContext();
//        int resourceId = context.getResources().getIdentifier("s_flag_" + country.getCode(), "drawable",context.getApplicationContext().getPackageName());
//
//        if (resourceId > 0) {
//            imageView.setImageResource(resourceId);
//        } else {
//            imageView.setImageResource(R.drawable.s_flag_ad);
//            // Do something is the resource does not exist
//        }
//
//        if (country.isSelected()){
//            checkBox.setChecked(true);
//        } else {
//            checkBox.setChecked(false);
//        }
//
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    country.setSelected(true);
//                }
//                else country.setSelected(false);
//            }
//        });
//
//
//        return view;
//    }
}
