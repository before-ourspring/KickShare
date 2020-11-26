package com.ajou.kickshare.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajou.kickshare.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 아주대학교 37.2833633, 127.0443218
        // 도서관 37.2814443, 127.0441587
        LatLng ajouUniv = new LatLng(37.2814443, 127.0441587);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ajouUniv));
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(17)); // 확대
        MarkerOptions markerOptions = new MarkerOptions().position(ajouUniv).title("아주대학교 중앙도서관");
        googleMap.addMarker(markerOptions);
    }
}