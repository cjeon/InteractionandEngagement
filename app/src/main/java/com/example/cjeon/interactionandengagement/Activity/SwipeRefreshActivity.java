package com.example.cjeon.interactionandengagement.Activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cjeon.interactionandengagement.R;

import java.util.ArrayList;

public class SwipeRefreshActivity extends AppCompatActivity {

    ArrayList<Integer> listItems;
    ArrayAdapter<Integer> listAdapter;
    int number;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        listItems = new ArrayList<>();
        number = 0;
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        ListView listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(listAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this::addListViewItem);
    }

    public void addListViewItem() {
        listItems.add(number);
        listAdapter.notifyDataSetChanged();
        number += 1;
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_refresh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_refresh:
            case R.id.button_refresh:
                addListViewItem();
                return true;
        }
        return true;
    }
}
