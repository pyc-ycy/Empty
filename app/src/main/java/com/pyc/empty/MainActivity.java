package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pyc.empty.facade.IFragmentCallback;
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
        Button login_btn = findViewById(R.id.toLogin);
        login_btn.setOnClickListener(this);
        Button toViewpager2 = findViewById(R.id.toViewpager2);
        toViewpager2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.d_f_btn1:
                /*Fragment 与 Activity 通信*/
                Bundle bundle = new Bundle();
                bundle.putString("msg","使用 Bundle 传递信息");
                BlankFragment1 blankFragment1 = new BlankFragment1();
                blankFragment1.setArguments(bundle);
                replaceFragment(blankFragment1);
                break;
            case R.id.d_f_btn2:
                BlankFragment2 bf2 = new BlankFragment2();
                bf2.setIFragmentCallback(new IFragmentCallback() {
                    @Override
                    public void sendMsgToActivity(String key, String msg) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public String getMsgFromActivity(String key) {
                        if (key == "A2F"){
                            return "This is a message from Activity";
                        }else {
                            return "Can not find any message!";
                        }
                    }
                });
                replaceFragment(bf2);
                break;
            case R.id.toLogin:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.toViewpager2:
                Intent intent1 = new Intent(MainActivity.this, Viewpager2Activity.class);
                startActivity(intent1);
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.d_f_frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}