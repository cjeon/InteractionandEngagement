package com.example.cjeon.interactionandengagement.Activity;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.cjeon.interactionandengagement.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

import static java.lang.StrictMath.toIntExact;

public class MainActivity extends AppCompatActivity {

    private NotificationCompat.Builder timedBuilder;
    private int id = 1;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
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
        taskStackBuilder.addNextIntentWithParentStack(up);
        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        int notificationId = 1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_error_outline_white_24dp)
                .setContentTitle("Normal Context")
                .setContentText("Normal Context")
                .setTicker("Note !")
                .setAutoCancel(true)
                .setVibrate(new long[] {1000, 1000});

        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());
    }

    public void sendNotificationWithSpecialContext(View view) {
        Intent special = new Intent(this, SpecialActivity.class);
        special.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, special, PendingIntent.FLAG_UPDATE_CURRENT);

        int notificationId = 2;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_error_outline_white_24dp)
                .setContentTitle("Special Context")
                .setContentText("Special text")
                .setTicker("Note !")
                .setAutoCancel(true)
                .setVibrate(new long[] {1000, 1000});

        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());

    }

    public void sendBigViewNotification(View view) {

        // Body
        Intent intent = new Intent(this, NotificationActivity.class)
                .putExtra(NotificationActivity.MESSAGE, "message")
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_error_outline_white_24dp)
                .setContentTitle("Special Context")
                .setContentText("Special text")
                .setTicker("Note !")
                .setAutoCancel(true)
                .setVibrate(new long[] {1000, 1000});

        builder.setContentIntent(pendingIntent);

        // Dismiss
        Intent dismissIntent = new Intent(this, NotificationActivity.class)
                .setAction(NotificationActivity.DISMISS);
        PendingIntent dismissPendingIntent = PendingIntent.getActivity(this, 0, dismissIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Snooze
        PendingIntent snoozePendingIntent = PendingIntent.getActivity(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("BIG VIEW MESSAGE"))
                .addAction(R.drawable.ic_delete_forever_black_24dp, "dismiss", dismissPendingIntent)
                .addAction(R.drawable.ic_done_black_24dp, "snooze", snoozePendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }

    public void getFixedDurationProgressNotification(View view) {
        timedBuilder = new NotificationCompat.Builder(this);
        timedBuilder.setContentTitle("Progress Bar")
                .setContentTitle("Progressing...")
                .setSmallIcon(R.drawable.ic_schedule_black_24dp)
                .setProgress(1,0,false);
        notificationManager.notify(id, timedBuilder.build());

        Observable.interval(50, TimeUnit.MILLISECONDS, Schedulers.io())
                .takeWhile(num -> num <= 60)
                .subscribe(
                        percentage -> {
                            timedBuilder.setProgress(60, percentage.intValue(), false);
                            notificationManager.notify(id, timedBuilder.build()); },
                        ignore -> {},
                        () -> {
                            timedBuilder.setProgress(1, 1, false)
                                    .setContentTitle("Done!")
                                    .setContentText("Done!")
                                    .setAutoCancel(true);
                            notificationManager.notify(id, timedBuilder.build()); }
                );
    }

    public void getOngoingProgressNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Progress Bar")
                .setContentTitle("Flow!")
                .setContentText("We do not know when it's gonna end")
                .setSmallIcon(R.drawable.ic_schedule_black_24dp)
                .setProgress(0,0,true);
        notificationManager.notify(1, builder.build());
    }

    public void openSwipeRefreshActivity(View view) {
        Intent intent = new Intent(this, SwipeRefreshActivity.class);
        startActivity(intent);
    }

    public void openSearchActivity(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
