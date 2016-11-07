package com.example.cjeon.interactionandengagement;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentStateSwipeViewActivity extends AppCompatActivity {
    ExampleFragmentStatePagerAdapter exampleFragmentStatePagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_state_swipe_view);

        exampleFragmentStatePagerAdapter = new ExampleFragmentStatePagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(exampleFragmentStatePagerAdapter);
    }
}