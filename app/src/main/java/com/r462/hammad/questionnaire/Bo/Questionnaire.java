package com.r462.hammad.questionnaire.Bo;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



/**
 * Created by hammad on 4/28/2017.
 */

public class Questionnaire  {
    int CrTime;
    String ToCrime;
    private ArrayList<String> typeOfCrime ;
    private  ArrayList<String>  Victim;
    private  ArrayList<String>  crimeArea;
    private ArrayList<String>  crimeTime;
    private ArrayList<String>  CrimeDateAndDay;
    private ArrayList<String>  noOfCriminal;
    private  ArrayList<String>  typeOfweapon;
    private ArrayList<String>  facialFeature;
    private  ArrayList<String> outfitOfCriminal;
    private  ArrayList<String> criminalVehicle;
    private  ArrayList<String> anyidentification;
    private ArrayList<String> treatmentByCriminal;
    private  ArrayList<String> casualties;
    private ArrayList<String> mobilesnachingRelated;
    private ArrayList<String> vehiclesnachingRelated;

    HashMap<String,Object> value = null;




    public ArrayList<String> getTypeOfCrime() {
        return typeOfCrime;
    }

    public void setTypeOfCrime(ArrayList<String> typeOfCrime) {
        this.typeOfCrime = typeOfCrime;
    }

    public ArrayList<String> getVictim() {
        return Victim;
    }

    public void setVictim(ArrayList<String> victim) {
        Victim = victim;
    }

    public ArrayList<String> getCrimeArea() {
        return crimeArea;
    }

    public void setCrimeArea(ArrayList<String> crimeArea) {
        this.crimeArea = crimeArea;
    }

    public ArrayList<String> getCrimeTime() {
        return crimeTime;
    }

    public void setCrimeTime(ArrayList<String> crimeTime) {
        this.crimeTime = crimeTime;
    }

    public ArrayList<String> getCrimeDateAndDay() {
        return CrimeDateAndDay;
    }

    public void setCrimeDateAndDay(ArrayList<String> crimeDateAndDay) {
        CrimeDateAndDay = crimeDateAndDay;
    }

    public ArrayList<String> getNoOfCriminal() {
        return noOfCriminal;
    }

    public void setNoOfCriminal(ArrayList<String> noOfCriminal) {
        this.noOfCriminal = noOfCriminal;
    }

    public ArrayList<String> getTypeOfweapon() {
        return typeOfweapon;
    }

    public void setTypeOfweapon(ArrayList<String> typeOfweapon) {
        this.typeOfweapon = typeOfweapon;
    }

    public ArrayList<String> getFacialFeature() {
        return facialFeature;
    }

    public void setFacialFeature(ArrayList<String> facialFeature) {
        this.facialFeature = facialFeature;
    }

    public ArrayList<String> getOutfitOfCriminal() {
        return outfitOfCriminal;
    }

    public void setOutfitOfCriminal(ArrayList<String> outfitOfCriminal) {
        this.outfitOfCriminal = outfitOfCriminal;
    }

    public ArrayList<String> getCriminalVehicle() {
        return criminalVehicle;
    }

    public void setCriminalVehicle(ArrayList<String> criminalVehicle) {
        this.criminalVehicle = criminalVehicle;
    }

    public ArrayList<String> getAnyidentification() {
        return anyidentification;
    }

    public void setAnyidentification(ArrayList<String> anyidentification) {
        this.anyidentification = anyidentification;
    }

    public ArrayList<String> getTreatmentByCriminal() {
        return treatmentByCriminal;
    }

    public void setTreatmentByCriminal(ArrayList<String> treatmentByCriminal) {
        this.treatmentByCriminal = treatmentByCriminal;
    }

    public ArrayList<String> getCasualties() {
        return casualties;
    }

    public void setCasualties(ArrayList<String> casualties) {
        this.casualties = casualties;
    }

    public ArrayList<String> getMobilesnachingRelated() {
        return mobilesnachingRelated;
    }

    public void setMobilesnachingRelated(ArrayList<String> mobilesnachingRelated) {
        this.mobilesnachingRelated = mobilesnachingRelated;
    }

    public ArrayList<String> getVehiclesnachingRelated() {
        return vehiclesnachingRelated;
    }

    public void setVehiclesnachingRelated(ArrayList<String> vehiclesnachingRelated) {
        this.vehiclesnachingRelated = vehiclesnachingRelated;
    }

 /*
    public void Questionnaire(HashMap user){
        //value.putAll(user);

        typeOfCrime= (ArrayList<String>) user.get("Type Of Crime");
        Victim= (ArrayList<String>) user.get("Crime Victim");
        crimeArea=(ArrayList<String>)user.get("Crime Time");
        CrimeDateAndDay=(ArrayList<String>)user.get("Crime Date");
        noOfCriminal=(ArrayList<String>)user.get("No of Criminal");
        typeOfweapon=(ArrayList<String>)user.get("Type of Weapon");
        facialFeature=(ArrayList<String>)user.get("Facial fearure");
        outfitOfCriminal=(ArrayList<String>)user.get("Outfit of criminal");
        criminalVehicle=(ArrayList<String>)user.get("Criminal Vehicle");
        anyidentification=(ArrayList<String>)user.get("Any Identification of Vehicle");
        treatmentByCriminal=(ArrayList<String>)user.get("Treatment By Criminal");
        casualties=(ArrayList<String>)user.get("Casualties");
        mobilesnachingRelated =(ArrayList<String>)user.get("Mobile snaching Related");
        vehiclesnachingRelated =(ArrayList<String>)user.get("Vehicle snaching Related");
        crimeArea =(ArrayList<String>)user.get("Crime Location");
        Log.d("load", String.valueOf(getCrimeDateAndDay()));
        Log.d("load", String.valueOf(getNoOfCriminal()));


    }
  */

    public Questionnaire(ArrayList<String> typeOfCrime, ArrayList<String> victim, ArrayList<String> crimeArea, ArrayList<String> crimeTime, ArrayList<String> crimeDateAndDay, ArrayList<String> noOfCriminal, ArrayList<String> typeOfweapon, ArrayList<String> facialFeature, ArrayList<String> outfitOfCriminal, ArrayList<String> criminalVehicle, ArrayList<String> anyidentification, ArrayList<String> treatmentByCriminal, ArrayList<String> casualties, ArrayList<String> mobilesnachingRelated, ArrayList<String> vehiclesnachingRelated) {
        this.typeOfCrime = typeOfCrime;
        Victim = victim;
        this.crimeArea = crimeArea;
        this.crimeTime = crimeTime;
        CrimeDateAndDay = crimeDateAndDay;
        this.noOfCriminal = noOfCriminal;
        this.typeOfweapon = typeOfweapon;
        this.facialFeature = facialFeature;
        this.outfitOfCriminal = outfitOfCriminal;
        this.criminalVehicle = criminalVehicle;
        this.anyidentification = anyidentification;
        this.treatmentByCriminal = treatmentByCriminal;
        this.casualties = casualties;
        this.mobilesnachingRelated = mobilesnachingRelated;
        this.vehiclesnachingRelated = vehiclesnachingRelated;
    }
}
