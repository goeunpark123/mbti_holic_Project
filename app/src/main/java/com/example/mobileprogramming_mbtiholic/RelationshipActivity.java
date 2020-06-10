package com.example.mobileprogramming_mbtiholic;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileprogramming_mbtiholic.RelationshipTabFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mobileprogramming_mbtiholic.PostItemList.PostItemWritingActivity;

import java.util.Random;

public class RelationshipActivity extends AppCompatActivity {

    TextView text1, text2, mbtiText1, mbtiText2;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relationship_result);

        //액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //액티비티 간의 넘겨준 데이터를 받음
        Intent intent = getIntent();
        int relationResult = intent.getExtras().getInt("relationResult");

        Button backBtn = (Button)findViewById(R.id.backBtn);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);

        //case4만들기
        switch (relationResult) {
            case 0:
                text1.setText(" 25% ");
                text2.setText(" 잘 안맞는 관계! 서로가 서로에게 더 많이 배려해주세요. ");
                break;
            case 1:
                text1.setText(" 50% ");
                text2.setText(" 반반관계! 잘 맞지도, 안 맞지도 않는 비즈니스 관계 ");
                break;
            case 2:
                text1.setText(" 75% ");
                text2.setText(" 좋은관계! 좋은 친구가 될 수 있는 우호적인 관계 ");
                break;
            case 3:
                text1.setText(" 100% ");
                text2.setText(" 만나자마자 짱친! 뭘하던 친구가 되는 최고의 관계 ");
                break;
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelationshipActivity.this.finish();
            }
        });
    }


}