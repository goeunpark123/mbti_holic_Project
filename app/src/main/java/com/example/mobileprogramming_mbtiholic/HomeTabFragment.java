package com.example.mobileprogramming_mbtiholic;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ENFJ;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ENFP;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ENTJ;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ENTP;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ESFJ;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ESFP;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ESTJ;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ESTP;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_INFJ;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_INFP;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_INTJ;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_INTP;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ISFJ;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ISFP;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ISTJ;
import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ISTP;
import com.example.mobileprogramming_mbtiholic.Activity.mySetting;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTabFragment extends Fragment implements  View.OnClickListener {

    Button myBtn,btnenfj,btnenfp,btnentj,btnentp,btnesfj,btnesfp,btnestj,btnestp,btninfj,btninfp,btnintj,btnintp,btnisfj,btnisfp,btnistj,btnistp;
    public HomeTabFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home_tab, container, false); // 전체 뷰를 가져옴

        myBtn = view.findViewById(R.id.myBtn);
        myBtn.setOnClickListener(this); // 사용자 설정화면으로 넘어가기

        btnenfj = view.findViewById(R.id.btnENFJ);
        btnenfj.setOnClickListener(this); // _1_

        btnenfp = view.findViewById(R.id.btnENFP);
        btnenfp.setOnClickListener(this); // _2_

        btnentj = view.findViewById(R.id.btnENTJ);
        btnentj.setOnClickListener(this); // _3_

        btnentp = view.findViewById(R.id.btnENTP);
        btnentp.setOnClickListener(this); // _4_

        btnesfj = view.findViewById(R.id.btnESFJ);
        btnesfj.setOnClickListener(this); //_5_

        btnesfp = view.findViewById(R.id.btnESFP);
        btnesfp.setOnClickListener(this); // _6_

        btnestj = view.findViewById(R.id.btnESTJ);
        btnestj.setOnClickListener(this); // _7_

        btnestp = view.findViewById(R.id.btnESTP);
        btnestp.setOnClickListener(this); // _8_

        btninfj = view.findViewById(R.id.btnINFJ);
        btninfj.setOnClickListener(this); //_9_

        btninfp = view.findViewById(R.id.btnINFP);
        btninfp.setOnClickListener(this); // _10_

        btnintj = view.findViewById(R.id.btnINTJ);
        btnintj.setOnClickListener(this); // _11_

        btnintp = view.findViewById(R.id.btnINTP);
        btnintp.setOnClickListener(this); // _12_

        btnisfj = view.findViewById(R.id.btnISFJ);
        btnisfj.setOnClickListener(this); // _13_

        btnisfp = view.findViewById(R.id.btnISFP);
        btnisfp.setOnClickListener(this); // _14_

        btnistj = view.findViewById(R.id.btnISTJ);
        btnistj.setOnClickListener(this); // _15_

        btnistp = view.findViewById(R.id.btnISTP);
        btnistp.setOnClickListener(this); // _16_

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.myBtn://사용자 설정화면으로 넘어가기
                Intent intent_mySetting = new Intent(getActivity(), mySetting.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_mySetting);
                break;
            case R.id.btnENFJ: // _1_
                Intent intent_enfj = new Intent(getActivity(), personality_ENFJ.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_enfj);
                break;
            case R.id.btnENTJ: // _2_
                Intent intent_entj = new Intent(getActivity(), personality_ENTJ.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_entj);
                break;
            case R.id.btnENTP: // _3_
                Intent intent_entp   = new Intent(getActivity(), personality_ENTP.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_entp);
                break;
            case R.id.btnESFP: // _4_
                Intent intent_esfp = new Intent(getActivity(), personality_ESFP.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_esfp);
                break;
            case R.id.btnESTJ: // _5_
                Intent intent_estj = new Intent(getActivity(), personality_ESTJ.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_estj);
                break;
            case R.id.btnESTP: // _6_
                Intent intent_estp   = new Intent(getActivity(), personality_ESTP.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_estp);
                break;
            case R.id.btnINFJ: // _7_
                Intent intent_infj = new Intent(getActivity(), personality_INFJ.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_infj);
                break;
            case R.id.btnINFP: // _8_
                Intent intent_infp = new Intent(getActivity(), personality_INFP.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_infp);
                break;
            case R.id.btnINTJ: // _9_
                Intent intent_intj   = new Intent(getActivity(), personality_INTJ.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_intj);
                break;
            case R.id.btnINTP: // _10_
                Intent intent_intp = new Intent(getActivity(), personality_INTP.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_intp);
                break;
            case R.id.btnISFJ: // _11_
                Intent intent_isfj = new Intent(getActivity(), personality_ISFJ.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_isfj);
                break;
            case R.id.btnISFP: // _12_
                Intent intent_isfp   = new Intent(getActivity(), personality_ISFP.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_isfp);
                break;
            case R.id.btnISTP: // _13_
                Intent intent_istp   = new Intent(getActivity(), personality_ISTP.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_istp);
                break;
            case R.id.btnENFP: // _14_
                Intent intent_enfp = new Intent(getActivity(), personality_ENFP.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_enfp);
                break;
            case R.id.btnESFJ: // _15_
                Intent intent_esfj = new Intent(getActivity(), personality_ESFJ.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_esfj);
                break;
            case R.id.btnISTJ: // _16_
                Intent intent_istj   = new Intent(getActivity(), personality_ISTJ.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent_istj);
                break;




        }
    }
}
