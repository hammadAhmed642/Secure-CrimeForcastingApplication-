package com.r462.hammad.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // getSupportActionBar().hide();

        Thread thread = new Thread(){
            @Override
            public void run() {
               try {
                   sleep(4000);
                   Intent intent =  new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(intent);
                   finish();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        };
        thread.start();
    }
}
