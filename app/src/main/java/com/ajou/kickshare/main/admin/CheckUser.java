package com.ajou.kickshare.main.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ajou.kickshare.R;

public class CheckUser extends AppCompatActivity {

    private ImageView mCloseBtn;
    private Button mRequestBtn1, mStopBtn1, mRequestBtn2, mStopBtn2, mRequestBtn3, mStopBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_user);

        mCloseBtn = findViewById(R.id.check_user_img_back);
        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRequestBtn1 = findViewById(R.id.check_user_btn_request1);
        mRequestBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "요청되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        mRequestBtn2 = findViewById(R.id.check_user_btn_request2);
        mRequestBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "요청되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        mRequestBtn3 = findViewById(R.id.check_user_btn_request3);
        mRequestBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "요청되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        mStopBtn1 = findViewById(R.id.check_user_btn_stop1);
        mStopBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "중지되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        mStopBtn2 = findViewById(R.id.check_user_btn_stop2);
        mStopBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "중지되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        mStopBtn3 = findViewById(R.id.check_user_btn_stop3);
        mStopBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "중지되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}