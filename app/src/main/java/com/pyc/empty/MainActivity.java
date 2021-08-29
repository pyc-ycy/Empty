package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

/**
 * @author 彭友聪
 */

public class MainActivity extends Activity {

    private static final String TAG = "pyc:";


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.grid_layout);
    }

}