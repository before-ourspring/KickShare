package com.ajou.kickshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MethodActivity extends AppCompatActivity {

    private ArrayList<Integer> imageList;
    private static final int DP = 24;

    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method);

        this.initializeData();

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setClipToPadding(false);

        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        viewPager.setAdapter(new ViewPagerAdapter(this, imageList));

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);

        btn_start = findViewById(R.id.btn_start);

        Animation mAnimation = new AlphaAnimation(1, 0);
        mAnimation.setDuration(800);
        mAnimation.setInterpolator(new AccelerateInterpolator());
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.REVERSE);
        btn_start.startAnimation(mAnimation);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MethodActivity.this, ServiceActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void initializeData()
    {
        imageList = new ArrayList();

        imageList.add(R.drawable.ks_1);
        imageList.add(R.drawable.ks_2);
        imageList.add(R.drawable.ks_3);
        imageList.add(R.drawable.ks_4);
    }
}