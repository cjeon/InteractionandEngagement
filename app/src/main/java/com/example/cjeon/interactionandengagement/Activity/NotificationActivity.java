package com.example.cjeon.interactionandengagement.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cjeon.interactionandengagement.R;

public class NotificationActivity extends AppCompatActivity {
    public static final String MESSAGE = "MESSAGE";
    public static final String DISMISS = "DISMISS";
    public static final String SNOOZE  = "SNOOZE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }
}
