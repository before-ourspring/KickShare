package com.ajou.kickshare.main.rent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajou.kickshare.R;
import com.ajou.kickshare.main.DBAccess.AdapterList;
import com.ajou.kickshare.main.DBAccess.ExternalDBAdapter;
import com.ajou.kickshare.main.FareCalculation.FareCalculator;
import com.ajou.kickshare.main.FareCalculation.TotalStrategy;

public class PointActivity extends AppCompatActivity {

    private ImageView mCloseBtn;
    public static ImageView mUsing;
    private TextView mRemainPoint, mUsingPoint;
    static int remain = 5000, using = 0;
    static boolean check = false;
    static boolean usingStatus = false;
    String stRemain, stUsing;
    private FareCalculator fareCalculator = new FareCalculator();
    private TotalStrategy totalStrategy = (TotalStrategy) fareCalculator.createCalculator("Student");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

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