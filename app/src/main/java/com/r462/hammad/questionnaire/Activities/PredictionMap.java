package com.r462.hammad.questionnaire.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.r462.hammad.questionnaire.MainActivity;
import com.r462.hammad.questionnaire.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import fragments.typeOfCrime;

public class PredictionMap extends AppCompatActivity implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {

    ArrayList<LatLng> predictionPoint ;


    String result;
    String lat,lng;
    private GoogleMap map;
    GoogleApiClient mGoogleApiClient;
    DatabaseReference database;
    View mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction_map);


        buildGoogleApiClient();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.predcitionmap);
        mapView = mapFragment.getView();
        mapFragment.getMapAsync(this);




        // editText.setText(result);
       // Toast.makeText(this, " " + result, Toast.LENGTH_LONG).show();



        try {
            // Loading map
            initilizeMap();


        } catch (Exception e) {
            e.printStackTrace();
        }

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_prediction);
        FragmentManager fragmentManager = getSupportFragmentManager();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id) {
                    case R.id.home_Screen:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.predcition_map:
                        Intent predMap = new Intent(getApplicationContext(), PredictionMap.class);
                        startActivity(predMap);
                        break;
                    case R.id.report_crime:
                        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_predication, new typeOfCrime()).commit();
                }


                return true;


            }
        });


        // editText = (TextView) findViewById(R.id.editId);
           }

    private void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    private void initilizeMap() {
        if (map == null) {
            ((SupportMapFragment)getSupportFragmentManager().findFragmentById(
                    R.id.predcition_map)).getMapAsync(this);

            // check if map is created successfully or not
            if (map == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }





    }

    private void PredicationdataOnMAp() {




         try {




              JSONArray jsonArray = new JSONArray(result);



              // JSONArray array= jsonObject.getJSONArray(result);

            for(int i=0;i<jsonArray.length();i++){
                JSONObject object= jsonArray.getJSONObject(i);

               lng =  object.getString("crimeLng");
                lat=object.getString("crimeLtd");
                String typeOfCrime = object.getString("typeOfCrime");
                LatLng dataPoint = new LatLng(Double.valueOf(lng),Double.valueOf(lat));
                map.addMarker(new MarkerOptions().position(dataPoint).title(typeOfCrime.toString()));

                // items.add(object.getString("typeOfCrime")+" " +object.getString("crimeLng")+" "+object.getString("crimeLtd"));
                Toast.makeText(this," "+dataPoint,Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        }





    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        map.setMyLocationEnabled(true);

        PredicationdataOnMAp();
    }


    @Override
    public void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onStart() {
        super.onStart();



       result =  new GetData().data();

        Toast.makeText(this," "+result,Toast.LENGTH_LONG).show();

    }


}
