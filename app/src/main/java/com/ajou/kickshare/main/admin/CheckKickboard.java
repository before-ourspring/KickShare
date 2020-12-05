package com.ajou.kickshare.main.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajou.kickshare.R;

public class CheckKickboard extends AppCompatActivity {

    private ImageView mImageExitButton;
    private TextView mStationName;
    private ImageView mCloseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_kickboard);

        mStationName = findViewById(R.id.check_kickboard_tv_station);

        SharedPreferences sharedPreferences = getSharedPreferences("StationName", MODE_PRIVATE);
        String stationName = sharedPreferences.getString("StationName", "no");
        mStationName.setText(stationName);

        mCloseBtn = findViewById(R.id.check_kickboard_img_back);
        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}