package com.example.lenovo.myapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by LENOVO on 04.05.2017.
 */
public class IntViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public IntViewHolder(View itemView) {
        super(itemView);
        textView= (TextView) itemView.findViewById(R.id.item_number_text);
    }
}
