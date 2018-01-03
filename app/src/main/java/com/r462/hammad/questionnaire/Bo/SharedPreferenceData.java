package com.r462.hammad.questionnaire.Bo;

import android.content.Context;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import static com.r462.hammad.questionnaire.DAL.SharedPreferences.PREFS_NAME;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_1;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_10;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_11;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_12;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_13;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_14;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_15;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_2;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_3;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_4;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_5;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_6;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_7;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_8;
import static com.r462.hammad.questionnaire.DAL.SharedPreferences.QUESTION_9;

/**
 * Created by hammad on 5/9/2017.
 */

public class SharedPreferenceData {



    public SharedPreferenceData() {
    }

    public List<String> getTypeOfCrime(Context context){
        List<String> crimeType;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences =context.getSharedPreferences(PREFS_NAME,0);
        if(sharedPreferences.contains(QUESTION_1)){
            String jasonValue= sharedPreferences.getString(QUESTION_1,"");
            Gson gson =new Gson();
            String[] crimeTypeItem =gson.fromJson(jasonValue,String[].class);
            crimeType = Arrays.asList(crimeTypeItem);
        }
        else{
            return  null;
        }
        return  crimeType;
    }

    public List<String> getVictim(Context context){
        List<String> crimeVictim;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_2)){
            String jasonFavourite = sharedPreferences.getString(QUESTION_2,"");
            Gson gson =new Gson();
            String[] victimItem =gson.fromJson(jasonFavourite,String[].class);
            crimeVictim = Arrays.asList(victimItem);
        }
        else{
            return  null;
        }
        return  crimeVictim;
    }
    public List<String> getmobileSnatching(Context context)
    {
        List<String> mobileSnatching;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences=context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if (sharedPreferences.contains(QUESTION_3)){
            String jasonValue=sharedPreferences.getString(QUESTION_3,"");
            Gson gson=new Gson();
            String[] mobileSnatchingItem=gson.fromJson(jasonValue,String[].class);
            mobileSnatching=Arrays.asList(mobileSnatchingItem);


        }
        else
        {
            return null;

        }
        return mobileSnatching;

    }
    public List<String> getVechileSnatching(Context context)
    {
        List<String> vechileSnatching;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences=context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if (sharedPreferences.contains(QUESTION_4)){
            String jasonValue=sharedPreferences.getString(QUESTION_4,"");
            Gson gson=new Gson();
            String[] vechileSnatchingItem=gson.fromJson(jasonValue,String[].class);
            vechileSnatching=Arrays.asList(vechileSnatchingItem);


        }
        else
        {
            return null;

        }
        return vechileSnatching;


    }
    public List<String> getCrimeLocation(Context context){
        List<String> crimelocation;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_5)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_5,"");
            Gson gson =new Gson();
            String[] crimelocationvalue =gson.fromJson(jasonFavourite, String[].class);
            crimelocation = Arrays.asList(crimelocationvalue);
        }
        else{
            return  null;
        }
        return  crimelocation;
    }
    public List<String> getTreatmentByCrimianl(Context context)
    {
        List<String> TreatmentByCrimianl;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences=context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if (sharedPreferences.contains(QUESTION_6)){
            String jasonValue=sharedPreferences.getString(QUESTION_6,"");
            Gson gson=new Gson();
            String[] TreatementbyCrimialitem=gson.fromJson(jasonValue,String[].class);
            TreatmentByCrimianl=Arrays.asList(TreatementbyCrimialitem);
            
        }
        else
        {
            return null;

        }
        return TreatmentByCrimianl;
    }
    public List<String> getnoOfCrimianls(Context context)
    {
        List<String> noOfCrimianls;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences=context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if (sharedPreferences.contains(QUESTION_7)){
            String jasonValue=sharedPreferences.getString(QUESTION_7,"");
            Gson gson=new Gson();
            String[] noOFCrimianlItem=gson.fromJson(jasonValue,String[].class);
            noOfCrimianls=Arrays.asList(noOFCrimianlItem);


        }
        else
        {
            return null;

        }
        return noOfCrimianls;


    }
    public List<String> getCriminalWepaon(Context context){
        List<String> crimialWeapon;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_8)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_8,"");
            Gson gson =new Gson();
            String[] criminalWeaponValue =gson.fromJson(jasonFavourite, String[].class);
            crimialWeapon = Arrays.asList(criminalWeaponValue);
        }
        else{
            return  null;
        }
        return  crimialWeapon;
    }
    public List<String> getCriminalVehicleIdent(Context context){
        List<String> criminalVehicleIdentification;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_9)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_9,"");
            Gson gson =new Gson();
            String[] criminalvehiclevalue =gson.fromJson(jasonFavourite, String[].class);
            criminalVehicleIdentification = Arrays.asList(criminalvehiclevalue);
        }
        else{
            return  null;
        }
        return  criminalVehicleIdentification;
    }
    public List<String> getCriminalVecicle(Context context){
        List<String> criminalVehicledUsed;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_10)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_10,"");
            Gson gson =new Gson();
            String[] criminalVech =gson.fromJson(jasonFavourite, String[].class);
            criminalVehicledUsed = Arrays.asList(criminalVech);
        }
        else{
            return  null;
        }
        return  criminalVehicledUsed;
    }
    public List<String> getCriminalOutfit(Context context){
        List<String> criminalOufit;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_11)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_11,"");
            Gson gson =new Gson();
            String[] crimianlOutfitValue =gson.fromJson(jasonFavourite, String[].class);
            criminalOufit = Arrays.asList(crimianlOutfitValue);
        }
        else{
            return  null;
        }
        return  criminalOufit;
    }
    public List<String> getCriminalFacialFeatures(Context context){
        List<String> crimianlFacial;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_12)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_12,"");
            Gson gson =new Gson();
            String[] crimialFacialValue =gson.fromJson(jasonFavourite, String[].class);
            crimianlFacial = Arrays.asList(crimialFacialValue);
        }
        else{
            return  null;
        }
        return  crimianlFacial;
    }
    public List<String> getCrimeTime(Context context){
        List<String> crimeTime;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_13)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_13,"");
            Gson gson =new Gson();
            String[] crimeTimeValue =gson.fromJson(jasonFavourite, String[].class);
            crimeTime = Arrays.asList(crimeTimeValue);
        }
        else{
            return  null;
        }
        return  crimeTime;
    }
    public List<String> getCrimeDate(Context context){
        List<String> crimeDate;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_14)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_14,"");
            Gson gson =new Gson();
            String[] crimeDateValue =gson.fromJson(jasonFavourite, String[].class);
            crimeDate = Arrays.asList(crimeDateValue);
        }
        else{
            return  null;
        }
        return  crimeDate;
    }
    public List<String> getCasulties(Context context){
        List<String> casulties;
        android.content.SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.contains(QUESTION_15)){
            java.lang.String jasonFavourite = sharedPreferences.getString(QUESTION_15,"");
            Gson gson =new Gson();
            String[] casultiesvalue =gson.fromJson(jasonFavourite, String[].class);
            casulties = Arrays.asList(casultiesvalue);
        }
        else{
            return  null;
        }
        return  casulties;
    }




}
