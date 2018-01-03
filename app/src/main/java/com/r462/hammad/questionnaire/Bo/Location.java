package com.r462.hammad.questionnaire.Bo;

import java.util.ArrayList;

/**
 * Created by Hammad Ahmed on 10/25/2017.
 */

public class Location  {
    private ArrayList<String> crimeArea;

    public Location(ArrayList<String> crimeArea) {
        this.crimeArea = crimeArea;
    }

    public ArrayList<String> getCrimeArea() {
        return crimeArea;
    }

    public void setCrimeArea(ArrayList<String> crimeArea) {
        this.crimeArea = crimeArea;
    }
}
