package com.ajou.kickshare.main.admin;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.ajou.kickshare.R;

public class DistributeDialog extends Dialog {

    private Button mOkButton, mExitButton;
    private View.OnClickListener mOkListenerBtn, mExitListenerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그의 꼭짓점이 짤리는부분 방지.
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        setContentView(R.layout.dialog_distribute);

        mOkButton = findViewById(R.id.distribute_btn_ok);
        mOkButton.setOnClickListener(mOkListenerBtn);
        mExitButton = findViewById(R.id.distribute_btn_exit);
        mExitButton.setOnClickListener(mExitListenerBtn);
    }

    public DistributeDialog(@NonNull Context context, View.OnClickListener mOkListenerBtn, View.OnClickListener mExitListenerBtn) {
        super(context);
        //생성자에서 리스너 및 텍스트 초기화
        this.mOkListenerBtn = mOkListenerBtn;
        this.mExitListenerBtn = mExitListenerBtn;
    }
}
