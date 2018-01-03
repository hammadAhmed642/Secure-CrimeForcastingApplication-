package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class Victim extends Fragment  {
    SharedPreferences sharedPreferences = new SharedPreferences();
    int value1=0,value2=0,value3=0,value4=0,value5=0;

    CheckBox youcheckBox ,yourFriendCheckBox,yourRelativeCheckBox,otherVictimCheckBox,strangerCheckBox;
    Button selectVictimbtn,nextVictimbtn;
    EditText victimOtherText;
    final List<String> selectedvictim = new ArrayList<String>();
    int value=0;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_victim,container,false);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Activity activity = getActivity();
    youcheckBox=(CheckBox)activity.findViewById(R.id.you);
        yourFriendCheckBox=(CheckBox)activity.findViewById(R.id.yourFriend);
        yourRelativeCheckBox=(CheckBox)activity.findViewById(R.id.yourRelative);
        strangerCheckBox=(CheckBox)activity.findViewById(R.id.strangerVictim);
        otherVictimCheckBox = (CheckBox)activity.findViewById(R.id.other);
        victimOtherText = (EditText) activity.findViewById(R.id.victimValueText);
        nextVictimbtn = (Button)activity.findViewById(R.id.VictimNext);





        nextVictimbtn.setEnabled(false);
        nextVictimCheck();

        nextVictimbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(youcheckBox.isChecked()){

                    selectedvictim.add(youcheckBox.getText().toString());
                }
                if(yourFriendCheckBox.isChecked()){

                    selectedvictim.add(yourFriendCheckBox.getText().toString());
                }
                if(yourRelativeCheckBox.isChecked()){
                    selectedvictim.add(yourRelativeCheckBox.getText().toString());
                }
                if(strangerCheckBox.isChecked()){
                    selectedvictim.add(strangerCheckBox.getText().toString());
                }
                if(otherVictimCheckBox.isChecked()&&victimOtherText!=null){
                    selectedvictim.add(victimOtherText.getText().toString());
                }


               // for(int i=0;i<MainActivity.genericArray.size();i++){

                 //    Toast.makeText(getActivity(),MainActivity.genericArray.get(i),Toast.LENGTH_SHORT).show();

                //}

                sharedPreferences.CrimeVictim(getActivity(),selectedvictim);


                //List<String> value =  sharedPreferences.getVictim(getActivity());
                //if(value==null){
                  //Toast.makeText(getActivity(),"Value is null",Toast.LENGTH_SHORT).show();
                // }
                //else
                //{
                  //for(int i=0;i<value.size();i++)
                    //  Toast.makeText(getActivity(),value.get(i),Toast.LENGTH_SHORT).show();
                //}
                //List<String> valu =  sharedPreferences.getTypeOfCrime(getActivity());
                //if(valu==null){
                 //Toast.makeText(getActivity(),"Value is null",Toast.LENGTH_SHORT).show();
                //}
                //else
                //{
                  //for(int i=0;i<valu.size();i++)
                    //  Toast.makeText(getActivity(),valu.get(i),Toast.LENGTH_SHORT).show();
                //}

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new crimeArea()).addToBackStack(null).commit();
            }
        });
    }
   public void nextVictimCheck(){

        youcheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(value1==0){
                    nextVictimbtn.setEnabled(true);
                    value1++;
                }
                else
                {
                    if(yourFriendCheckBox.isChecked()||yourRelativeCheckBox.isChecked()||strangerCheckBox.isChecked()||otherVictimCheckBox.isChecked()){
                        nextVictimbtn.setEnabled(true);

                    }
                    else{
                        nextVictimbtn.setEnabled(false);
                        value1=0;
                    }

                }

            }
        });
        yourFriendCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(value2==0){
                    nextVictimbtn.setEnabled(true);
                    value2++;
                }
                else
                {
                    if(youcheckBox.isChecked()||yourRelativeCheckBox.isChecked()||strangerCheckBox.isChecked()||otherVictimCheckBox.isChecked()){
                        nextVictimbtn.setEnabled(true);

                    }
                    else{
                        nextVictimbtn.setEnabled(false);
                        value2=0;
                    }
                }

            }
        });
       yourRelativeCheckBox.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

               if(value3==0){
                   nextVictimbtn.setEnabled(true);
                   value3++;
               }
               else
               {
                   if(youcheckBox.isChecked()||yourFriendCheckBox.isChecked()||strangerCheckBox.isChecked()||otherVictimCheckBox.isChecked()){
                       nextVictimbtn.setEnabled(true);

                   }
                   else{
                       nextVictimbtn.setEnabled(false);
                       value3=0;
                   }
               }

           }
       });
       strangerCheckBox.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               if(value4==0){
                   nextVictimbtn.setEnabled(true);

               }
               else
               {
                   if(youcheckBox.isChecked()||yourFriendCheckBox.isChecked()||yourRelativeCheckBox.isChecked()||otherVictimCheckBox.isChecked()){
                       nextVictimbtn.setEnabled(true);

                   }
                   else{
                       nextVictimbtn.setEnabled(false);
                       value4=0;
                   }
               }

           }
       });

       otherVictimCheckBox.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {


               if(value5==0){

                           nextVictimbtn.setEnabled(true);


               }
               else
               {
                   if(youcheckBox.isChecked()||yourFriendCheckBox.isChecked()||yourRelativeCheckBox.isChecked()||strangerCheckBox.isChecked()){
                       nextVictimbtn.setEnabled(true);

                   }
                   else{
                       nextVictimbtn.setEnabled(false);
                       value5=0;
                   }
               }


           }
       });


   }
}

