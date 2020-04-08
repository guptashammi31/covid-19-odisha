package com.technogenr.ocovid;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

   // private GoogleMap mMap;
    private GoogleMap mMap;
    double latitude;
    double longitude;
    private int PROXIMITY_RADIUS = 10000;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            checkLocationPermission();
        }

        //Check if Google Play Services Available or not
        if (!CheckGooglePlayServices()) {
            Log.d("onCreate", "Finishing test case since Google Play Services are not available");
            finish();
        }
        else {
            Log.d("onCreate","Google Play Services available.");
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private boolean CheckGooglePlayServices() {
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);
        if(result != ConnectionResult.SUCCESS) {
            if(googleAPI.isUserResolvableError(result)) {
                googleAPI.getErrorDialog(this, result,
                        0).show();
            }
            return false;
        }
        return true;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapp));

            if (!success) {
                //     Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            // Log.e(TAG, "Can't find style. Error: ", e);
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-34, 151)));

        //Initialize Google Play Services
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }


    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            //getting the latitude value
            double latitudeValue=mLastLocation.getLatitude();
            Log.d("value",""+latitudeValue);
            //getting the longitude value
            double longitudeValue=mLastLocation.getLongitude();
            double ulat=latitudeValue-4.0013569;
            double ulng=longitudeValue+4.0015142;



            // Other supported types include: MAP_TYPE_NORMAL,
            // MAP_TYPE_TERRAIN, MAP_TYPE_HYBRID and MAP_TYPE_NONE
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.setMyLocationEnabled(true);

            //Setting up the marker
            MarkerOptions marker= new MarkerOptions()
                    .title(
                            " sanjay swain, ")
                    .position(new LatLng(20.1016650 ,85.8012890))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker);
            MarkerOptions marker1= new MarkerOptions()
                    .title(
                            "dharanidhar Biswal")
                    .position(new LatLng( 20.112486,85.913245))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker1);
            MarkerOptions marker2= new MarkerOptions()
                    .title("Pradip  ku swain")

                    .position(new LatLng( 20.118474, 85.923906))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker2);
            MarkerOptions marker3= new MarkerOptions()
                    .title("Guru mushroom Centre Near Tolegate Pipili  ")
                    .position(new LatLng(20.139617,85.837109))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker3);
            MarkerOptions marker4= new MarkerOptions()
                    .title("kvk puri mushroom unit ")
                    .position(new LatLng(   19.927308 , 85.818384))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker4);
            MarkerOptions marker5= new MarkerOptions()
                    .title("Laxman Bastia")
                    .position(new LatLng( 20.035527 , 85.815264))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker5);
            MarkerOptions marker6= new MarkerOptions()
                    .title(
                            "Maa jagulei Mushroom Spawn unit Delang,Puri")
                    .position(new LatLng(  20.044262 , 85.760467))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker6);
            MarkerOptions marker7= new MarkerOptions()
                    .title(" Guru mushroom centre ")
                    .position(new LatLng(   20.136662 ,85.838660))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker7);
            MarkerOptions marker8= new MarkerOptions()
                    .title(
                            " Prasanta Spawn mushroom centre")
                    .position(new LatLng(20.096520,85.932349))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker8);
            MarkerOptions marker9= new MarkerOptions()
                    .title(
                            "Renuka mushroom,Chandanpur,Puri")
                    .position(new LatLng(19.876553,85.818577))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker9);

            MarkerOptions marker10= new MarkerOptions()
                    .title(
                            "Kalinga mushroom,Pipili,Odisha")
                    .position(new LatLng(20.114455,85.833411))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker10);
            MarkerOptions marker11= new MarkerOptions()
                    .title(
                            "rasmirekha mushroom ,jaishapatna,odisha")
                    .position(new LatLng(20.1422209,85.8352402))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker11);
            MarkerOptions marker12= new MarkerOptions()
                    .title(
                            "rekharani mushroom ,sanjit mohanty")
                    .position(new LatLng(20.139617,85.837109))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gmarker));
            mMap.addMarker(marker12);

            mMap.setTrafficEnabled(true);
        }
    }




    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("onLocationChanged", "entered");

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
      //  markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
        Toast.makeText(MapsActivity.this,"Your Current Location", Toast.LENGTH_LONG).show();

        Log.d("onLocationChanged", String.format("latitude:%.3f longitude:%.3f",latitude,longitude));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            Log.d("onLocationChanged", "Removing Location Updates");
        }
        Log.d("onLocationChanged", "Exit");

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }
}

