package com.r462.hammad.questionnaire.DAL;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.r462.hammad.questionnaire.Bo.Questionnaire;
import com.r462.hammad.questionnaire.MainActivity;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hammad on 4/28/2017.
 */

public class ManageQuestionnaireDAL {


    private static String DB_NAME = "Questionnaires";
    boolean checker = false;

    private static String QUESTIONNAIRE_NAME = "Records";
    private static String TYPE_OF_CRIME = "TypeOfCrime";
    ArrayList<Questionnaire> entries = new ArrayList<>();
    HashMap<String,Object> user = null;
    DatabaseReference MainType;
    DatabaseReference crimeType;
    DatabaseReference crimeVictim;
    DatabaseReference crimeTime;
    DatabaseReference crimeArea;
    DatabaseReference crimeDateAndDay;
    DatabaseReference noOfCriminal;
    DatabaseReference typeOfweapon;
    DatabaseReference facialFeature;
    DatabaseReference outfitOfCriminal;
    DatabaseReference criminalVehicle;
    DatabaseReference anyidentification;
    DatabaseReference treatmentByCriminal;
    DatabaseReference casualties;
    DatabaseReference MobileSnachingRelated;
    DatabaseReference VehicleSnachingRelated;
    String userId;
    private static Context context;

    List<String> value = new ArrayList<>();


    public FirebaseDatabase firebase;
    public DatabaseReference database;
    private DatabaseReference table;
    private boolean success = false;
    MainActivity mainActivity;

    public ManageQuestionnaireDAL(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference(DB_NAME);
        table = database.child(QUESTIONNAIRE_NAME);
    }

    public ManageQuestionnaireDAL() {
        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference(DB_NAME);
        table = database.child(QUESTIONNAIRE_NAME);
        MainType = database.push();
    }

    public void AddTypeOfCrime(final List<String> typeofcrimebo) {


        //crimeType=database.push().child("Question 1");
        crimeType = MainType.child("Type Of Crime");
        crimeType.setValue(typeofcrimebo, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });
    }

    public void AddVictim(List<String> victimBo) {
        crimeVictim = MainType.child("Crime Victim ");
        crimeVictim.setValue(victimBo, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });

    }

    public void AddCrimeTime(List<String> crimeTimeL) {
        crimeTime = MainType.child("Crime Time");
        crimeTime.setValue(crimeTimeL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });

    }

    public void AddCrimeData(List<String> crimeDataL) {

        crimeDateAndDay = MainType.child("Crime Date");
        crimeDateAndDay.setValue(crimeDataL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });

    }

    public void AddNoOfCriminal(List<String> noOfCriminalL) {
        noOfCriminal = MainType.child("No of Criminal");
        noOfCriminal.setValue(noOfCriminalL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });

    }

    public void AddTypeOfWeapon(List<String> typeofweaponL) {
        typeOfweapon = MainType.child("Type of Weapon");
        typeOfweapon.setValue(typeofweaponL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });

    }

    public void AddFacialCriminal(List<String> facialCriminalL) {

        facialFeature = MainType.child("Facial fearure");
        facialFeature.setValue(facialCriminalL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });
    }

    public void AddCriminalOutfit(List<String> CriminaloutfitL) {

        outfitOfCriminal = MainType.child("Outfit of criminal");
        facialFeature.setValue(CriminaloutfitL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });
    }

    public void AddcriminalVehicle(List<String> criminalVehicleL) {
        criminalVehicle = MainType.child("Criminal Vehicle");
        criminalVehicle.setValue(criminalVehicleL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });

    }

    public void AddanyidentificationOfVehicle(List<String> vechicleIdentification) {

        anyidentification = MainType.child(" Any Identification of Vehicle");
        anyidentification.setValue(vechicleIdentification, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });
    }

    public void AddtreatmentByCriminal(List<String> treatmentByCriminalL) {

        treatmentByCriminal = MainType.child(" Treatment By Criminal");
        treatmentByCriminal.setValue(treatmentByCriminalL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });
    }

    public void AddAnycasualties(List<String> casualtiesL) {

        casualties = MainType.child("Casualties");
        casualties.setValue(casualtiesL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });
    }

    public void AddMobileSnachingRelatedQuestion(List<String> MobileSnachingRealated) {

        MobileSnachingRelated = MainType.child("Mobile snaching Related");
        MobileSnachingRelated.setValue(MobileSnachingRealated, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });
    }

    public void AddVehicleSnachingRelatedQuestion(List<String> VehicleSnachingRelatedL) {

        VehicleSnachingRelated = MainType.child("Vehicle snaching Related");
        VehicleSnachingRelated.setValue(VehicleSnachingRelatedL, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });
    }

    public void AddcrimeLocation(List<String> crimeLocation) {
        crimeArea = MainType.child("Crime Location");
        crimeArea.setValue(crimeLocation, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                success = true;

            }
        });

    }


    //  retriveing data
    public void getDataFromDatabase(Context context) {
        final Context data = context;
        firebase = FirebaseDatabase.getInstance();
        database = firebase.getReference();
  /*     database.child(DB_NAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                Log.d("Count ", "" + dataSnapshot.getKey());
                Map<String, Object> user = null;
                while (items.hasNext()) {
                    DataSnapshot item = items.next();
                    user = (HashMap<String, Object>) item.getValue();
                   entries.add(new Questionnaire(Integer.parseInt(user.get("Type Of Crime").toString()), user.get("Crime Time").toString()));
                }
                Log.d("map1", user.toString());
                Log.d("map2",String.valueOf(user.get("Crime Location"))+"  "+String.valueOf(user.get("Criminal Vehicle")));
                new Questionnaire(String.valueOf(user.get("Type Of Crime")),String.valueOf(user.get("Crime Victim")),String.valueOf(user.get("Crime Time")),String.valueOf(user.get("Crime Date")),String.valueOf(user.get("No of Criminal")),String.valueOf(user.get("Type of Weapon")),String.valueOf(user.get("Facial fearure")),String.valueOf(user.get("Outfit of criminal")),String.valueOf(user.get("Criminal Vehicle")),String.valueOf(user.get("Any Identification of Vehicle")),String.valueOf(user.get("Treatment By Criminal")),String.valueOf(user.get("Casualties")),String.valueOf(user.get("Mobile snaching Related")),String.valueOf(user.get("Vehicle snaching Related")),String.valueOf(user.get("Crime Location")));
            }         entries.add(String.valueOf(user.get("")),user.get("").toString());
             Log.d("map2",user.toString());
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

*/
        // this is the end of retriving data part
        //this function is called form casualties...
        //  made extra class for retriving data also need to check that//

        database.child(DB_NAME).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getKey();
                Log.d("Count ", "" + value);
               // dataSnapshot.getValue().toString();
               // Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                //Log.d("data",""+ items);
                ArrayList<String> AnyIdentiferKey =  null;
                ArrayList<String> casualties = null;
                ArrayList<String> crimeDate = null;
                ArrayList<String> crimeLocation = null ;

                        //new ArrayList<String>();
                ArrayList<String> crimeTime =  null;
                ArrayList<String> crimeVictim = null;;
                ArrayList<String> crimeVehicle = null;
                ArrayList<String> MobileSnatchingRelated = null;
                ArrayList<String> noOfCriminal = null;
                ArrayList<String> typeOfCriminal = null;
                ArrayList<String> vehicleSnatchingRelated = null;
                ArrayList<String> typeOfWeapon = null;
                ArrayList<String> facialFeaturecriminal = null;
                ArrayList<String> treatByCriminal = null;
                ArrayList<String> identificationOfVehicle = null;
                //  while (items.hasNext()) {
                //   DataSnapshot item = items.next();

                AnyIdentiferKey = (ArrayList<String>) dataSnapshot.child("Any Identification of Vehicle").getValue();
                casualties = (ArrayList<String>) dataSnapshot.child("Casualties").getValue();
                crimeDate = (ArrayList<String>) dataSnapshot.child("Crime Date").getValue();
                crimeLocation = (ArrayList<String>) dataSnapshot.child("Crime Location").getValue();
                crimeTime = (ArrayList<String>) dataSnapshot.child("Crime Time").getValue();
                crimeVictim = (ArrayList<String>) dataSnapshot.child("Crime Victim ").getValue();
                crimeVehicle = (ArrayList<String>) dataSnapshot.child("Criminal Vehicle").getValue();
                MobileSnatchingRelated = (ArrayList<String>) dataSnapshot.child("Mobile snaching Related").getValue();
                noOfCriminal = (ArrayList<String>) dataSnapshot.child("No of Criminal").getValue();
                typeOfCriminal=(ArrayList<String>) dataSnapshot.child("Type Of Crime").getValue();
                typeOfWeapon = (ArrayList<String>) dataSnapshot.child("Type of Weapon").getValue();
                vehicleSnatchingRelated  =(ArrayList<String>) dataSnapshot.child("TVehicle snaching Related").getValue();
                facialFeaturecriminal =(ArrayList<String>)dataSnapshot.child("Facial fearure").getValue();
                treatByCriminal =(ArrayList<String>)dataSnapshot.child("Treatment By Criminal").getValue();
                identificationOfVehicle =(ArrayList<String>)dataSnapshot.child(" Any Identification of Vehicle").getValue();



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

              // mainActivity.markerOnMap(crimeDate,crimeTime,crimeLocation,typeOfCriminal);


                FileOutputStream fileOutputStream = null;
                String FILE_NAME = "data.csv";


                if(!checker){
                    try {

                        fileOutputStream = data.openFileOutput(FILE_NAME,Context.MODE_PRIVATE);

                        // fileOutputStream.write(typeOfCriminal.toString().getBytes());
                        //fileOutputStream.write(crimeDate.toString().getBytes());

                        for(String TC :typeOfCriminal  ){
                            fileOutputStream.write((TC+",").getBytes());
                        }
                        for (String DL:crimeDate){
                            fileOutputStream.write((DL+",").getBytes());
                        }
                        for(String CT :crimeTime) {
                            fileOutputStream.write((CT+",").getBytes());
                        }
                        for(int i=0;i<crimeLocation.size()-1;i++){
                            fileOutputStream.write((crimeLocation.get(i)+",").getBytes());
                        }
                       // for(String CL :crimeLocation) {
                          //  fileOutputStream.write((CL+",").getBytes());
                        //}
                        fileOutputStream.write('\n');
                        //fileOutputStream.write(crimeTime.toString().getBytes());
                        fileOutputStream.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    checker=true;
                }
                else{
                    try {

                        fileOutputStream = data.openFileOutput(FILE_NAME,Context.MODE_APPEND);

                            if(typeOfCriminal.size()>0){
                                for(String TC :typeOfCriminal  ){
                                    fileOutputStream.write((TC+",").getBytes());


                                    for (String DL:crimeDate){
                                        fileOutputStream.write((DL+",").getBytes());
                                    }
                                    for(String CT :crimeTime) {
                                        fileOutputStream.write((CT+",").getBytes());
                                    }
                                    for(int i=0;i<crimeLocation.size()-1;i++){
                                        fileOutputStream.write((crimeLocation.get(i) +",").getBytes());
                                    }

                                    fileOutputStream.write('\n');
                                }

                            }
                            else{
                                for(String TC :typeOfCriminal  ){
                                    fileOutputStream.write((TC+",").getBytes());

                                }
                                for(String TC :typeOfCriminal  ){
                                    fileOutputStream.write((TC+",").getBytes());
                                }
                                for (String DL:crimeDate){
                                    fileOutputStream.write((DL+",").getBytes());
                                }
                                for(String CT :crimeTime) {
                                    fileOutputStream.write((CT+",").getBytes());
                                }
                                for(int i=0;i<crimeLocation.size()-1;i++){
                                    fileOutputStream.write((crimeLocation.get(i) +",").getBytes());
                                }
                            }

                       // for(String CL :crimeLocation) {
                         //   fileOutputStream.write((CL+",").getBytes());
                        //}
                        if(typeOfCriminal.size()==0){
                            fileOutputStream.write('\n');
                        }
                        //fileOutputStream.write(crimeTime.toString().getBytes());
                        fileOutputStream.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }




            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

