package com.pyc.empty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.pyc.empty.adapter.Viewpager2Adapter;

public class Viewpager2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);

        ViewPager2 viewPager = findViewById(R.id.viewpage2);
        Viewpager2Adapter viewpager2Adapter = new Viewpager2Adapter();
        viewPager.setAdapter(viewpager2Adapter);

    }
}