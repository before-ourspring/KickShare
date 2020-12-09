package com.ajou.kickshare.main.rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajou.kickshare.R;
import com.ajou.kickshare.initial.FirstActivity;

import static com.ajou.kickshare.main.rent.PointActivity.chargePoint;
import static com.ajou.kickshare.main.rent.RentActivity.remain;

public class ChargeSuccessActivity extends AppCompatActivity {

    private TextView mChargePoint, mRemainPoint;
    private Button mPointBtn, mHomeBtn;
    private ImageView mCloseBtn;

    RentActivity rentActivity = (RentActivity) RentActivity._RentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_success);

        mCloseBtn = findViewById(R.id.charge_success_img_back);
        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rentActivity.finish();
                Intent intent = new Intent(getApplicationContext(), RentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mChargePoint = findViewById(R.id.charge_success_tv_point);
        String s1 = Integer.toString(chargePoint);
        mChargePoint.setText(s1);

        mRemainPoint = findViewById(R.id.charge_success_tv_pointRemain);
        String s2 = Integer.toString(remain);
        mRemainPoint.setText(s2);

        mPointBtn = findViewById(R.id.charge_success_btn_check);
        mPointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PointActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mHomeBtn = findViewById(R.id.charge_success_btn_home);
        mHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rentActivity.finish();
                Intent intent = new Intent(getApplicationContext(), RentActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}