//package com.example.guest.grubbery.ui;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//
//import com.example.guest.grubbery.R;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.Places;
//
//public class MapActivity extends AppCompatActivity implements onConnectionFailedListener {
//    private GoogleApiClient mGoogleApiClient;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_map);
//
//        mGoogleApiClient = new GoogleApiClient
//                .Builder(this)
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
//                .enableAutoManage(this, this)
//                .build();
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult result) {
//        // An unresolvable error has occurred and a connection to Google APIs
//        // could not be established. Display an error message, or handle
//        // the failure silently
//
//     Log.d("MapActivity", "api failed!");
//    }
//}
