package com.example.cjeon.interactionandengagement.Activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cjeon.interactionandengagement.DrawerItemClickListener;
import com.example.cjeon.interactionandengagement.R;

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        // Drawer settings
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView listView = (ListView) findViewById(R.id.left_drawer);
        String[] names = getResources().getStringArray(R.array.drawer_array);

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item_textview, names));
        DrawerItemClickListener drawerItemClickListener = new DrawerItemClickListener();
        drawerItemClickListener.fragmentManager = getSupportFragmentManager();
        drawerItemClickListener.listView = listView;
        drawerItemClickListener.drawerLayout = drawerLayout;
        listView.setOnItemClickListener( drawerItemClickListener );

    }
}
