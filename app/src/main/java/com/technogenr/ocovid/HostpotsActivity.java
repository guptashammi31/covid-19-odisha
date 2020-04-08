package com.technogenr.ocovid;

import androidx.annotation.NonNull;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.technogenr.ocovid.common.Common;
import com.technogenr.ocovid.listeners.LocationListener;
import com.technogenr.ocovid.model.HostpotLocation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.technogenr.ocovid.util.LocationUtil;

public class HostpotsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int PROXIMITY_RADIUS = 10000;

    private DatabaseReference hostpotsRef;
    private FirebaseDatabase database;

    private LocationUtil locationUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostpots);
        database=FirebaseDatabase.getInstance();
        hostpotsRef=database.getReference(Common.hostspotsTable);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        boolean success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        this, R.raw.mapp));
        locationUtil=new LocationUtil(this, new LocationListener() {
            @Override
            public void locationResponse(LocationResult response) {
                mMap.animateCamera(CameraUpdateFactory.zoomTo(14));

                LatLng latLng = new LatLng(response.getLastLocation().getLatitude(), response.getLastLocation().getLongitude());
                mMap.setMyLocationEnabled(true);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                locationUtil.stopUpdateLocation();

            }
        });
        locationUtil.initializeLocation();
        hostpotsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    HostpotLocation hostpotLocation=snapshot.getValue(HostpotLocation.class);
                    LatLng sydney = new LatLng(hostpotLocation.getLat(), hostpotLocation.getLng());
                    mMap.addMarker(new MarkerOptions().position(sydney).title("Hostpot"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @androidx.annotation.NonNull String[] permissions, @androidx.annotation.NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        locationUtil.onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationUtil.stopUpdateLocation();
    }
}
