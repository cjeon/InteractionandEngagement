package com.example.cjeon.interactionandengagement.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cjeon.interactionandengagement.Adapter.ExampleFragmentStatePagerAdapter;
import com.example.cjeon.interactionandengagement.R;

public class SwipeViewWithTabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_view_with_tabs);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ExampleFragmentStatePagerAdapter pagerAdapter = new ExampleFragmentStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.max = 3;
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
    }
}
