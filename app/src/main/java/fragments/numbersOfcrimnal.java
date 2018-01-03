package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class numbersOfcrimnal extends Fragment {
    SharedPreferences sharedPreferences = new SharedPreferences();
    RadioButton oneCriminalRadioButton,twoCrimininalRadioButton,threeCriminalRadioButton,moreThanThreeRadioButton;
    Button SelectNumberOfCriminalBtn,nextNumberofCriminalBtn;
    List<String> numberofCrimninalList =  new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_numbers_ofcrimnal,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        oneCriminalRadioButton=(RadioButton) getActivity().findViewById(R.id.oneCriminalId);
        twoCrimininalRadioButton=(RadioButton) getActivity().findViewById(R.id.twoCriminalId);
        threeCriminalRadioButton=(RadioButton) getActivity().findViewById(R.id.threeCriminalId);
        moreThanThreeRadioButton=(RadioButton) getActivity().findViewById(R.id.moreThanThreeId);
        nextNumberofCriminalBtn=(Button)getActivity().findViewById(R.id.numberofcrimnalNextId);

        nextNumberofCriminalBtn.setEnabled(false);
        NumberOdCriminalCheck();


        nextNumberofCriminalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if(oneCriminalRadioButton.isChecked()){
                 numberofCrimninalList.add(oneCriminalRadioButton.getText().toString());

              }
                if(twoCrimininalRadioButton.isChecked()){

                   numberofCrimninalList.add(twoCrimininalRadioButton.getText().toString());

                }
                if(threeCriminalRadioButton.isChecked()){
                    numberofCrimninalList.add(threeCriminalRadioButton.getText().toString());
                                   }
                if(moreThanThreeRadioButton.isChecked()){
                    numberofCrimninalList.add(moreThanThreeRadioButton.getText().toString());

                }

               // for(int i=0;i<numberofCrimninalList.size();i++){
                 //   Toast.makeText(getActivity(),numberofCrimninalList.get(i),Toast.LENGTH_SHORT).show();
                //}
                sharedPreferences.setnoOfCriminals(getActivity(),numberofCrimninalList);

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminialWeapon()).addToBackStack(null).commit();

            }
        });


    }
    public void NumberOdCriminalCheck(){

        oneCriminalRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              nextNumberofCriminalBtn.setEnabled(true);

            }
        });
        twoCrimininalRadioButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    nextNumberofCriminalBtn.setEnabled(true);


            }
        });
        threeCriminalRadioButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    nextNumberofCriminalBtn.setEnabled(true);


            }
        });
        moreThanThreeRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nextNumberofCriminalBtn.setEnabled(true);


            }
        });


    }

}
