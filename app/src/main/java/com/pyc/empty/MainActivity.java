package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pyc.empty.fragments.BlankFragment1;
import com.pyc.empty.fragments.BlankFragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭友聪
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "pyc:";
    private boolean stop_flag = true;

    /*list view*/
    private List<Bean> data = new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_fragment);
        // 动态添加 fragment
        Button btn1 = findViewById(R.id.d_f_btn1);
        btn1.setOnClickListener(this);
        Button btn2 = findViewById(R.id.d_f_btn2);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.d_f_btn1:
                replaceFragment(new BlankFragment1());
                break;
            case R.id.d_f_btn2:
                replaceFragment(new BlankFragment2());
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.d_f_frameLayout, fragment);
        fragmentTransaction.commit();

    }
}