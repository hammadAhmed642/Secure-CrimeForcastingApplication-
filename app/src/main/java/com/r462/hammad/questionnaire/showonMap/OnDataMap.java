package com.r462.hammad.questionnaire.showonMap;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;
import com.r462.hammad.questionnaire.Bo.Location;
import com.r462.hammad.questionnaire.MainActivity;
import com.r462.hammad.questionnaire.Manifest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.SynchronousQueue;

import static android.R.attr.data;

/**
 * Created by Hammad Ahmed on 10/25/2017.
 */

public class OnDataMap extends MainActivity {


    FirebaseDatabase firebase;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<String> AnyIdentiferKey = null;
    ArrayList<String> casualties = null;
    ArrayList<String> crimeDate = null;
    private ArrayList<String> crimeLocation = null;
    int count;
    //new ArrayList<String>();
    ArrayList<String> crimeTime = null;
    ArrayList<String> crimeVictim = null;
    ;
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
    String Lat ="67.0689859" ;
    String Long ="67.0689859";

    public OnDataMap() {


    }


    public void dataOnMAp() {


        database.child("Questionnaires").addValueEventListener(new ValueEventListener() {
            @Override
            public  void onDataChange(DataSnapshot dataSnapshot) {


                    //stop progress bar here


                for ( DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    AnyIdentiferKey = (ArrayList<String>) dataSnapshot1.child("Any Identification of Vehicle").getValue();
                    casualties = (ArrayList<String>) dataSnapshot1.child("Casualties").getValue();
                    crimeDate = (ArrayList<String>) dataSnapshot1.child("Crime Date").getValue();
                    crimeLocation = (ArrayList<String>) dataSnapshot1.child("Crime Location").getValue();
                    if(crimeLocation!=null) {
                        Lat = crimeLocation.get(0).toString();
                        Long = crimeLocation.get(1).toString();
                        markerOnMap(Lat, Long);
                    }
                    crimeTime = (ArrayList<String>) dataSnapshot1.child("Crime Time").getValue();
                    crimeVictim = (ArrayList<String>) dataSnapshot1.child("Crime Victim ").getValue();
                    crimeVehicle = (ArrayList<String>) dataSnapshot1.child("Criminal Vehicle").getValue();
                    MobileSnatchingRelated = (ArrayList<String>) dataSnapshot1.child("Mobile snaching Related").getValue();
                    noOfCriminal = (ArrayList<String>) dataSnapshot1.child("No of Criminal").getValue();
                    typeOfCriminal = (ArrayList<String>) dataSnapshot1.child("Type Of Crime").getValue();
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
                }






            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void sendValue() {


    }

    // database.child("Questionnaires").addChildEventListener(new ChildEventListener() {
    // @Override
    //   public void onChildAdded(DataSnapshot dataSnapshot, String s) {
    //     String value = dataSnapshot.getKey();
    //   Log.d("Count ", "" + value);
    // dataSnapshot.getValue().toString();
    // Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
    //Log.d("data",""+ items);

    //  while (items.hasNext()) {
    //   DataSnapshot item = items.next();


    // ArrayList<Object>  data  = (ArrayList<Object>) dataSnapshot.getValue();

    //AnyIdentiferKey = (ArrayList<String>) dataSnapshot.child("Any Identification of Vehicle").getValue();
    // casualties = (ArrayList<String>) dataSnapshot.child("Casualties").getValue();
    //crimeDate = (ArrayList<String>) dataSnapshot.child("Crime Date").getValue();
    // dataSnapshot.child("Crime Location").getValue(Location.class);
    // crimeTime = (ArrayList<String>) dataSnapshot.child("Crime Time").getValue();
    // crimeVictim = (ArrayList<String>) dataSnapshot.child("Crime Victim ").getValue();
    // crimeVehicle = (ArrayList<String>) dataSnapshot.child("Criminal Vehicle").getValue();
    // MobileSnatchingRelated = (ArrayList<String>) dataSnapshot.child("Mobile snaching Related").getValue();
    // noOfCriminal = (ArrayList<String>) dataSnapshot.child("No of Criminal").getValue();
    //typeOfCriminal=(ArrayList<String>) dataSnapshot.child("Type Of Crime").getValue();
    // typeOfWeapon = (ArrayList<String>) dataSnapshot.child("Type of Weapon").getValue();
    // vehicleSnatchingRelated  =(ArrayList<String>) dataSnapshot.child("TVehicle snaching Related").getValue();
    // facialFeaturecriminal =(ArrayList<String>)dataSnapshot.child("Facial fearure").getValue();
    // treatByCriminal =(ArrayList<String>)dataSnapshot.child("Treatment By Criminal").getValue();
    // identificationOfVehicle =(ArrayList<String>)dataSnapshot.child(" Any Identification of Vehicle").getValue();


/*

                Log.d("AnyIdenfier",""+AnyIdentiferKey);
                Log.d("crimeVictim", "" + crimeVictim);
                Log.d("casualties", "" + casualties);
                Log.d("crimeDate",""+ crimeDate);
                Log.d("crimeLocation",""+crimeLocation);
                Log.d("crimeTime",""+crimeTime);
                Log.d("crimeVehicle",""+crimeVehicle);
                Log.d("MobileSnatchingRelated",""+MobileSnatchingRelated);
                Log.d("noCriminal",""+noOfCriminal);
                Log.d("typeOfCriminal",""+typeOfCriminal);
                Log.d("typeOfWeapon",""+typeOfWeapon);
                Log.d("vehicleSnatchedRelated",""+vehicleSnatchingRelated);
                Log.d("facialFeaturecriminal",""+facialFeaturecriminal);
                Log.d("treatByCriminal",""+treatByCriminal);
                Log.d("identificationOfVehicle","" +identificationOfVehicle);
*/

}