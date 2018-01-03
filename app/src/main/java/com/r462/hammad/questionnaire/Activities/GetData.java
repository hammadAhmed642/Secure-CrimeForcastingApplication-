package com.r462.hammad.questionnaire.Activities;

import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * Created by Muhammad Masood on 31/12/2017.
 */

public class GetData  {

    private String result;


    GetData(){

    }

     public String data(){


         String myUrl = "http://10.0.2.2:8000/getAllCrimes";
         HttpGetRequest getRequest = new HttpGetRequest();
         try {
             result = getRequest.execute(myUrl).get();

         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }

        return result;
     }

}
