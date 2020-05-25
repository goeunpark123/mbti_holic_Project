package com.example.mobileprogramming_mbtiholic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class TestTabFragment extends Fragment implements  View.OnClickListener {

    Button btnTest;
    public TestTabFragment() {

    }
public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);



}

    @Override
    public void onClick(View v) {
        btnTest.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.16personalities.com/ko/%EB%AC%B4%EB%A3%8C-%EC%84%B1%EA%B2%A9-%EC%9C%A0%ED%98%95-%EA%B2%80%EC%82%AC");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

    }
}






