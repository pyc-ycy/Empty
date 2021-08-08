package com.pyc.empty;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 彭友聪
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "leq";
    private EditText user;
    private EditText pwd;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(R.layout.image_view);

        /*模拟登陆功能*/
        /*Button login = findViewById(R.id.login);
        user = findViewById(R.id.user);
        pwd = findViewById(R.id.pwd);
        login.setOnClickListener(V -> {
            String user_value = user.getText().toString();
            String pwd_value = pwd.getText().toString();
            System.out.println("\nuser:\t" + user_value + "\npwd:\t" + pwd_value);
        });*/

//        Button btn = findViewById(R.id.btn_click);
        /*点击监听器*/
        /*btn.setOnClickListener(v -> Log.e(TAG, "onclick"));*/

        /*长按监听器
        btn.setOnLongClickListener(v -> {
            Log.e(TAG, "onLongClick");
            return true;
        });
        btn.setOnTouchListener((v, event) -> {
            Log.e(TAG, "onTouch" + event.getAction());
            return false;
        });*/
    }

    public void PClick(View view) {
        Log.e(TAG, "onClick");
    }
}