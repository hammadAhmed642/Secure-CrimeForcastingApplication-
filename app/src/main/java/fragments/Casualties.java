package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.r462.hammad.questionnaire.Bo.Questionnaire;
import com.r462.hammad.questionnaire.Bo.SharedPreferenceData;
import com.r462.hammad.questionnaire.DAL.ManageQuestionnaireDAL;
import com.r462.hammad.questionnaire.DAL.RetriveData;
import com.r462.hammad.questionnaire.DAL.SharedPreferences;
import com.r462.hammad.questionnaire.MainActivity;
import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class Casualties extends Fragment {
    List<String> selectedvictim=new ArrayList<>();
    List<String> vechileSnachingRelated=new ArrayList<>();
    List<String> treatmentBycriminal=new ArrayList<>();
    List<String> numberOfCriminal=new ArrayList<>();
    List<String> mobileSnachingRelated=new ArrayList<>();
    List<String> criminalVechileIdentification=new ArrayList<>();

    List<String> criminalWeapon=new ArrayList<>();
    List<String> criminalVechileused=new ArrayList<>();
    List<String> criminalOutfit=new ArrayList<>();
    List<String> criminalFacialFeatures=new ArrayList<>();
    List<String> crimeDate=new ArrayList<>();
    List<String> crimeTime=new ArrayList<>();
    List<String> CrimeArea=new ArrayList<>();
    List<String> casualties=new ArrayList<>();
    SharedPreferences sharedPreferences = new SharedPreferences();
    SharedPreferenceData sharedPreferenceData =  new SharedPreferenceData();
    ManageQuestionnaireDAL manageQuestionnaireDAL = new ManageQuestionnaireDAL();
    List<String> typeofcime = new ArrayList<>();
    String casualtiesValue="";
    String value;
    RadioButton yesCasualtiesRadioButton,NoCasualtiesRadioButton;
    Button selectCasualtiesBtn,finishBtn;
    List<String> casualtiesArrayList = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_casualties,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        yesCasualtiesRadioButton=(RadioButton)getActivity().findViewById(R.id.YesCasualtiesId);
        NoCasualtiesRadioButton=(RadioButton)getActivity().findViewById(R.id.NoCasualtiesId);
        finishBtn=(Button)getActivity().findViewById(R.id.FinishID);

        finishBtn.setEnabled(false);
        CasualtiesCheck();

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yesCasualtiesRadioButton.isChecked()){
                    casualtiesArrayList.add("Yes");

                }
                if(NoCasualtiesRadioButton.isChecked()){

                    casualtiesArrayList.add("No");
                }

                //Toast.makeText(getActivity(),casualtiesValue,Toast.LENGTH_SHORT).show();

                sharedPreferences.setCasulties(getActivity(),casualtiesArrayList);
                setDataFirebase();
                manageQuestionnaireDAL.getDataFromDatabase(getActivity());
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);


             ////   android.os.Process.killProcess(android.os.Process.myPid());



            }
        });

    }
    public void CasualtiesCheck(){
        yesCasualtiesRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finishBtn.setEnabled(true);
            }
        });
        NoCasualtiesRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishBtn.setEnabled(true);
            }
        });


    }

    public  void setDataFirebase(){

        typeofcime=sharedPreferenceData.getTypeOfCrime(getActivity());
        manageQuestionnaireDAL.AddTypeOfCrime(typeofcime);

        selectedvictim = sharedPreferenceData.getVictim(getActivity());
        manageQuestionnaireDAL.AddVictim(selectedvictim);

        crimeTime = sharedPreferenceData.getCrimeTime(getActivity());
        manageQuestionnaireDAL.AddCrimeTime(crimeTime);

        crimeDate = sharedPreferenceData.getCrimeDate(getActivity());
        manageQuestionnaireDAL.AddCrimeData(crimeDate);


        CrimeArea=sharedPreferenceData.getCrimeLocation(getActivity());
        manageQuestionnaireDAL.AddcrimeLocation(CrimeArea);


        numberOfCriminal =sharedPreferenceData.getnoOfCrimianls(getActivity());
        manageQuestionnaireDAL.AddNoOfCriminal(numberOfCriminal);

        criminalWeapon = sharedPreferenceData.getCriminalWepaon(getActivity());
        manageQuestionnaireDAL.AddTypeOfWeapon(criminalWeapon);

        criminalFacialFeatures= sharedPreferenceData.getCriminalFacialFeatures(getActivity());
        manageQuestionnaireDAL.AddFacialCriminal(criminalFacialFeatures);

        criminalOutfit = sharedPreferenceData.getCriminalOutfit(getActivity());
        manageQuestionnaireDAL.AddCriminalOutfit(criminalOutfit);

        criminalVechileused = sharedPreferenceData.getCriminalVecicle(getActivity());
        manageQuestionnaireDAL.AddcriminalVehicle(criminalVechileused);

        criminalVechileIdentification = sharedPreferenceData.getCriminalVehicleIdent(getActivity());
        manageQuestionnaireDAL.AddanyidentificationOfVehicle(criminalVechileIdentification);


        treatmentBycriminal = sharedPreferenceData.getTreatmentByCrimianl(getActivity());
        manageQuestionnaireDAL.AddtreatmentByCriminal(treatmentBycriminal);

        casualties =sharedPreferenceData.getCasulties(getActivity());
        manageQuestionnaireDAL.AddAnycasualties(casualties);

        mobileSnachingRelated =sharedPreferenceData.getmobileSnatching(getActivity());
        manageQuestionnaireDAL.AddMobileSnachingRelatedQuestion(mobileSnachingRelated);

        vechileSnachingRelated = sharedPreferenceData.getVechileSnatching(getActivity());
        manageQuestionnaireDAL.AddVehicleSnachingRelatedQuestion(vechileSnachingRelated);



    }


        }
