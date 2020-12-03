package com.ajou.kickshare.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ajou.kickshare.R;
import com.ajou.kickshare.main.rent.RentActivity;
import com.ajou.kickshare.main.help.HelpActivity;

public class MainActivity extends AppCompatActivity {

    String phoneNumber;
    private Button mRentButton, mReturnButton, mHelpButton, mInfoButton;
    private TextView mPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        phoneNumber = sharedPreferences.getString("PhoneNumber", "no");

        mPhoneNumber = findViewById(R.id.main_tv_phoneNumber);
        mPhoneNumber.setText(phoneNumber);

        mRentButton = findViewById(R.id.main_btn_rent);
        mRentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RentActivity.class);
                startActivity(intent);
            }
        });

        mReturnButton = findViewById(R.id.main_btn_return);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "반납", Toast.LENGTH_SHORT).show();
            }
        });

        mHelpButton = findViewById(R.id.main_btn_help);
        mHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(intent);
            }
        });

        mInfoButton = findViewById(R.id.main_btn_myinfo);
        mInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "내 정보 관리", Toast.LENGTH_SHORT).show();
            }
        });
    }
}