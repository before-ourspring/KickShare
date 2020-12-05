package com.ajou.kickshare.main.rent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ajou.kickshare.R;
import com.ajou.kickshare.main.DBAccess.ExternalDBAdapter;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QrActivity extends AppCompatActivity {

    private IntentIntegrator mQrScan;
    private RentSuccessDialog rentSuccessDialog;
    private ExternalDBAdapter dbAdapter;
    private int qrKickBoardID = 0;
    public static boolean usingStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        mQrScan = new IntentIntegrator(this);
        mQrScan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        mQrScan.setPrompt("큐알코드를 화면에 인식시켜주세요!");
        mQrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "취소되었습니다", Toast.LENGTH_LONG).show();
                finish();
            } else {
//                Toast.makeText(this, "인식되었습니다", Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                dbAdapter = (ExternalDBAdapter) intent.getSerializableExtra("DB");
                if(dbAdapter.checkKickBoardID(qrKickBoardID)){
                    rentSuccessDialog = new RentSuccessDialog(this, mOkListnerBtn, mExitListenerBtn, "00:00");
                    rentSuccessDialog.show();
                    rentSuccessDialog.setCancelable(false);
                    setResult(RESULT_OK,intent);
                    MapActivity.availableKickshare--;
                    usingStatus = true;
                }else {
                    usingStatus = false;
                    Toast.makeText(this, "현재 킥보드가 사용중입니다.", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private View.OnClickListener mOkListnerBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            rentSuccessDialog.dismiss();
            finish();
        }
    };

    private View.OnClickListener mExitListenerBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            rentSuccessDialog.dismiss();
            finishAffinity();
        }
    };
}