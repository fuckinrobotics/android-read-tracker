package com.example.readtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.readtracker.ui.graph.GraphFragment;
import com.example.readtracker.ui.listbooks.ListBooksFragment;

import com.example.readtracker.ui.timerreading.TimerReadingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //loading the default fragment
        loadFragment(new TimerReadingFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.timer_reading_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_timer_reading:
                fragment = new TimerReadingFragment();
                break;

            case R.id.navigation_graph:
                fragment = new GraphFragment();
                break;

            case R.id.navigation_list_books:
                fragment = new ListBooksFragment();
                break;
        }

        return loadFragment(fragment);
    }
}