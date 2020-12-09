package com.ajou.kickshare.main.rent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ajou.kickshare.R;
import com.ajou.kickshare.main.DBAccess.AdapterList;
import com.ajou.kickshare.main.DBAccess.ExternalDBAdapter;
import com.ajou.kickshare.main.FareCalculation.FareCalculator;
import com.ajou.kickshare.main.FareCalculation.TotalStrategy;

import java.util.ArrayList;
import java.util.List;

import static com.ajou.kickshare.main.rent.RentActivity.chargeCancel;
import static com.ajou.kickshare.main.rent.RentActivity.remain;

public class PointActivity extends AppCompatActivity {

    private Button mChargeBtn;
    static int chargePoint;
    private ImageView mCloseBtn;
    public static ImageView mUsing;
    private TextView mRemainPoint, mUsingPoint;
    static int using = 0;

    ChargeActivity chargeActivity = (ChargeActivity) ChargeActivity._ChargeActivity;

    static boolean check = false;
    static boolean usingStatus = false;
    String stRemain, stUsing;
    private FareCalculator fareCalculator = new FareCalculator();
    private TotalStrategy totalStrategy = (TotalStrategy) fareCalculator.createCalculator("Student");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        System.out.println(chargeCancel);
        if (chargeCancel) chargeActivity.finish();

        final List<String> selectedItems = new ArrayList<String>();

        mChargeBtn = findViewById(R.id.point_btn_charge);
        mChargeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = new String[] {"1000", "5000", "10000", "15000", "20000", "25000", "30000"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(PointActivity.this);
                dialog.setTitle("충전할 포인트를 선택해주세요.")
                        .setSingleChoiceItems(items,0
                                ,new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        selectedIndex[0] = i;
                                    }
                                })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Toast.makeText(PointActivity.this, items[selectedIndex[0]], Toast.LENGTH_SHORT).show();
                                chargePoint = Integer.parseInt(items[selectedIndex[0]]);
                                System.out.println(chargePoint);

                                Intent intent = new Intent(getApplicationContext(), ChargeActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }).create().show();
            }
        });

        mCloseBtn = findViewById(R.id.point_img_back);
        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRemainPoint = findViewById(R.id.point_tv_point);
        stRemain = Integer.toString(remain);
        mRemainPoint.setText(stRemain);

        mUsingPoint = findViewById(R.id.point_tv_pointUsing);
        if(check) {
            stUsing = Integer.toString(totalStrategy.getFareStrategy(5));
        }else{
            stUsing = Integer.toString(using);
        }
        mUsingPoint.setText(stUsing);

        mUsing = (ImageView) findViewById(R.id.point_img_using);
        if (usingStatus) {
            System.out.println("Status TRUE");
            mUsing.setVisibility(View.VISIBLE);
        }
        else {
            System.out.println("Status FALSE");
            mUsing.setVisibility(View.GONE);
        }
    }
}