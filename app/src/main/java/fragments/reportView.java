package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.r462.hammad.questionnaire.R;


public class reportView extends Fragment {
    Button reportBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_report_view,container,false);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        reportBtn= (Button)getActivity().findViewById(R.id.report);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //LayoutInflater layoutInflater=getActivity().getLayoutInflater();
               // View view = layoutInflater.inflate(R.layout.fragment_type_of_crime,null,false);

               // RelativeLayout relativeLayout =(RelativeLayout)getActivity().findViewById(R.id.activity_main);

                //relativeLayout.addView(view);

                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new typeOfCrime()).addToBackStack(null).commit();

            }
        });





    }
}
