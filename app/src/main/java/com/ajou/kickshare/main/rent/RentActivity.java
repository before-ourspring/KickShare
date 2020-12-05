package com.ajou.kickshare.main.rent;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        AdapterList abFactory = new AdapterList();
        ExternalDBAdapter enDB = abFactory.creatEnternalDBAdapter("ExternalDB");
        ArrayList<KickBoardInfo> KickBoardInfos = new ArrayList<KickBoardInfo>();
        KickBoardInfos = enDB.getKickBoardList();

        mPointButton = findViewById(R.id.menu_btn_point);
        mPointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PointActivity.class);
                startActivity(intent);
            }
        });

        mMapButton = findViewById(R.id.menu_btn_map);
        final ArrayList<KickBoardInfo> finalKickBoardInfos = KickBoardInfos;
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                intent.putExtra("KickboardList", finalKickBoardInfos);
                startActivity(intent);
                finish();
            }
        });

        mQRButton = findViewById(R.id.menu_btn_qrcode);
        mQRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QrActivity.class);
                startActivity(intent);
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