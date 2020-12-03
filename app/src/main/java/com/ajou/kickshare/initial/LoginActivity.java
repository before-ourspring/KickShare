package com.ajou.kickshare.initial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ajou.kickshare.R;
import com.ajou.kickshare.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    FirstActivity firstActivity = (FirstActivity) FirstActivity._MainActivity;
    MethodActivity methodActivity = (MethodActivity) MethodActivity._MethodActivity;

    private EditText mEditNumber;
    private Button mLoginButton;

    public ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditNumber = findViewById(R.id.login_et_number);

//        EditText mEditPassword = findViewById(R.id.login_et_password);

        mLoginButton = findViewById(R.id.login_btn);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String phoneNumber = mEditNumber.getText().toString(); // 사용자가 입력한 저장할 데이터
                editor.putString("PhoneNumber", phoneNumber); // key, value 이용하여 저장
                editor.apply(); // 최종 커밋

                showProgressDialog();
                // System.out.println("hello1" + phoneNumber);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                firstActivity.finish();
                methodActivity.finish();
                finish();
            }
        });
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}