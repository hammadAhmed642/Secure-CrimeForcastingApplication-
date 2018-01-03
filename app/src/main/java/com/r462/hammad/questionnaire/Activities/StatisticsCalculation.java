package com.r462.hammad.questionnaire.Activities;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by OK COMPUTER on 1/2/2018.
 */

public class StatisticsCalculation {

    int type1ForAllKarachiArea = 0;
    int type2ForAllKarachiArea = 0;
    int type3ForAllKarachiArea = 0;
    int type4ForAllKarachiArea = 0;
    int type5ForAllKarachiArea = 0;
    int type6ForAllKarachiArea = 0;
    int type7ForAllKarachiArea = 0;
    int type8ForAllKarachiArea = 0;

    ArrayList<Integer> calculation = new ArrayList<>();

    public StatisticsCalculation() {
        //calculation = value;

    }

    public ArrayList<Integer> stats(ArrayList<String> value) {

        for (String m : value) {
            String l = m;
            // Log.d("chekker",l);


            if (l.equalsIgnoreCase("[Mobile snatching]")) {
                type1ForAllKarachiArea = type1ForAllKarachiArea + 1;

                Log.d("chekker", String.valueOf(type1ForAllKarachiArea));

            }
            if (l.equalsIgnoreCase("[Blast]")) {

                type2ForAllKarachiArea = type2ForAllKarachiArea + 1;
                //  Toast.makeText(getApplication(),""+typeOfCriminal.toString()+""+type1ForAllKarachiArea +""+type2ForAllKarachiArea+""+type3ForAllKarachiArea+""+
                //        type4ForAllKarachiArea+""+type5ForAllKarachiArea+""+type6ForAllKarachiArea+""+type7ForAllKarachiArea+""+type8ForAllKarachiArea,Toast.LENGTH_LONG).show();
            }
            if (l.equalsIgnoreCase("[Robbery]")) {
                type3ForAllKarachiArea = type3ForAllKarachiArea + 1;

                Log.d("chekker", m);
            }
            if (l.equalsIgnoreCase("[Murder]")) {

                type4ForAllKarachiArea = type4ForAllKarachiArea + 1;

            }
            if (l.equalsIgnoreCase("[Sexual harassment]") ) {

                type5ForAllKarachiArea = type5ForAllKarachiArea + 1;
            }
            if (l.equalsIgnoreCase("[Vandalism]")) {

                type6ForAllKarachiArea = type6ForAllKarachiArea + 1;
            }
            if (l.equalsIgnoreCase("[Kidnapping]")) {
                type7ForAllKarachiArea = type7ForAllKarachiArea + 1;
            }
            if (l.equalsIgnoreCase("[Vehicle Snatching]") ) {
                type8ForAllKarachiArea = type8ForAllKarachiArea + 1;
            } else {


            }


            //  Toast.makeText(getApplication(),""+type1ForAllKarachiArea +""+type2ForAllKarachiArea+""+type3ForAllKarachiArea+""+
            //        type4ForAllKarachiArea+""+type5ForAllKarachiArea+""+type6ForAllKarachiArea+""+


        }

        calculation.add(type1ForAllKarachiArea);
        calculation.add(type2ForAllKarachiArea);
        calculation.add(type3ForAllKarachiArea);
        calculation.add(type4ForAllKarachiArea);
        calculation.add(type5ForAllKarachiArea);
        calculation.add(type6ForAllKarachiArea);
        calculation.add(type7ForAllKarachiArea);
        calculation.add(type8ForAllKarachiArea);
            return calculation;
    }


}
