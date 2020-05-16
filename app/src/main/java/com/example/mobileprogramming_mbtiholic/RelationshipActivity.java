package com.example.mobileprogramming_mbtiholic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class RelationshipActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relationship_result);

        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);

        int num = rand.nextInt(3);

        switch (num) {
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
    }


}