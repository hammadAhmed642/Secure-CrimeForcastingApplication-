package fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


public  class crimeArea extends Fragment {
    SharedPreferences sharedPreferences=new SharedPreferences();

    Button crimeAreaNextBtn;
    TextView textView;
    TextView placeaddress;
    //Button getplace;
    ImageButton imageButton;
    //private GoogleMap map;
    final static int MY_PERMISSION_FINE_LOCATION = 420;
    final static int PLACE_PICKER_REQ = 101;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_crime_area, container, false);



    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        crimeAreaNextBtn = (Button) getActivity().findViewById(R.id.crimeAreaNexTId);

        textView = (TextView) getActivity().findViewById(R.id.tvname);
        // placeaddress = (TextView) getActivity().findViewById(R.id.tvaddress);
        imageButton = (ImageButton) getActivity().findViewById(R.id.imageButton);
        //crimeAreaNextBtn.setEnabled(false);

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    crimeAreaNextBtn.setEnabled(false);
                } else {
                    crimeAreaNextBtn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    Intent intent = builder.build(getActivity());

                    startActivityForResult(intent, PLACE_PICKER_REQ);

                } catch (GooglePlayServicesRepairableException e) {

                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {

                    e.printStackTrace();
                }


            }
        });

        crimeAreaNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new crimeTime()).addToBackStack(null).commit();
            }
        });

    }
    private void requestpermission() {

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_DENIED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] != PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(getActivity(), "This appliation requires permission to be granted", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }





    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == PLACE_PICKER_REQ) {
            // map.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(24.946218,67.005615) , 14.0f) );

            if (resultCode == RESULT_OK) {
                JSONObject jsonObj = new JSONObject();


                Place place = PlacePicker.getPlace(getActivity(), data);

                // LatLng karachi=new LatLng(new LatLng(24.946218,144)new LatLng(67.005615,155));
                //Locale a = place.getLocale();
                //LatLng latitude = place.getLatLng();
                //String lati = latitude.toString();
                //placename.setText(place.getName());
                // placeaddress.setText(lati);
                //String toastMsg = String.format("Place: %s", place.getName());
                //Toast.makeText(getActivity(), toastMsg, Toast.LENGTH_LONG).show();

                StringBuilder stBuilder = new StringBuilder();
                String placename = String.format("%s", place.getName());
                String latitude = String.valueOf(place.getLatLng().latitude);
                String longitude = String.valueOf(place.getLatLng().longitude);
                String address = String.format("%s", place.getAddress());
                stBuilder.append("Name: ");
                stBuilder.append(placename);
                stBuilder.append("\n");
               // stBuilder.append("Latitude: ");
               // stBuilder.append(latitude);
               // stBuilder.append("\n");
               // stBuilder.append("Logitude: ");
               // stBuilder.append(longitude);
                //stBuilder.append("\n");
                stBuilder.append("Address: ");
                stBuilder.append(address);
                textView.setText(stBuilder.toString());
                List<String> location=new ArrayList<>();
               // location.add(latitude + " ," +longitude +"Address" +address);
                location.add(latitude);
                location.add(longitude);
                location.add(address);
                sharedPreferences.setCrimeLocation(getActivity(),location);
            }
        }
    }
}

