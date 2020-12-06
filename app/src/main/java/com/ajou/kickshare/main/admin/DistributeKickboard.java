package com.ajou.kickshare.main.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.ajou.kickshare.R;
import com.ajou.kickshare.main.Distribution.DistributionPlanner;
import com.ajou.kickshare.main.Distribution.KickBoardStation;

import java.util.ArrayList;

public class DistributeKickboard extends AppCompatActivity {

    private ImageView mExitBtn;
    private Button mDistributeBtn;
    private DistributeDialog distributeDialog;
    private FrameLayout frameLayout;
    private ArrayList<KickBoardStation> kickBoardStations = new ArrayList<>();
    static boolean kbListDistribute = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribute_kickboard);

        mExitBtn = findViewById(R.id.admin_distribute_user_img_back);
        mExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        DistributionPlanner dbP = new DistributionPlanner();
        kickBoardStations = dbP.DistributionPlanner();

        mDistributeBtn = findViewById(R.id.admin_btn_request);
        mDistributeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // context에 getApplicationContext 넣으면 튕김 -> DistributeKickboard.this로 수정
                distributeDialog = new DistributeDialog(DistributeKickboard.this, mOkListenerBtn, mExitListenerBtn);
                distributeDialog.show();
                distributeDialog.setCancelable(false);
            }
        });

        frameLayout = findViewById(R.id.kickboardlist);
        if (kbListDistribute) {
            frameLayout.setVisibility(View.VISIBLE);
        }
        else frameLayout.setVisibility(View.GONE);
    }

    private View.OnClickListener mOkListenerBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            distributeDialog.dismiss();
            Toast.makeText(getApplicationContext(), "분배 요청이 완료되었습니다.", Toast.LENGTH_LONG).show();
            kbListDistribute = false;
            frameLayout.setVisibility(View.GONE);
        }
    };

    private View.OnClickListener mExitListenerBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            distributeDialog.dismiss();
        }
    };
}