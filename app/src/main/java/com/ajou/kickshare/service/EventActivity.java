package com.ajou.kickshare.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajou.kickshare.R;

public class EventActivity extends AppCompatActivity {

    private ImageView mImageExitButton;
    private TextView mStationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mImageExitButton = findViewById(R.id.event_iv_exit);
        mImageExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mStationName = findViewById(R.id.event_tv_station);

        SharedPreferences sharedPreferences = getSharedPreferences("StationName", MODE_PRIVATE);
        String stationName = sharedPreferences.getString("StationName", "no");
        mStationName.setText(stationName);
    }
}