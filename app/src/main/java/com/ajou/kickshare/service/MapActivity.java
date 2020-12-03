package com.ajou.kickshare.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.ajou.kickshare.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView = null;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // SupportMapFragment을 통해 레이아웃에 만든 fragment의 ID를 참조하고 구글맵을 호출한다.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //getMapAsync must be called on the main thread.
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.icon_kb);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 80, 80, false);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));

        LatLng ajouEntrance = new LatLng(37.2800147,127.0436415);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ajouEntrance));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(17)); // 확대

        mMap.addMarker(markerOptions.title("아주대학교 정문").position(new LatLng(37.2800147,127.0436415)));
        mMap.addMarker(markerOptions.title("도서관").position(new LatLng(37.2814443, 127.0441587)));
        mMap.addMarker(markerOptions.title("성호관").position(new LatLng(37.2827246, 127.045162)));
        mMap.addMarker(markerOptions.title("팔달관").position(new LatLng(37.2843748, 127.0443452)));
        mMap.addMarker(markerOptions.title("산학원").position(new LatLng(37.2863922, 127.045851)));
        mMap.addMarker(markerOptions.title("다산관").position(new LatLng(37.2829729, 127.0474774)));
        mMap.addMarker(markerOptions.title("원천관").position(new LatLng(37.2829669, 127.0434387)));
        mMap.addMarker(markerOptions.title("동관").position(new LatLng(37.2838055, 127.0433987)));
        mMap.addMarker(markerOptions.title("서관").position(new LatLng(37.2836885, 127.0426417)));
        mMap.addMarker(markerOptions.title("율곡관").position(new LatLng(37.2822024, 127.0463244)));
        mMap.addMarker(markerOptions.title("연암관").position(new LatLng(37.2821187, 127.0476976)));
        mMap.addMarker(markerOptions.title("송재관").position(new LatLng(37.2808444, 127.0470122)));
        mMap.addMarker(markerOptions.title("체육관").position(new LatLng(37.279969, 127.0451841)));
        mMap.addMarker(markerOptions.title("아주대 병원").position(new LatLng(37.279430, 127.047742)));
        mMap.addMarker(markerOptions.title("기숙사 식당").position(new LatLng(37.284719, 127.045536)));
        mMap.addMarker(markerOptions.title("남제관").position(new LatLng(37.2841308, 127.0454224)));
        mMap.addMarker(markerOptions.title("학생회관").position(new LatLng(37.2835771, 127.045156)));
        mMap.addMarker(markerOptions.title("학군단").position(new LatLng(37.285220, 127.045055)));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                CameraPosition cameraPosition = new CameraPosition.Builder().target(marker.getPosition()).zoom(17).bearing(0).tilt(30).build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                marker.showInfoWindow();
                return true;
            }
        });

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                SharedPreferences sharedPreferences = getSharedPreferences("StationName", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String stationName = marker.getTitle();
                editor.putString("StationName", stationName); // key, value 이용하여 저장
                editor.apply(); // 최종 커밋

//                Toast.makeText(getActivity(), stationName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), EventActivity.class);
            }
        });
    }
}