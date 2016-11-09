package com.example.cjeon.interactionandengagement.Activity;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.cjeon.interactionandengagement.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFragmentSwipeView(View view) {
        Intent intent = new Intent(this, FragmentSwipeViewActivity.class);
        startActivity(intent);
    }

    public void openFragmentStateSwipeView(View view) {
        Intent intent = new Intent(this, FragmentStateSwipeViewActivity.class);
        startActivity(intent);
    }

    public void openSwipeViewWithTabs(View view) {
        Intent intent = new Intent(this, SwipeViewWithTabsActivity.class);
        startActivity(intent);
    }

    public void openDrawerActivity(View view) {
        Intent intent = new Intent(this, DrawerActivity.class);
        startActivity(intent);
    }

    public void openUpActivity(View view) {
        Intent intent = new Intent(this, UpActivity.class);
        startActivity(intent);
    }

    public void openCustomBackButtonActivity(View view) {
        Intent intent = new Intent(this, FragmentStateSwipeViewActivity.class);
        Intent intent2 = new Intent(this, FragmentSwipeViewActivity.class);
        Intent main = new Intent(this, MainActivity.class);
        Intent[] intents = TaskStackBuilder.create(this)
                .addNextIntent(main)
                .addNextIntent(intent)
                .addNextIntent(intent2)
                .getIntents();
        startActivities(intents);
    }

    public void openFragmentBackNavigationActivity(View view) {
        Intent intent = new Intent(this, FragmentBackActivity.class);
        startActivity(intent);
    }

    public void sendNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_error_outline_white_24dp)
                .setContentTitle("Notification Title")
                .setContentText("Notification text")
                .setTicker("Note !")
                .setVibrate(new long[] {1000, 1000});

        Intent main = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, main, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        int notificationId = 1;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());
    }

    public void sendNotificationWithRegularContext(View view) {

        Intent up = new Intent(this, UpActivity.class);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        // Add parent (i.e. main)
        taskStackBuilder.addParentStack(UpActivity.class);
        // Add body (i.e. up)
        taskStackBuilder.addNextIntent(up);
        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        int notificationId = 1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_error_outline_white_24dp)
                .setContentTitle("Notification Title")
                .setContentText("Notification text")
                .setTicker("Note !")
                .setVibrate(new long[] {1000, 1000});

        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());
    }
}
