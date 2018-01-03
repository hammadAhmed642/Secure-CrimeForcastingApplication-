package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;

import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class crimeDate extends Fragment {
    SharedPreferences sharedPreferences = new SharedPreferences();
    List<String> crimeDateList = new ArrayList<String>();
    DatePicker datePicker;
    Button selectDate, dateNextBtn;
    int month, dayOfMonth, year;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crime_date, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();

        //DatePicker datePicker = new DatePicker(getActivity(),R.style.MyDialogTheme,startHour, startMinute, is24HourFormat);

        datePicker = (DatePicker) activity.findViewById(R.id.crimedateId);
        dateNextBtn = (Button) activity.findViewById(R.id.dateSelectNextId);
        dateNextBtn.setEnabled(false);

        dateNextCheck();

        dateNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                month = datePicker.getMonth();
                month++;
                dayOfMonth = datePicker.getDayOfMonth();
                year = datePicker.getYear();

                crimeDateList.add(dayOfMonth + " : " + month + " : " + year);
                Toast.makeText(getActivity(), crimeDateList.get(0), Toast.LENGTH_SHORT).show();

                sharedPreferences.setCrimeDate(getActivity(),crimeDateList);

                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new numbersOfcrimnal()).addToBackStack(null).commit();

            }
        });


    }

    public void dateNextCheck() {

        datePicker.init(dayOfMonth, month, year, new OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                  Calendar cal = Calendar.getInstance();
                cal.set(year, month, dayOfMonth);
                dateNextBtn.setEnabled(true);

            }
        });

    }


}
