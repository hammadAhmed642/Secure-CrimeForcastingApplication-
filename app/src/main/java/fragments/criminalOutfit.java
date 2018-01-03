package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.r462.hammad.questionnaire.Bo.SharedPreferenceData;
import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class  criminalOutfit extends Fragment {
    SharedPreferences sharedPreferences = new SharedPreferences();
    SharedPreferenceData sharedPreferenceData = new SharedPreferenceData();
    int checker =0;
    List<String> criminalOutfitList = new ArrayList<>();
    int i=0;
    CheckBox shalwarKameezCheckBox,jeanTShirtCheckBox,shortsCheckBox,otherOutfitCheckBox;
    Button SelectOutfitBtn,nextOutfitBtn;
    EditText userOutfitEText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_criminal_outfit,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        shalwarKameezCheckBox=(CheckBox)getActivity().findViewById(R.id.shalwarKameezId);
        jeanTShirtCheckBox=(CheckBox)getActivity().findViewById(R.id.jeanTShirtId);
        shortsCheckBox=(CheckBox)getActivity().findViewById(R.id.shotsId);
        otherOutfitCheckBox=(CheckBox)getActivity().findViewById(R.id.otherOutfitId);
        userOutfitEText = (EditText)getActivity().findViewById(R.id.userOutfitId);
        nextOutfitBtn=(Button)getActivity().findViewById(R.id.nextOutfitId);
        nextOutfitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shalwarKameezCheckBox.isChecked()){
                    criminalOutfitList.add(shalwarKameezCheckBox.getText().toString());

                }
                if(jeanTShirtCheckBox.isChecked()){
                    criminalOutfitList.add(jeanTShirtCheckBox.getText().toString());
                }
                if(shortsCheckBox.isChecked()){
                    criminalOutfitList.add(shortsCheckBox.getText().toString());
                }
                if(otherOutfitCheckBox.isChecked()&&userOutfitEText!=null){
                    criminalOutfitList.add(userOutfitEText.getText().toString());
                }
              //  for(int i=0;i<criminalOutfitList.size();i++){
                //    Toast.makeText(getActivity(),criminalOutfitList.get(i),Toast.LENGTH_SHORT).show();
                //}
                sharedPreferences.setCriminalOutfit(getActivity(),criminalOutfitList);


                List<String> value =  sharedPreferenceData.getTypeOfCrime(getActivity());

                   // for(int i=0;i<value.size();i++)
                    while(i<value.size()){

                        if (value.get(i).equals("Mobile snatching")) {

                            checker = 1;
                            break;
                       }

                        i++;
                    }
                if(checker==1){
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container,new mobileSnachingRelated()).addToBackStack(null).commit();

                }
                else{
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminalVehicle()).addToBackStack(null).commit();

                }


            }
        });



    }
}
