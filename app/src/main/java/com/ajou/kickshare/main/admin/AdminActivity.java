package com.ajou.kickshare.main.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ajou.kickshare.R;

public class AdminActivity extends AppCompatActivity {

    private Button mCheckUserBtn, mCheckKickboardBtn, mDistributeBtn;
    private DistributeDialog distributeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mCheckUserBtn = findViewById(R.id.admin_btn_check_user);
        mCheckUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CheckUser.class);
                startActivity(intent);
            }
        });

        mCheckKickboardBtn = findViewById(R.id.admin_btn_check_kickboard);
        mCheckKickboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminMap.class);
                startActivity(intent);
            }
        });

        mDistributeBtn = findViewById(R.id.admin_btn_distribute);
        mDistributeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // context에 getApplicationContext 넣으면 튕김 -> AdminActivity.this로 수정
                distributeDialog = new DistributeDialog(AdminActivity.this, mOkListnerBtn, mExitListenerBtn);
                distributeDialog.show();
                distributeDialog.setCancelable(false);
            }
        });
    }

    private View.OnClickListener mOkListnerBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            distributeDialog.dismiss();
            Toast.makeText(getApplicationContext(), "분배 요청이 완료되었습니다.", Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener mExitListenerBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            distributeDialog.dismiss();
        }
    };
}