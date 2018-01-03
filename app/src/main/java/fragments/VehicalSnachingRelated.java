package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class VehicalSnachingRelated extends Fragment {
    SharedPreferences sharedPreferences = new SharedPreferences();
    EditText vehicaleModelEditText;
    List<String> vehicalModel= new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vehicle_snaching_related,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         vehicaleModelEditText = (EditText)getActivity().findViewById(R.id.vehicaleModelId);

        Button nextVehicleSnachingRelated = (Button)getActivity().findViewById(R.id.VehicleModelNextId);
        nextVehicleSnachingRelated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicalModel.add(vehicaleModelEditText.getText().toString());

                sharedPreferences.setvehicleSnachingRealted(getActivity(),vehicalModel);

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminalVehicleIdentification()).addToBackStack(null).addToBackStack(null).commit();


            }
        });

    }

}
