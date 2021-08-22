package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 彭友聪
 */
public class MainActivity extends Activity {

    private static final String TAG = "pyc:";
    private ProgressBar pb;
    private ProgressBar PBH;
    /*notification*/
    private NotificationManager notificationManager;
    private Notification notification;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(R.layout.alert_dialog);

        // toolbar
        /*Toolbar tb = findViewById(R.id.tb);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onclick: toolbar was clicked!");
            }
        });*/

        // progress bar
        pb = findViewById(R.id.progress_bar_native);
        PBH = findViewById(R.id.PBH);


    }

    public void PClick(View view) {
        Log.e(TAG, "onClick");
    }

    public void progressController(View view) {
        if(pb.getVisibility() == View.GONE) {
            pb.setVisibility(View.VISIBLE);
        } else {
            pb.setVisibility(View.GONE);
        }
    }

    public void progressHorizontalController(View view) {
        PBH.setIndeterminate(false);
        PBH.setProgress(0);
        int step = 2;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                int value = PBH.getProgress();
                PBH.setProgress(value + step);
            }
        }, 0, 1000);
    }

    public void sendNotification(View view) {
        notificationManager.notify(1001, notification);
    }

    public void cancelNotification(View view) {
        notificationManager.cancel(1001);
    }

    /*显示对话框*/
    public void dialog_show(View view) {

        View v = getLayoutInflater().inflate(R.layout.dialog_view, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.alert_dialog)
                .setTitle("Alert Dialog")
                .setMessage("Message content of current alert")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e(TAG,"点击对话框的确认按钮");
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e(TAG,"点击对话框的取消按钮");
                    }
                })
                .setNeutralButton("更多", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e(TAG,"点击对话框的更多按钮");
                    }
                })
                .create()
                .show();
    }
}