package com.ajou.kickshare.main.rent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ajou.kickshare.R;
import com.ajou.kickshare.main.DBAccess.AdapterList;
import com.ajou.kickshare.main.DBAccess.ExternalDBAdapter;
import com.ajou.kickshare.main.Distribution.KickBoardInfo;

import java.util.ArrayList;

public class RentActivity extends AppCompatActivity {

    private Button mPointButton, mMapButton, mQRButton;
    private ImageView mCloseBtn;
    private AdapterList abFactory = new AdapterList();
    private ExternalDBAdapter externalDBAdapter = (ExternalDBAdapter) abFactory.createAdapter("ExternalDBAdaptor");;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234 && resultCode == RESULT_OK){
            ExternalDBAdapter enDB = (com.ajou.kickshare.main.DBAccess.ExternalDBAdapter) data.getSerializableExtra("DB");
            externalDBAdapter = enDB;
        }
    }

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
        ExternalDBAdapter enDB = externalDBAdapter;
        final ArrayList<KickBoardInfo> finalKickBoardInfos = enDB.getKickBoardList();
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                intent.putExtra("KickboardList", finalKickBoardInfos);
                startActivity(intent);
            }
        });

        mQRButton = findViewById(R.id.menu_btn_qrcode);
        mQRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QrActivity.class);
                ExternalDBAdapter enDB = externalDBAdapter;
                intent.putExtra("DB", enDB);
                startActivityForResult(intent, 1234);

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