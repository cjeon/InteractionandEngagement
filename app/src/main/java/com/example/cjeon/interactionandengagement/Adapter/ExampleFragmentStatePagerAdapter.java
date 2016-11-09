package com.example.cjeon.interactionandengagement.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.cjeon.interactionandengagement.Fragment.SwipeViewFragment;

import java.util.Locale;

public class ExampleFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public ExampleFragmentStatePagerAdapter(FragmentManager fragmentManager) { super(fragmentManager); }
    public int max = 100;

    @Override
    public int getCount() {
        return max;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new SwipeViewFragment();
        Bundle args = new Bundle();
        args.putInt(SwipeViewFragment.ARG_OBJECT, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.format(Locale.getDefault(),"Tab %d", position);
    }
}