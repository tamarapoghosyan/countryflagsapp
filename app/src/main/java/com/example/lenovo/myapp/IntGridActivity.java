package com.example.lenovo.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class IntGridActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerView;
    IntAdapter adapter;
    List<Integer> integers;
    Button buttonScrollUp;
    Button buttonScrollDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_int_grid);

        integers=new ArrayList<>();
        for (int i=0;i<150;i++){
            integers.add(i);
        }
        recyclerView= (RecyclerView) findViewById(R.id.act_int_grid_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));

        adapter=new IntAdapter(integers);
        recyclerView.setAdapter(adapter);

        buttonScrollUp= (Button) findViewById(R.id.act_int_grid_btn_scrollup);
        buttonScrollDown= (Button) findViewById(R.id.act_int_grid_btn_scrolldown);

        buttonScrollDown.setOnClickListener(this);
        buttonScrollUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.act_int_grid_btn_scrollup:{
                if (recyclerView.getAdapter().getItemCount()-recyclerView.getScrollY()>4){
                   recyclerView.smoothScrollToPosition(0);
                }
                else
                    buttonScrollUp.setVisibility(View.GONE);
                //recyclerView.getLayoutManager().scrollToPosition(recyclerView.getAdapter().getItemCount() - 1);
               // recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView,null,0);
                //recyclerView.scrollToPosition(recyclerView.getScrollY()-5);
                break;
        }
            case R.id.act_int_grid_btn_scrolldown:{
            recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount());
                break;
            }
        }
    }
}
