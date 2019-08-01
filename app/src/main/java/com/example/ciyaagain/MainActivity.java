package com.example.ciyaagain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ciyaagain.adapter.MainFragmentStatePagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewPager = findViewById(R.id.main_view_pager);

        MainFragmentStatePagerAdapter mainFragmentStatePagerAdapter = new MainFragmentStatePagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainFragmentStatePagerAdapter);
        mainViewPager.setCurrentItem(0);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int position = 0;
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                position = 0;
                break;
            case R.id.navigation_communities:
                position = 1;
                break;
            case R.id.navigation_friendlist:
                position = 2;
                break;

            default:
                return false;
        }
        mainViewPager.setCurrentItem(position);
        return true;
    }
}
