package com.example.cjeon.interactionandengagement;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cjeon.interactionandengagement.Fragment.SwipeViewFragment;

/**
 * Created by cjeon on 11/8/16.
 */

public class DrawerItemClickListener implements ListView.OnItemClickListener {
    public FragmentManager fragmentManager;
    public ListView listView;
    public DrawerLayout drawerLayout;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }

    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        Fragment fragment = new SwipeViewFragment();
        Bundle args = new Bundle();
        args.putInt(SwipeViewFragment.ARG_OBJECT, position);
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction()
                .replace(R.id.content_layout, fragment)
                .commit();

        // Highlight the selected item, update the title, and close the drawer
        listView.setItemChecked(position, true);
        drawerLayout.closeDrawer(listView);
    }
}


