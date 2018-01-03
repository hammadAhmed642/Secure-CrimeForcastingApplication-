package com.r462.hammad.questionnaire;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Hammad Ahmed on 11/4/2017.
 */

public class persistantData extends Application {

    @Override
    public void onCreate() {
        super.onCreate();



        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
