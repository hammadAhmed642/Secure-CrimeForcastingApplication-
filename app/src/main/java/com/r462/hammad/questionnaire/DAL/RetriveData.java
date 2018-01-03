package com.r462.hammad.questionnaire.DAL;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hammad Ahmed on 9/28/2017.
 */

public class RetriveData {


    private FirebaseDatabase firebase;
    private DatabaseReference databaseReference;
    List<Object> data=new ArrayList<>();


    public RetriveData() {
         firebase=firebase.getInstance();
        databaseReference= firebase.getReference();
        databaseReference.child("Questionnaires").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();



                for (DataSnapshot child: children){
                    final Object value = child.getValue(SharedPreferences.class);

                    data.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
