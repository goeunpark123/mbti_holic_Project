package com.mbtiholic.mobileprogramming_mbtiholic;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class RelationshipActivity extends AppCompatActivity {
    TextView text1, text2;
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
            case 1:
                text1.setText(" 0% ");
                text2.setText(" 궁합 최악! 서로 많이 노력해보아요 ");
                break;
            case 2:
                text1.setText(" 25% ");
                text2.setText(" 잘 안맞는 관계! 서로가 서로에게 더 많이 배려해주세요. ");
                break;

            case 3:
                text1.setText(" 50% ");
                text2.setText(" 반반관계! 잘 맞지도, 안 맞지도 않는 비즈니스 관계 ");
                break;

            case 4:
                text1.setText(" 75% ");
                text2.setText(" 좋은관계! 좋은 친구가 될 수 있는 우호적인 관계 ");
                break;
            case 5:
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