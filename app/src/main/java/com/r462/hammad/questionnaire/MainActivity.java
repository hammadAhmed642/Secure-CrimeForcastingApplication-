package com.r462.hammad.questionnaire;

import android.Manifest.permission;
import android.app.Activity;
import android.content.pm.PackageManager;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;


import android.Manifest;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.r462.hammad.questionnaire.Activities.CustomInfoWindow;
import com.r462.hammad.questionnaire.Activities.PredictionMap;
import com.r462.hammad.questionnaire.Activities.StatisticsCalculation;
import com.r462.hammad.questionnaire.DAL.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fragments.Victim;
import fragments.crimeArea;
import fragments.crimeDate;
import fragments.crimeTime;
import fragments.criminalFacialFeature;
import fragments.criminalOutfit;
import fragments.criminalVehicle;
import fragments.criminalVehicleIdentification;
import fragments.criminialWeapon;
import fragments.numbersOfcrimnal;
import fragments.treatmentByCriminal;
import fragments.typeOfCrime;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener, View.OnClickListener {

    private HeatmapTileProvider provider;
    LatLngBounds.Builder builder;
    FirebaseDatabase firebase;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    ArrayList<String> AnyIdentiferKey = null;
    ArrayList<String> casualties = null;
    ArrayList<String> crimeDate = null;
    private ArrayList<String> crimeLocation = null;
    int count;
    List<Marker> markersList = new ArrayList<Marker>();
    //new ArrayList<String>();
    ArrayList<String> crimeTime = null;
    ArrayList<String> crimeVictim = null;
    ArrayList<String> crimeVehicle = null;
    ArrayList<String> MobileSnatchingRelated = null;
    ArrayList<String> noOfCriminal = null;
    ArrayList<String> typeOfCriminal = null;
    ArrayList<String> vehicleSnatchingRelated = null;
    ArrayList<String> typeOfWeapon = null;
    ArrayList<String> facialFeaturecriminal = null;
    ArrayList<String> treatByCriminal = null;
    ArrayList<String> identificationOfVehicle = null;
    ArrayList<String> ArrLocation;
    ArrayList<String> specificLocationCrimeType= new ArrayList<>();
    String Lat = "67.0689859";
    String Long = "67.0689859";
    String[] permissionsRequired = new String[]{android.Manifest.permission.INTERNET,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION};
    private SharedPreferences permissionStatus;
    private static final int PERMISSION_CALLBACK_CONSTANT = 100;
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private boolean sentToSettings = false;
    public static int SPLASH_TIME_OUT = 4000;
    public static int REMOVE_VALUE = 0;
    public static int TYPE_OF_CRIME = 0;
    public static int VICTIM = 0;
    List<String> totalCrime = new ArrayList<>();
    List<Integer> particularCrimes = new ArrayList<>();
    List<Integer> allCrimes =new ArrayList<>();
    List<Float> allCrimeStats = new ArrayList<>();

    int type1ForSpecificArea=0;
    int type2ForSpecificArea=0;
    int type3ForSpecificArea=0;
    int type4ForSpecificArea=0;
    int type5ForSpecificArea=0;
    int type6ForSpecificArea=0;
    int type7ForSpecificArea=0;
    int type8ForSpecificArea=0;




    /* firebase initialization*/


    String crimeType = "";
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    GoogleApiClient mgoogleApiclient;
    LocationRequest mlocationRequest;
    Marker mCurrLocationMarker;
    Location loc;
    Marker marker;
    PolygonOptions mPolygon;
    GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastlocation;
    LocationRequest mLocationRequest;
    private static final String TAG = "MainActivity";
    View mapView;
    ArrayList<LatLng> heatmap = new ArrayList<LatLng>();
    public static ArrayList<String> genericArray = new ArrayList<String>();

    Victim victim;
    typeOfCrime typeofcrime;
    public static int UNIQUE_ID = 1;
    private static final LatLngBounds BOUNDS_KARACHI = new LatLngBounds(
            new LatLng(25.639801, 	24.746604 ), new LatLng(67.656942   , 	66.653982));

    private EditText mAutocompleteView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private PlacesAutoCompleteAdapter mAutoCompleteAdapter;
    private RecyclerView.ItemDecoration itemDecoration;
    ImageView delete;
    Circle circle;
    Marker m;
    int[] colors = {
            Color.rgb(102, 225, 0), // green
            Color.rgb(255, 0, 0)    // red
    };

    float[] startPoints = {
            0.2f, 1f
    };

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPolygon = new PolygonOptions();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildGoogleApiClient();
        intiMap();
        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_APN_SETTINGS);


        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            //requesting permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_APN_SETTINGS}, 1);
        } else {
            //permission is granted and you can change APN settings
        }

        database.keepSynced(true);

        mAutocompleteView = (EditText)findViewById(R.id.autocomplete_places);

        mAutocompleteView.setFocusableInTouchMode(false);
        mAutocompleteView.setFocusable(false);
        mAutocompleteView.setFocusableInTouchMode(true);
        mAutocompleteView.setFocusable(true);

        delete=(ImageView)findViewById(R.id.cross);

        mAutoCompleteAdapter =  new PlacesAutoCompleteAdapter(this, R.layout.searchview_adapter,
                mGoogleApiClient, BOUNDS_KARACHI, null);
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        mLinearLayoutManager=new LinearLayoutManager(this);
        itemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),mLinearLayoutManager.getOrientation());

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAutoCompleteAdapter);
        delete.setOnClickListener(this);

        mAutocompleteView.addTextChangedListener(new TextWatcher()
        {
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {


                if (!s.toString().equals("") && mGoogleApiClient.isConnected()) {
                    mAutoCompleteAdapter.getFilter().filter(s.toString());
                    //Toast.makeText(getApplicationContext(), "Connected",Toast.LENGTH_SHORT).show();
                }else if(!mGoogleApiClient.isConnected()){
                    Toast.makeText(getApplicationContext(), Constants.API_NOT_CONNECTED,Toast.LENGTH_SHORT).show();
                    Log.e(Constants.PlacesTag,Constants.API_NOT_CONNECTED);
                }

                if(mAutocompleteView.getText().toString().trim().length() == 0){
                    circle.setVisible(false);
                    mRecyclerView.setVisibility(View.INVISIBLE);
                    for(Marker m : markersList){

                          mMap.addMarker(new MarkerOptions().position(m.getPosition()).title(m.getTitle()).snippet("Date and Time "+m.getSnippet()));
                    }
                }
                if(mAutocompleteView.getText().toString().trim().length() != 0){
                    mRecyclerView.setVisibility(View.VISIBLE);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view,  int position) {
                        final PlacesAutoCompleteAdapter.PlaceAutocomplete item = mAutoCompleteAdapter.getItem(position);
                        final String placeId = String.valueOf(item.placeId);
                        Log.i("placeId",placeId);
                        Log.i("TAG", "Autocomplete item selected: " + item.description);
                        /*
                             Issue a request to the Places Geo Data API to retrieve a Place object with additional details about the place.
                         */

                        PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                                .getPlaceById(mGoogleApiClient, placeId);
                        placeResult.setResultCallback(new ResultCallback<PlaceBuffer>() {
                            @Override
                            public void onResult(PlaceBuffer places) {
                                if(places.getCount()==1){

                                    LatLng latLng = places.get(0).getLatLng();
                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                    mMap.animateCamera(CameraUpdateFactory.zoomTo(13));
                                    //mRecyclerView.setVisibility(R.id.ma
                                    mRecyclerView.removeItemDecoration(itemDecoration);

                                    mMap.clear();

                                     circle = mMap.addCircle(
                                            new CircleOptions()
                                                    .center(latLng)
                                                    .radius(5000)
                                                    .strokeWidth(15)
                                                    .fillColor(Color.argb(34,54,158,5))
                                    );

                                     if(!heatmap.isEmpty()){
                                         int i=0;
                                             for(LatLng l : heatmap){
                                                 i++;
                                                 if(contains(l)){
                                                    int value =  heatmap.indexOf(l);
                                                     //Toast.makeText(getApplicationContext(),"" +"  :   " + l,Toast.LENGTH_SHORT).show();
                                                    Marker ma =  markersList.get(value);
                                                     mMap.addMarker(new MarkerOptions().position(l).title(ma.getTitle()).snippet(ma.getSnippet()));



                                                     if(ma.getTitle().equalsIgnoreCase("[Mobile snatching]")){
                                                         type1ForSpecificArea = type1ForSpecificArea+1;

                                                     }
                                                     else if(ma.getTitle().equalsIgnoreCase("[Blast]")){

                                                         type2ForSpecificArea = type2ForSpecificArea+1;

                                                     }
                                                     else  if(ma.getTitle().equalsIgnoreCase("[Robbery]")){

                                                         type3ForSpecificArea = type3ForSpecificArea+1;

                                                     }
                                                     else if(ma.getTitle().equalsIgnoreCase("[Murder]")){

                                                         type4ForSpecificArea = type4ForSpecificArea+1;

                                                     }
                                                     else if(ma.getTitle().equalsIgnoreCase("[Sexual harasment]")){

                                                         type5ForSpecificArea = type5ForSpecificArea+1;

                                                     }
                                                     else if(ma.getTitle().equalsIgnoreCase("[Vandalism]")){

                                                         type6ForSpecificArea = type6ForSpecificArea+1;

                                                     }
                                                     else if(ma.getTitle().equalsIgnoreCase("[Kidnapping]")){

                                                         type7ForSpecificArea = type7ForSpecificArea+1;

                                                     }
                                                     else if(ma.getTitle().equalsIgnoreCase("[Vehicle Snatching]")){

                                                         type8ForSpecificArea = type8ForSpecificArea+1;

                                                     }
                                                 }
                                             }
                                         //addHeatMap();

                                         particularCrimes.add(type1ForSpecificArea);
                                         particularCrimes.add(type2ForSpecificArea);

                                         particularCrimes.add(type3ForSpecificArea);

                                         particularCrimes.add(type4ForSpecificArea);

                                         particularCrimes.add(type5ForSpecificArea);

                                         particularCrimes.add(type6ForSpecificArea);
                                         particularCrimes.add(type7ForSpecificArea);

                                         particularCrimes.add(type8ForSpecificArea);


                                     }



                                    for(int crime=0;crime<particularCrimes.size();crime++){


                                         float first = particularCrimes.get(crime);
                                        float second =allCrimes.get(crime);
                                        float divide =first/second;
                                    allCrimeStats.add(divide*100);




                                     }

                                   //  CustomInfoWindow adapter = new CustomInfoWindow(MainActivity.this);
                                   // mMap.setInfoWindowAdapter(adapter);
                                   // adapter.getInfoContents(marker);


                                    for(int ten=0 ;ten<10;ten++) {
                                        Toast.makeText(getApplication(), "circle:" + allCrimeStats, Toast.LENGTH_LONG).show();
                                    }




                                    mRecyclerView.setVisibility(View.INVISIBLE);


                                    //Do the things here on Click.....
                                    Toast.makeText(getApplicationContext(),String.valueOf(places.get(0).getLatLng()),Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getApplicationContext(), Constants.SOMETHING_WENT_WRONG,Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


                        Log.i("TAG", "Clicked: " + item.description);
                        Log.i("TAG", "Called getPlaceById to get Place details for " + item.placeId);
                    }

                })
        );




        /*final SearchView searchView = (SearchView) findViewById(R.id.searchView);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                try {
                    search(query);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // search(newText);
                return false;
            }
        });

*/

        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new reportView()).commit();


        // recent bottomnavigation View//
       BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
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
                      Intent predMap=new Intent(getApplicationContext(), PredictionMap.class);
                        startActivity(predMap);
                        break;
                    case R.id.report_crime:
                        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new typeOfCrime()).commit();
                }


                return true;


            }
        });


    }
    public boolean contains(LatLng position) {
        LatLng center = circle.getCenter();
        double radius = circle.getRadius();
        float distance = distanceBetween(position, center);
        return distance < radius;
    }

    public static float distanceBetween(LatLng first, LatLng second) {
        float[] distance = new float[1];
        Location.distanceBetween(first.latitude, first.longitude, second.latitude, second.longitude, distance);
        return distance[0];
    }


    protected synchronized void buildGoogleApiClient()
    {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(Places.GEO_DATA_API)
                .build();
       // mgoogleApiclient.connect();
        //OnDataMap onDataMap = new OnDataMap();

    }


/*
    private void search(String location) throws IOException {
        Geocoder geocoder = new Geocoder(this);

        List<Address> list = geocoder.getFromLocationName(location, 1);
        if (location == null) {


            //if the search bar is empty

        }
        android.location.Address address = list.get(0);
        String locality = address.getLocality();
        String country = address.getCountryName();
        Toast.makeText(this, locality, Toast.LENGTH_LONG).show();
        double lat = address.getLatitude();
        double lon = address.getLongitude();

        LatLng latLng = new LatLng(lat, lon);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13));


    }*/


    private void intiMap() {
        /*Google Map fragment*/
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapView = mapFragment.getView();
        mapFragment.getMapAsync(this);
        dataOnMAp();


    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        //mLocationRequest.setInterval(5000);
        //mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.v("Google API Callback", "Connection Suspended");
        Log.v("Code", String.valueOf(i));

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.v("Google API Callback","Connection Failed");
        Log.v("Error Code", String.valueOf(connectionResult.getErrorCode()));
        Toast.makeText(this, Constants.API_NOT_CONNECTED,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastlocation = location;
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mGoogleApiClient.isConnected() && !mGoogleApiClient.isConnecting()){
            Log.v("Google API","Connecting");
            mGoogleApiClient.connect();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        if(mGoogleApiClient.isConnected()){
            Log.v("Google API","Dis-Connecting");
            mGoogleApiClient.disconnect();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);
        if (mapView != null &&
                mapView.findViewById(Integer.parseInt("1")) != null) {
            // Get the button view
            View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
            // and next place it, on bottom right (as Google Maps app)
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)
                    locationButton.getLayoutParams();
            // position on right bottom
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            layoutParams.setMargins(0, 180, 20, 30);
        }
        try {
            // Customise the styling of the base map using a JSON object defined
              // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
//        provider.setRadius(ALT_HEATMAP_RADIUS);


      //  DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Questionnaires");

        //Toast.makeText(getApplication(), "" + reference.toString(), Toast.LENGTH_LONG).show();

    }
    public void dataOnMAp() {

        database.child("Questionnaires").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //stop progress bar here
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    AnyIdentiferKey = (ArrayList<String>) dataSnapshot1.child("Any Identification of Vehicle").getValue();
                    casualties = (ArrayList<String>) dataSnapshot1.child("Casualties").getValue();
                    crimeDate = (ArrayList<String>) dataSnapshot1.child("Crime Date").getValue();
                    crimeLocation = (ArrayList<String>) dataSnapshot1.child("Crime Location").getValue();
                    typeOfCriminal = (ArrayList<String>) dataSnapshot1.child("Type Of Crime").getValue();
                    noOfCriminal = (ArrayList<String>) dataSnapshot1.child("No of Criminal").getValue();
                    crimeTime = (ArrayList<String>) dataSnapshot1.child("Crime Time").getValue();
                    if (crimeLocation != null) {

                        Lat = crimeLocation.get(0).toString();
                        Long = crimeLocation.get(1).toString();
                        LatLng latLng = new LatLng(Double.valueOf(Lat), Double.valueOf(Long));

                        String value;
                        marker = mMap.addMarker(new MarkerOptions().position(latLng).title(value=typeOfCriminal.toString()).snippet("Date"+crimeDate  + "Time"+crimeTime));
                            markersList.add(marker);
                           heatmap.add(latLng);
                            totalCrime.add(value);






                    }



                    crimeVictim = (ArrayList<String>) dataSnapshot1.child("Crime Victim ").getValue();
                    crimeVehicle = (ArrayList<String>) dataSnapshot1.child("Criminal Vehicle").getValue();
                    MobileSnatchingRelated = (ArrayList<String>) dataSnapshot1.child("Mobile snaching Related").getValue();
                    typeOfWeapon = (ArrayList<String>) dataSnapshot1.child("Type of Weapon").getValue();
                    vehicleSnatchingRelated = (ArrayList<String>) dataSnapshot1.child("TVehicle snaching Related").getValue();
                    facialFeaturecriminal = (ArrayList<String>) dataSnapshot1.child("Facial fearure").getValue();
                    treatByCriminal = (ArrayList<String>) dataSnapshot1.child("Treatment By Criminal").getValue();
                    identificationOfVehicle = (ArrayList<String>) dataSnapshot1.child(" Any Identification of Vehicle").getValue();


                    Log.d("AnyIdenfier", "" + AnyIdentiferKey);
                    Log.d("crimeVictim", "" + crimeVictim);
                    Log.d("casualties", "" + casualties);
                    Log.d("crimeDate", "" + crimeDate);
                    Log.d("crimeLocation", "" + crimeLocation);
                    // for(int i=0;i<crimeLocation.size()-1;i++){


                    Log.d("crimeTime", "" + crimeTime);
                    Log.d("crimeVehicle", "" + crimeVehicle);
                    Log.d("MobileSnatchingRelated", "" + MobileSnatchingRelated);
                    Log.d("noCriminal", "" + noOfCriminal);
                    Log.d("typeOfCriminal", "" + typeOfCriminal);
                    Log.d("typeOfWeapon", "" + typeOfWeapon);
                    Log.d("vehicleSnatchedRelated", "" + vehicleSnatchingRelated);
                    Log.d("facialFeaturecriminal", "" + facialFeaturecriminal);
                    Log.d("treatByCriminal", "" + treatByCriminal);
                    Log.d("identificationOfVehicle", "" + identificationOfVehicle);




                }

              //

                StatisticsCalculation statisticsCalculation = new StatisticsCalculation();

                addHeatMap();
                allCrimes=statisticsCalculation.stats((ArrayList<String>) totalCrime);
               Toast.makeText(getApplication(),""+allCrimes ,Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    public void markerOnMap(String Latitude, String Longitde) {

        if (Latitude != null && Longitde != null) {
            Double Lat = Double.valueOf(Latitude);
            Double Long = Double.valueOf(Longitde);
            //Latitude= Double.valueOf(Crime_Location.toString());
            // Longitude= Double.valueOf(Crime_Location.get(1).toString());
            // for(int i=0;i<crimeLocation.size()-1;i++){
            //  Latitude= Double.valueOf(crimeLocation.get(0).toString());
            //  Longitude= Double.valueOf(crimeLocation.get(1).toString());

            // }
            //  Toast.makeText(this,""+ crimeLocation.toString(),Toast.LENGTH_LONG).show();
            //Toast.makeText(this,""+ user.get(1).getBytes(),Toast.LENGTH_LONG).show();

            //    Double latitude = Double.valueOf(crimeLocation.get(0));
            //  Double longitute =  Double.valueOf(crimeLocation.get(1));
           // LatLng latLng = new LatLng(Lat, Long);

           // mMap.addMarker(new MarkerOptions().position(latLng).title("crime"));
        }

    }

    private void goToLocation(double lat, double lon) {

        LatLng ll = new LatLng(lat, lon);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        mMap.moveCamera(update);
    }

    public void onFragmentInteraction(String Type) {

        crimeType = Type;
        Toast.makeText(this, Type, Toast.LENGTH_SHORT).show();


    }

    public void backTypeofCrimeClick(View view) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
        // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new reportView()).addToBackStack(null).commit();
    }

    public void backVictimClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new typeOfCrime()).addToBackStack(null).commit();
    }

    public void backCrimeAreaClick(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Victim()).addToBackStack(null).commit();
    }

    public void backCrimeTime(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new crimeArea()).addToBackStack(null).commit();
    }

    public void backCrimeDateClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new crimeTime()).addToBackStack(null).commit();

    }

    public void backNumberOfCriminalClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new crimeDate()).addToBackStack(null).commit();
    }

    public void backWeaponClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new numbersOfcrimnal()).addToBackStack(null).commit();

    }

    public void backFacialFeatureClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new criminialWeapon()).addToBackStack(null).commit();

    }

    public void backOutfitCriminalClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new criminalFacialFeature()).addToBackStack(null).commit();

    }

    public void backCriminalVehicleClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new criminalOutfit()).addToBackStack(null).commit();

    }

    public void backCriminalVehicleIdentificationClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new criminalVehicle()).addToBackStack(null).commit();
    }

    public void backTreatmentByCriminalClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new criminalVehicleIdentification()).addToBackStack(null).commit();

    }

    public void backCasualtiesByCriminalClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new treatmentByCriminal()).addToBackStack(null).commit();


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //premission granted by user
                } else {
                    //permission denied by user
                }
            }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onClick(View v) {
        if(v==delete){
            mAutocompleteView.setText("");
        }
    }

    private static final int ALT_HEATMAP_RADIUS = 10;


    //heatmap
    private void addHeatMap() {



        List<LatLng> list = null;

        // Get the data: latitude/longitude positions of police stations.
        try {
            list = readItems(R.raw.police_stations);
        } catch (JSONException e) {
            Toast.makeText(this, "Problem reading list of locations.", Toast.LENGTH_LONG).show();
        }


        Gradient gradient = new Gradient(colors, startPoints);
        // Create a heat map tile provider, passing it the latlngs of the police stations.
        HeatmapTileProvider provider = new HeatmapTileProvider.Builder().data(heatmap).gradient(gradient).build();
        // Add a tile overlay to the map, using the heat map tile provider.
        provider.setRadius(40);
        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(provider));
    }
    /**
     * Read the data (locations of police stations) from raw resources.
     */
    private ArrayList<LatLng> readItems(int resource) throws JSONException {
        ArrayList<LatLng> list = new ArrayList<LatLng>();
        InputStream inputStream = getResources().openRawResource(resource);
        @SuppressWarnings("resource")
        String json = new Scanner(inputStream).useDelimiter("\\A").next();
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            double lat = object.getDouble("lat");
            double lng = object.getDouble("lng");
            list.add(new LatLng(lat, lng));
        }

        return list;
    }



}












