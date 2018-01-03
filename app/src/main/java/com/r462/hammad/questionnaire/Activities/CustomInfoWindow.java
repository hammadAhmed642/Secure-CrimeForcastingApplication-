package com.r462.hammad.questionnaire.Activities;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.r462.hammad.questionnaire.MainActivity;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;

/**
 * Created by OK COMPUTER on 1/2/2018.
 */

public class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {

    private Activity context;
    ArrayList<Float> crimeStatistics =  new ArrayList<>();

    public CustomInfoWindow(Activity context, ArrayList<Float> crimeStatistics) {

    }

    public CustomInfoWindow(MainActivity mainActivity) {
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = context.getLayoutInflater().inflate(R.layout.custominfowindow, null);

        TextView statsMobileSnatching = (TextView) view.findViewById(R.id.statsMobileSnatchingId);
        TextView statsBlast = (TextView) view.findViewById(R.id.statsBlastId);
        TextView statsRobbery = (TextView) view.findViewById(R.id.statsRobberyId);
        TextView statsMurder = (TextView) view.findViewById(R.id.statsMurderId);
        TextView statsSexualHarasment = (TextView) view.findViewById(R.id.statsSexualHarassmentId);
        TextView statsVandalism = (TextView) view.findViewById(R.id.statsVandalismId);
        TextView statsKidnapping = (TextView) view.findViewById(R.id.statsKidnappingId);
        TextView vehicleSnactching = (TextView) view.findViewById(R.id.statsVehicleSnatchingId);






        return view;
    }
}
