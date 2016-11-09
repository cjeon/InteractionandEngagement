package com.example.cjeon.interactionandengagement.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cjeon.interactionandengagement.R;

public class UpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up);
        try {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {
            try {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } catch (NullPointerException ignore) { }
        }


    }
}
