package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

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

        setContentView(R.layout.animation_list);

        RelativeLayout relativeLayout = findViewById(R.id.animation_list_layout);
        AnimationDrawable anim = (AnimationDrawable) relativeLayout.getBackground();
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stop_flag) {
                    anim.start();
                    stop_flag = false;
                } else {
                    anim.stop();
                    stop_flag = true;
                }
            }
        });

    }
}