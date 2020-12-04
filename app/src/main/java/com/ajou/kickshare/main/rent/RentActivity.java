package com.ajou.kickshare.main.rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ajou.kickshare.R;

public class RentActivity extends AppCompatActivity {

    private Button mPointButton, mMapButton, mQRButton;
    private ImageView mCloseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        mPointButton = findViewById(R.id.menu_btn_point);
        mPointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PointActivity.class);
                startActivity(intent);
            }
        });

        mMapButton = findViewById(R.id.menu_btn_map);
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        mQRButton = findViewById(R.id.menu_btn_qrcode);
        mQRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QrActivity.class);
                startActivity(intent);
            }
        });

        mCloseBtn = findViewById(R.id.rent_user_img_back);
        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}