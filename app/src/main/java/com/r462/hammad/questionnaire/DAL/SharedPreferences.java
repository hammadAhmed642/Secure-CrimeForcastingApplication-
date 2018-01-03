package com.r462.hammad.questionnaire.DAL;

import android.content.Context;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hammad on 5/6/2017.
 */

public class SharedPreferences {
    public static final String PREFS_NAME = "Questionnaire";
    public static final String QUESTION_1 = "Type_Of_Crime";
    public static final String QUESTION_2 = "Victim";
    public static final String QUESTION_3 = "Mobile_Snatching_Related";
    public static final String QUESTION_4 = "Vehicle_Snatching_Related";
    public static final String QUESTION_5 = "Crime_Location";
    public static final String QUESTION_6 = "Treatment_By_Criminal";
    public static final String QUESTION_7 = "No_Of_Criminals";
    public static final String QUESTION_8 = "Criminal_Weapon";
    public static final String QUESTION_9 = "Criminal_Vehicle_Identification";
    public static final String QUESTION_10 = "Vehicle_Used_By_criminal ";
    public static final String QUESTION_11 = "Criminal_Outfit";
    public static final String QUESTION_12 = "Criminal_Facial_Features";
    public static final String QUESTION_13 = "Crime_Time";
    public static final String QUESTION_14 = "Crime_Date";
    public static final String QUESTION_15= "Casualties";



    public SharedPreferences() {
    }

    public void TypeofCrime(Context context, ArrayList<String> typeOfCrimeList) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();

        String jsonCrimeType = gson.toJson(typeOfCrimeList);
        editor.putString(QUESTION_1, jsonCrimeType);
        editor.commit();
    }
    public void CrimeVictim(Context context, List<String> CrimeVistim) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(CrimeVistim).toString();
        editor.putString(QUESTION_2, jsonFavorites);
        editor.commit();
    }
    public void setmobileSnaching(Context context, List<String> mobileSnachingRelated) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jasonValue = gson.toJson(mobileSnachingRelated);
        editor.putString(QUESTION_3, jasonValue);
        editor.commit();
    }



    public void setvehicleSnachingRealted(Context context, List<String> vehicleSnachingRelated) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jasonValue = gson.toJson(vehicleSnachingRelated);
        editor.putString(QUESTION_4, jasonValue);
        editor.commit();
    }
    public void setCrimeLocation(Context context, List<String> crimeLocation) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(crimeLocation).toString();
        editor.putString(QUESTION_5, jsonFavorites);
        editor.commit();
    }

    //TreatmentByCriminal Shared prefence seter and getters

    public void setTreatmentByCriminal(Context context,List<String> treatbycriminal)
    {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsontreatmentbyCriminal=gson.toJson(treatbycriminal);
        editor.putString(QUESTION_6,jsontreatmentbyCriminal);
        editor.commit();

    }


    public void setnoOfCriminals(Context context,List<String> noOFcriminals)
    {

        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jasonValue = gson.toJson(noOFcriminals);
        editor.putString(QUESTION_7, jasonValue);
        editor.commit();

    }
    public void setCriminalWeapon(Context context, List<String> crimialweapon) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(crimialweapon).toString();
        editor.putString(QUESTION_8, jsonFavorites);
        editor.commit();
    }


    public void setCriminalVehicleIdent(Context context, List<String> criminalVehicleIdent) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(criminalVehicleIdent).toString();
        editor.putString(QUESTION_9, jsonFavorites);
        editor.commit();
    }



    public void setCriminalVehicle(Context context, List<String> criminalVehicle) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(criminalVehicle).toString();
        editor.putString(QUESTION_10, jsonFavorites);
        editor.commit();
    }

    public void setCriminalOutfit(Context context, List<String> CriminalOutfit) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(CriminalOutfit).toString();
        editor.putString(QUESTION_11, jsonFavorites);
        editor.commit();
    }




    public void setCriminalFacialFeatures(Context context, List<String> criminalFacialFeature) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(criminalFacialFeature).toString();
        editor.putString(QUESTION_12, jsonFavorites);
        editor.commit();
    }



    public void setCrimeTime(Context context, List<String> crimeTime) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(crimeTime).toString();
        editor.putString(QUESTION_13, jsonFavorites);
        editor.commit();
    }


    public void setCrimeDate(Context context, List<String> crimeDate) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(crimeDate).toString();
        editor.putString(QUESTION_14, jsonFavorites);
        editor.commit();
    }


    public void setCasulties(Context context, List<String> casualties) {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, 0).edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(casualties).toString();
        editor.putString(QUESTION_15, jsonFavorites);
        editor.commit();
    }
}
