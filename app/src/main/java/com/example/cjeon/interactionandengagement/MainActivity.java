package com.example.cjeon.interactionandengagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
}
