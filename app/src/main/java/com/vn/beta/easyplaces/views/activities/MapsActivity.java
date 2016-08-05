package com.vn.beta.easyplaces.views.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vn.beta.easyplaces.R;
import com.vn.beta.easyplaces.models.Post;
import com.vn.beta.easyplaces.views.fragments.Fragment_Home;

import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity {
    private GoogleMap mMap;
    private ArrayList<Post> posts = Fragment_Home.getPosts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mMap = mapFragment.getMap();
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        LatLng loc=null;
        for (int i=0;i<posts.size();i++){
            loc=new LatLng(Double.parseDouble(posts.get(i).getLatitude()),Double.parseDouble(posts.get(i).getLongitude()));
            mMap.addMarker(new MarkerOptions().position(loc).title(posts.get(i).getName()));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc,8f));
    }

}
