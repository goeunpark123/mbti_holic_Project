package com.example.mobileprogramming_mbtiholic;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RelationshipTabFragment extends Fragment {
    Button btn_M_P;
    public RelationshipTabFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_relationship_tab, container, false); // 전체 뷰를 가져옴
        // 홈메뉴에서 istj버튼 클릭시 istj뷰를 나오게 하기 위해
        btn_M_P = view.findViewById(R.id.btn_m_p); // 홈메뉴에서 istj버튼 클릭시 istj뷰를 나오게 하기 위해
        btn_M_P.setOnClickListener(new View.OnClickListener() { // 홈메뉴에서 istj버튼 클릭시
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RelationshipActivity.class); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent);
            }
        });
        return view;
    }
}
