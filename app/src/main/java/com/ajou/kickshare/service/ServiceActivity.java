package com.ajou.kickshare.service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.ajou.kickshare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ServiceActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private HelpFragment helpFragment = new HelpFragment();
    private InfoFragment infoFragment = new InfoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.service_frame_layout, homeFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.service_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch(item.getItemId()) {
                case R.id.menu_home:
                    transaction.replace(R.id.service_frame_layout, homeFragment).commitAllowingStateLoss();
                    break;
                case R.id.menu_help:
                    transaction.replace(R.id.service_frame_layout, helpFragment).commitAllowingStateLoss();
                    break;
                case R.id.menu_my:
                    transaction.replace(R.id.service_frame_layout, infoFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}