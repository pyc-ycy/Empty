package com.pyc.empty.fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.pyc.empty.R;
import com.pyc.empty.facade.IFragmentCallback;

;

public class BlankFragment2 extends Fragment {


    private View root;
    private TextView textView;
    private Button button;

    private IFragmentCallback iFragmentCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.image_view, container, false);
        }
        Button btn = root.findViewById(R.id.exchange_msg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFragmentCallback.sendMsgToActivity("F2A",
                        "Sending message from fragment to Activity");
            }
        });
        Button btn2 = root.findViewById(R.id.get_msg);
        TextView tv = root.findViewById(R.id.show_msg);
        btn2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                String msg = iFragmentCallback.getMsgFromActivity("A2F");
                tv.setText(msg);
                Toast.makeText(BlankFragment2.this.getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    public void setIFragmentCallback(IFragmentCallback iFragmentCallback) {
        this.iFragmentCallback = iFragmentCallback;
    }
}