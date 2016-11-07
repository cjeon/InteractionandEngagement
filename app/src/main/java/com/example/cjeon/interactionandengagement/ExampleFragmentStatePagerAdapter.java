package com.example.cjeon.interactionandengagement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ExampleFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public ExampleFragmentStatePagerAdapter(FragmentManager fragmentManager) { super(fragmentManager); }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new SwipeViewFragment();
        Bundle args = new Bundle();
        args.putInt(SwipeViewFragment.ARG_OBJECT, position);
        fragment.setArguments(args);
        return fragment;
    }
}