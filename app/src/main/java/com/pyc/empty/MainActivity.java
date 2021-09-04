package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

        setContentView(R.layout.list_view);
        /*list view*/
        for (int i=0; i<100; i++) {
            Bean bean = new Bean();
            bean.setName("item: " + i);
            data.add(bean);
        }

        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(new MyAdapter(data, this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, "onItemClick: " + position);
            }
        });

    }

}