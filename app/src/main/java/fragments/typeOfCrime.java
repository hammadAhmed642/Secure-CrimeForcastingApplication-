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
import android.widget.Toast;

import com.r462.hammad.questionnaire.Bo.SharedPreferenceData;
import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class typeOfCrime extends Fragment{
    SharedPreferences sharedPreferences = new SharedPreferences();
    SharedPreferenceData sharedPreferenceData = new SharedPreferenceData();
   // ManageQuestionnaireDAL dal =new ManageQuestionnaireDAL((MainActivity)getActivity());


    int count=0;
    int value1 =0,value2 =0,value3 =0,value4 =0,value5 =0,value6 =0,value7 =0,value8 =0;
    int value=0;

    CheckBox mobilesnatchingCheckBox, murderCheckBox, kidnappingCheckBox, robberyCheckBox, sexualharassmentCheckBox, blastCheckBox, vandalismCheckBox,vehicleSnatchingCheckBox;
    Button backbtn, nextbtn;
    public List<String> selectedType = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_type_of_crime, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final Activity activity = getActivity();
        mobilesnatchingCheckBox = (CheckBox) activity.findViewById(R.id.mobilesnatching);
        murderCheckBox = (CheckBox) activity.findViewById(R.id.murder);
        kidnappingCheckBox = (CheckBox) activity.findViewById(R.id.kidnapping);
        robberyCheckBox = (CheckBox) activity.findViewById(R.id.robbery);
        sexualharassmentCheckBox = (CheckBox) activity.findViewById(R.id.sexualHarassment);
        blastCheckBox = (CheckBox) activity.findViewById(R.id.blast);
        vandalismCheckBox = (CheckBox) activity.findViewById(R.id.vandalism);
        vehicleSnatchingCheckBox = (CheckBox) activity.findViewById(R.id.vehicleSnatchingId);
        nextbtn=(Button)activity.findViewById(R.id.Next);
        nextbtn.setEnabled(false);
       check();




        nextbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mobilesnatchingCheckBox.isChecked()) {
                    selectedType.add(mobilesnatchingCheckBox.getText().toString());

                }
                if (murderCheckBox.isChecked()) {
                    selectedType.add(murderCheckBox.getText().toString());

                }
                if (kidnappingCheckBox.isChecked()) {
                    selectedType.add(kidnappingCheckBox.getText().toString());
                }
                if (robberyCheckBox.isChecked()) {
                    selectedType.add(robberyCheckBox.getText().toString());
                }
                if (sexualharassmentCheckBox.isChecked()) {
                    selectedType.add(sexualharassmentCheckBox.getText().toString());
                }
                if (blastCheckBox.isChecked()) {
                    selectedType.add(blastCheckBox.getText().toString());
                }
                if (vandalismCheckBox.isChecked()) {
                    selectedType.add(vandalismCheckBox.getText().toString());
                }
                if(vehicleSnatchingCheckBox.isChecked()){
                    selectedType.add(vehicleSnatchingCheckBox.getText().toString());
                }




                sharedPreferences.TypeofCrime(getActivity(),(ArrayList<String>)selectedType);
               List<String> value =  sharedPreferenceData.getTypeOfCrime(getActivity());
                if(value==null){
                   Toast.makeText(getActivity(),"Value is null",Toast.LENGTH_SHORT).show();
               }
                else
                {
                    for(int i=0;i<value.size();i++)
                          Toast.makeText(getActivity(),value.get(i),Toast.LENGTH_SHORT).show();
                }


               // if(mobilesnatchingCheckBox.isChecked()){
                //getFragmentManager().beginTransaction().replace(R.id.fragment_container,new mobileSnachingRelated()).addToBackStack(null).commit();
            //}
            //else if(vehicleSnatchingCheckBox.isChecked()){
              //  getFragmentManager().beginTransaction().replace(R.id.fragment_container,new VehicalSnachingRelated()).addToBackStack(null).commit();
            //}
           // else{
               getFragmentManager().beginTransaction().replace(R.id.fragment_container,new Victim()).addToBackStack(null).commit();

            //}



            }

        });



}

    public void check(){
        nextbtn.setEnabled(false);

            mobilesnatchingCheckBox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(value1==0){
                        nextbtn.setEnabled(true);
                        value1++;

                    }
                    else
                    {
                        if(blastCheckBox.isChecked()||murderCheckBox.isChecked()||kidnappingCheckBox.isChecked()||robberyCheckBox.isChecked()||sexualharassmentCheckBox.isChecked()||vandalismCheckBox.isChecked()||vehicleSnatchingCheckBox.isChecked()){
                            nextbtn.setEnabled(true);
                        }
                        else{
                            nextbtn.setEnabled(false);
                            value1=0;
                        }

                    }

                }
            });

            murderCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(value2==0){
                        nextbtn.setEnabled(true);
                        value2++;
                    }
                    else
                    {
                        if(blastCheckBox.isChecked()||mobilesnatchingCheckBox.isChecked()||kidnappingCheckBox.isChecked()||robberyCheckBox.isChecked()||sexualharassmentCheckBox.isChecked()||vandalismCheckBox.isChecked()||vehicleSnatchingCheckBox.isChecked()){
                            nextbtn.setEnabled(true);
                        }
                        else{
                            nextbtn.setEnabled(false);
                            value2=0;
                        }
                    }
                }
            });



            kidnappingCheckBox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    if(value3==0){
                        nextbtn.setEnabled(true);
                        value3++;
                    }
                    else
                    {
                        if(blastCheckBox.isChecked()||murderCheckBox.isChecked()||mobilesnatchingCheckBox.isChecked()||robberyCheckBox.isChecked()||sexualharassmentCheckBox.isChecked()||vandalismCheckBox.isChecked()||vehicleSnatchingCheckBox.isChecked()){
                            nextbtn.setEnabled(true);
                        }
                        else{
                            nextbtn.setEnabled(false);
                            value3=0;
                        }
                    }
                }
            });

            robberyCheckBox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(value4==0){
                        nextbtn.setEnabled(true);
                        value4++;
                    }
                    else
                    {

                        if(blastCheckBox.isChecked()||murderCheckBox.isChecked()||mobilesnatchingCheckBox.isChecked()||kidnappingCheckBox.isChecked()||sexualharassmentCheckBox.isChecked()||vandalismCheckBox.isChecked()||vehicleSnatchingCheckBox.isChecked()){
                            nextbtn.setEnabled(true);
                        }
                        else{
                            nextbtn.setEnabled(false);
                            value4=0;
                        }
                    }
                }
            });


            sexualharassmentCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(value5==0){
                        nextbtn.setEnabled(true);
                        value5++;
                    }
                    else
                    {
                        if(blastCheckBox.isChecked()||murderCheckBox.isChecked()||mobilesnatchingCheckBox.isChecked()||kidnappingCheckBox.isChecked()||robberyCheckBox.isChecked()||vandalismCheckBox.isChecked()||vehicleSnatchingCheckBox.isChecked()){
                            nextbtn.setEnabled(true);
                        }
                        else{
                            nextbtn.setEnabled(false);
                            value5=0;
                        }
                    }
                }
            });

            blastCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(value6==0){
                        nextbtn.setEnabled(true);
                        value6++;

                    }
                    else
                    {
                        if(sexualharassmentCheckBox.isChecked()||murderCheckBox.isChecked()||mobilesnatchingCheckBox.isChecked()||kidnappingCheckBox.isChecked()||robberyCheckBox.isChecked()||vandalismCheckBox.isChecked()||vehicleSnatchingCheckBox.isChecked()){
                            nextbtn.setEnabled(true);
                        }
                        else{
                            nextbtn.setEnabled(false);
                            value6=0;
                        }
                    }
                }
            });

            vandalismCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(value7==0){
                        nextbtn.setEnabled(true);
                        value7++;
                    }
                    else
                    {
                        if(sexualharassmentCheckBox.isChecked()||murderCheckBox.isChecked()||mobilesnatchingCheckBox.isChecked()||kidnappingCheckBox.isChecked()||robberyCheckBox.isChecked()||blastCheckBox.isChecked()||vehicleSnatchingCheckBox.isChecked()){
                            nextbtn.setEnabled(true);
                        }
                        else{
                            nextbtn.setEnabled(false);
                            value7=0;
                        }
                    }
                }
            });

            vehicleSnatchingCheckBox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(value8==0){
                        nextbtn.setEnabled(true);
                        value8++;
                    }
                    else
                    {
                        if(sexualharassmentCheckBox.isChecked()||murderCheckBox.isChecked()||mobilesnatchingCheckBox.isChecked()||kidnappingCheckBox.isChecked()||robberyCheckBox.isChecked()||blastCheckBox.isChecked()||vandalismCheckBox.isChecked()){
                            nextbtn.setEnabled(true);
                        }
                        else{
                            nextbtn.setEnabled(false);
                            value8=0;
                        }
                    }
                }
            });

        }


}









