package com.pyc.empty;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 彭友聪
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "leq";
    private ProgressBar pb;
    private ProgressBar PBH;
    private NotificationManager notificationManager;
    private Notification notification;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(R.layout.notification);
        pb = findViewById(R.id.progress_bar_native);
        PBH = findViewById(R.id.PBH);

//        notification
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        /*判断机器的Android版本是否大于8.0*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("pyc",
                    "系统通知",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notification = new NotificationCompat
                .Builder(this, "pyc")
                .setContentTitle("Notification Title")
                .setContentText("This is content text of current notification")
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .build();


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