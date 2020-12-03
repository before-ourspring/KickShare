package com.ajou.kickshare.initial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import com.ajou.kickshare.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MethodActivity extends AppCompatActivity {

    public static MethodActivity _MethodActivity;
    private ArrayList<Integer> imageList;
    private static final int DP = 24;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method);

        _MethodActivity = MethodActivity.this;

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

        mStartButton = findViewById(R.id.btn_start);

        Animation mAnimation = new AlphaAnimation(1, 0);
        mAnimation.setDuration(800);
        mAnimation.setInterpolator(new AccelerateInterpolator());
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.REVERSE);

        mStartButton.startAnimation(mAnimation);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MethodActivity.this, LoginActivity.class);
                startActivity(intent);
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