package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class crimeTime extends Fragment {
    TimePicker crimeTime;
    Button nextTimeBtn;
    Calendar calendar;
    String format = "";
    List<String> crimeTimeList = new ArrayList<String>();
    List<String> setCrimeTimeListSharedPreference = new ArrayList<>();
    SharedPreferences sharedPreferences = new SharedPreferences();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crime_time, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Activity activity = getActivity();


        crimeTime = (TimePicker) activity.findViewById(R.id.crimeTimeId);

        nextTimeBtn = (Button) activity.findViewById(R.id.TimeSelectNextId);
        crimeTime.is24HourView();
        nextTimeBtn.setEnabled(false);
        crimeTimeCheck();

        nextTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  calendar = Calendar.getInstance();

                //int hour = calendar.get(Calendar.HOUR_OF_DAY);
                //int min = calendar.get(Calendar.MINUTE);
                int hour = crimeTime.getHour();
                int min = crimeTime.getMinute();


                if (hour == 0) {
                    hour += 12;
                    format = "AM";
                } else if (hour == 12) {
                    format = "PM";
                } else if (hour > 12) {
                    hour -= 12;
                    format = "PM";
                } else {
                    format = "AM";
                }

                crimeTimeList.add(hour + ":" + min + " " + format);

                sharedPreferences.setCrimeTime(getActivity(),crimeTimeList);

                Toast.makeText(getActivity(), hour + ":" + min + " " + format, Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new crimeDate()).addToBackStack(null).commit();
            }
        });


    }

    public void crimeTimeCheck() {
        boolean value =true;
        crimeTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                nextTimeBtn.setEnabled(true);
            }
        });
    }

}