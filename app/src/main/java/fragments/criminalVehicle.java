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


public class criminalVehicle extends Fragment {
    SharedPreferences sharedPreferences = new SharedPreferences();
    SharedPreferenceData sharedPreferenceData = new SharedPreferenceData();
    int checker =0;
    int i=0;
    List<String> criminalVehicleList = new ArrayList<>();

    CheckBox carCheckBox,bikeCheckBox,otherCheckBox;
      EditText userVehicleText;
        Button selectVehicleBtn,nextVehicleBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_criminal_vehicle,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        carCheckBox = (CheckBox)getActivity().findViewById(R.id.carId);
        bikeCheckBox=(CheckBox)getActivity().findViewById(R.id.bikeId);
        otherCheckBox=(CheckBox)getActivity().findViewById(R.id.othervehicleId);
        userVehicleText= (EditText)getActivity().findViewById(R.id.userVehileId);
        nextVehicleBtn=(Button)getActivity().findViewById(R.id.nextCriminalVehicleId);
        nextVehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carCheckBox.isChecked()){

                    criminalVehicleList.add(carCheckBox.getText().toString());
                }
                if(bikeCheckBox.isChecked()){

                    criminalVehicleList.add(bikeCheckBox.getText().toString());
                }
                if(otherCheckBox.isChecked()&&userVehicleText!=null){

                    criminalVehicleList.add(userVehicleText.getText().toString());
                }
              //  for(int i=0;i<criminalVehicleList.size();i++){
                //    Toast.makeText(getActivity(),criminalVehicleList.get(i),Toast.LENGTH_SHORT).show();
                //}
                sharedPreferences.setCriminalVehicle(getActivity(),criminalVehicleList);
                List<String> value =  sharedPreferenceData.getTypeOfCrime(getActivity());

                // for(int i=0;i<value.size();i++)
                while(i<value.size()){

                    if (value.get(i).equals("Vehicle Snatching")) {

                        checker = 1;
                        break;
                    }

                    i++;
                }
                if(checker==1){
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,new VehicalSnachingRelated()).addToBackStack(null).commit();

                }
                else{
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminalVehicleIdentification()).addToBackStack(null).addToBackStack(null).commit();

                }


            }
        });


    }
}
