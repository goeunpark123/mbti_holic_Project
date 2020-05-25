package com.example.mobileprogramming_mbtiholic.TestPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mobileprogramming_mbtiholic.R;

public class TestTabFragment extends Fragment {

    Button btnTest;
    public TestTabFragment() {

    }
    public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_test, container, false); // 전체 뷰를 가져옴
        btnTest = view.findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() { // 검사 메뉴에서 검사버튼 클릭 시
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.16personalities.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri); // 액티비티 띄우기 전에 만드는 intent
                startActivity(intent);
            }
        });
        return view;
    }
}






