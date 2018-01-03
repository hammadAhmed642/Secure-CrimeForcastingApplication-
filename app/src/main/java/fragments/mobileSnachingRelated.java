package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.r462.hammad.questionnaire.Bo.SharedPreferenceData;
import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class mobileSnachingRelated extends Fragment {
    SharedPreferences sharedPreferences =  new SharedPreferences();
    SharedPreferenceData sharedPreferenceData = new SharedPreferenceData();
    int checker =0;
    int i=0;
    List<String> mobileModel = new ArrayList<>();
    EditText mobileModelEditText;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mobile_snaching_related,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         mobileModelEditText = (EditText)getActivity().findViewById(R.id.mobileModelId);

        Button nextMobileSnachingRelated = (Button)getActivity().findViewById(R.id.mobileModelNextId);
        nextMobileSnachingRelated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobilerelatedData = mobileModelEditText.getText().toString();
                mobileModel.add(mobilerelatedData);


                sharedPreferences.setmobileSnaching(getActivity(),mobileModel);

                for(int i=0;i<mobileModel.size();i++){

                    Toast.makeText(getActivity(),mobileModel.get(i),Toast.LENGTH_LONG).show();
                }


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
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminalVehicle()).addToBackStack(null).commit();

                }


            }
        });

    }

}
