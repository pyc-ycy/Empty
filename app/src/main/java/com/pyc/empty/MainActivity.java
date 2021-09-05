package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
        ImageView tav = findViewById(R.id.tween_animation_view);
        tav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 通过加载 xml 动画设置文件来创建一个 Animation 对象
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,
                        R.anim.scale);
                tav.startAnimation(animation);
            }
        });

    }
}