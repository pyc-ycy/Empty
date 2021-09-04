package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭友聪
 */
public class MainActivity extends Activity {

    private static final String TAG = "pyc:";

    /*list view*/
    private List<Bean> data = new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycle_view);
        /*list view and recycle view*/
        for (int i=0; i<100; i++) {
            Bean bean = new Bean();
            bean.setName("item: " + i);
            data.add(bean);
        }
        RecyclerView recyclerView = findViewById(R.id.rv);
        /*布局1*/
        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);*/
        /*布局2*/
        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);*/
        /*layout 3*/
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        RecycleViewAdapter adapter = new RecycleViewAdapter(data, this);
        recyclerView.setAdapter(adapter);
        /*单击监听*/
        adapter.setOnItemClickListener(new RecycleViewAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyclerItemClick(int position) {
                Log.e(TAG, "item click on: " + position);
            }
        });
    }
}