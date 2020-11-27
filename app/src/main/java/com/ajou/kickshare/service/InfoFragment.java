package com.ajou.kickshare.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajou.kickshare.R;

import static android.content.Context.MODE_PRIVATE;

public class InfoFragment extends Fragment {

    String phoneNumber;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserInfo", MODE_PRIVATE);
        phoneNumber = sharedPreferences.getString("PhoneNumber", "no");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        TextView mPhoneNumber = (TextView) view.findViewById(R.id.info_tv_phoneNumber);
        mPhoneNumber.setText(phoneNumber);
        System.out.println("hello"+phoneNumber);
        return view;
    }
}