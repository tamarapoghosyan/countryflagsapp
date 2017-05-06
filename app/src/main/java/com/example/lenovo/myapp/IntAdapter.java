package com.example.lenovo.myapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by LENOVO on 04.05.2017.
 */
public class IntAdapter extends RecyclerView.Adapter<IntViewHolder> {
    List<Integer> ints;

    public IntAdapter(List<Integer> ints) {
        this.ints = ints;
    }

    @Override
    public IntViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_number, parent, false);
        return new IntViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IntViewHolder holder, int position) {
        Integer num=ints.get(position);
        holder.textView.setText(num.toString());
    }

    @Override
    public int getItemCount() {
        return ints.size();
    }
}
