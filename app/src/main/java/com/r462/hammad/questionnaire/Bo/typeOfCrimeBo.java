package com.r462.hammad.questionnaire.Bo;

import java.util.ArrayList;

/**
 * Created by hammad on 4/28/2017.
 */

public class typeOfCrimeBo {


    private ArrayList<String> option  = new ArrayList<>();

    public typeOfCrimeBo(ArrayList<String> option) {
        this.option = option;


    }

    public ArrayList<String> getOption() {
        return option;
    }

    public void setOption(ArrayList<String> option) {
        this.option = option;
    }
}
