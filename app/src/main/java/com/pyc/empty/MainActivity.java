package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 彭友聪
 */
public class MainActivity extends AppCompatActivity {

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

        setContentView(R.layout.toolbar);

        // toolbar
        Toolbar tb = findViewById(R.id.tb);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onclick: toolbar was clicked!");
            }
        });

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
}