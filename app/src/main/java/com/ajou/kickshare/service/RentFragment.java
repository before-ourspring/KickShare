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
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class RentFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView = null;
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rent, container, false);

        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng ajouEntrance = new LatLng(37.2800147,127.0436415);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ajouEntrance));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(17)); // 확대

        mMap.addMarker(new MarkerOptions().title("아주대학교 정문").position(new LatLng(37.2800147,127.0436415)));
        mMap.addMarker(new MarkerOptions().title("도서관").position(new LatLng(37.2814443, 127.0441587)));
        mMap.addMarker(new MarkerOptions().title("성호관").position(new LatLng(37.2827246, 127.045162)));
        mMap.addMarker(new MarkerOptions().title("팔달관").position(new LatLng(37.2843748, 127.0443452)));
        mMap.addMarker(new MarkerOptions().title("산학원").position(new LatLng(37.2863922, 127.045851)));
        mMap.addMarker(new MarkerOptions().title("다산관").position(new LatLng(37.2829729, 127.0474774)));
        mMap.addMarker(new MarkerOptions().title("원천관").position(new LatLng(37.2829669, 127.0434387)));
        mMap.addMarker(new MarkerOptions().title("동관").position(new LatLng(37.2838055, 127.0433987)));
        mMap.addMarker(new MarkerOptions().title("서관").position(new LatLng(37.2836885, 127.0426417)));
        mMap.addMarker(new MarkerOptions().title("율곡관").position(new LatLng(37.2822024, 127.0463244)));
        mMap.addMarker(new MarkerOptions().title("연암관").position(new LatLng(37.2821187, 127.0476976)));
        mMap.addMarker(new MarkerOptions().title("송재관").position(new LatLng(37.2808444, 127.0470122)));
        mMap.addMarker(new MarkerOptions().title("체육관").position(new LatLng(37.279969, 127.0451841)));
        mMap.addMarker(new MarkerOptions().title("아주대 병원").position(new LatLng(37.279430, 127.047742)));
        mMap.addMarker(new MarkerOptions().title("기숙사 식당").position(new LatLng(37.284719, 127.045536)));
        mMap.addMarker(new MarkerOptions().title("남제관").position(new LatLng(37.2841308, 127.0454224)));
        mMap.addMarker(new MarkerOptions().title("학생회관").position(new LatLng(37.2835771, 127.045156)));
        mMap.addMarker(new MarkerOptions().title("학군단").position(new LatLng(37.285220, 127.045055)));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                CameraPosition cameraPosition = new CameraPosition.Builder().target(marker.getPosition()).zoom(17).bearing(0).tilt(30).build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                marker.showInfoWindow();
                return true;
            }
        });
    }
}
