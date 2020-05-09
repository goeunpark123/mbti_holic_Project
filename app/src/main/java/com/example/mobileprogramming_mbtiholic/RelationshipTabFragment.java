package com.example.mobileprogramming_mbtiholic;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class RelationshipTabFragment extends Fragment {


    public RelationshipTabFragment() {
        // Required empty public constructor
    }

    //Spinner mbtiCoupleSpinner1,mbtiCoupleSpinner2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       /* // //[출처] 안드로이드 스피너 (Selectbox) 구현 방법|작성자 히키코보라
        mbtiCoupleSpinner1 = (Spinner) findViewById(R.id.spinner_mbti1);
        mbtiCoupleSpinner2 = (Spinner) findViewById(R.id.spinner_mbti2);

        ArrayAdapter mbti1_Adapter = ArrayAdapter.createFromResource(this,
                R.array.mbti_type, android.R.layout.simple_spinner_item);
        mbti1_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mbtiCoupleSpinner1.setAdapter(mbti1_Adapter);

        ArrayAdapter mbti2_Adapter = ArrayAdapter.createFromResource(this,
                R.array.mbti_type, android.R.layout.simple_spinner_item);
        mbti2_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mbtiCoupleSpinner2.setAdapter(mbti1_Adapter);
        */
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relationship_tab, container, false);
    }

}
