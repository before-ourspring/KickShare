package com.ajou.kickshare.main.rent;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ajou.kickshare.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RentSuccessDialog extends Dialog {

    private Button mOkButton, mExitButton;
    private TextView mStartTime;
    public String startTime;
    private View.OnClickListener mOkListenerBtn, mExitListenerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그의 꼭짓점이 짤리는부분 방지.
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        setContentView(R.layout.dialog_success_rent);

        mOkButton = findViewById(R.id.success_rent_btn_ok);
        mOkButton.setOnClickListener(mOkListenerBtn);
        mExitButton = findViewById(R.id.success_rent_btn_exit);
        mExitButton.setOnClickListener(mExitListenerBtn);

        long mNow = System.currentTimeMillis();
        Date mReDate = new Date(mNow);
        SimpleDateFormat mFormat = new SimpleDateFormat("HH:mm");
        String formatDate = mFormat.format(mReDate);

        mStartTime = findViewById(R.id.success_rent_tv_startTime);
        mStartTime.setText(formatDate);
    }

    public RentSuccessDialog(@NonNull Context context, View.OnClickListener mOkListenerBtn, View.OnClickListener mExitListenerBtn, String startTime) {
        super(context);
        //생성자에서 리스너 및 텍스트 초기화
        this.mOkListenerBtn = mOkListenerBtn;
        this.mExitListenerBtn = mExitListenerBtn;
        this.startTime = startTime;
    }
}
