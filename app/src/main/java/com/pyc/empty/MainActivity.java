package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭友聪
 */
public class MainActivity extends Activity {

    private static final String TAG = "pyc:";
    private boolean stop_flag = true;

    /*list view*/
    private List<Bean> data = new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_animation);

    }
}