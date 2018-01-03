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


public class criminalVehicleIdentification extends Fragment {
    SharedPreferences sharedPreferences = new SharedPreferences();
    List <String> criminalvehicaleIdent = new ArrayList<>();
    EditText criminalVehicleIdentification;

    Button nextcriminalVehicleIdentificationBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_criminal_vehicle_identification,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         criminalVehicleIdentification = (EditText)getActivity().findViewById(R.id.criminalVehicalIdentificationID);

       nextcriminalVehicleIdentificationBtn=(Button)getActivity().findViewById(R.id.criminalVehicalIdentificationIdNexTId);
        nextcriminalVehicleIdentificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criminalvehicaleIdent.add( criminalVehicleIdentification.getText().toString()) ;
                sharedPreferences.setCriminalVehicleIdent(getActivity(),criminalvehicaleIdent);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new treatmentByCriminal()).addToBackStack(null).addToBackStack(null).commit();
            }
        });
    }
}
