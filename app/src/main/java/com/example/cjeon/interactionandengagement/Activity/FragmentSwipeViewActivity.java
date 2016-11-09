package com.example.cjeon.interactionandengagement.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.cjeon.interactionandengagement.Adapter.ExampleFragmentPagerAdapter;
import com.example.cjeon.interactionandengagement.R;

public class FragmentSwipeViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_swipe_view);

        FragmentPagerAdapter fragmentPagerAdapter1 = new ExampleFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager1 = (ViewPager) findViewById(R.id.viewPager1);
        viewPager1.setAdapter(fragmentPagerAdapter1);

        FragmentPagerAdapter fragmentPagerAdapter2 = new ExampleFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager2 = (ViewPager) findViewById(R.id.viewPager2);
        viewPager2.setAdapter(fragmentPagerAdapter2);
    }
}
