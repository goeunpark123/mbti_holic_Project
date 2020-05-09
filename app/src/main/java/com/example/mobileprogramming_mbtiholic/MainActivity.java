package com.example.mobileprogramming_mbtiholic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnISTJ=(Button)findViewById(R.id.btnISTJ);
        Button btnISFJ=(Button)findViewById(R.id.btnISFJ);
        Button btnINFJ=(Button)findViewById(R.id.btnINFJ);
        Button btnINTJ=(Button)findViewById(R.id.btnINTJ);

        Button btnISTP=(Button)findViewById(R.id.btnISTP);
        Button btnISFP=(Button)findViewById(R.id.btnISFP);
        Button btnINFP=(Button)findViewById(R.id.btnINFP);
        Button btnINTP=(Button)findViewById(R.id.btnINTP);

        Button btnESTP=(Button)findViewById(R.id.btnESTP);
        Button btnESFP=(Button)findViewById(R.id.btnESFP);
        Button btnENFP=(Button)findViewById(R.id.btnENFP);
        Button btnENTP=(Button)findViewById(R.id.btnENTP);

        Button btnESTJ=(Button)findViewById(R.id.btnESTJ);
        Button btnESFJ=(Button)findViewById(R.id.btnESFJ);
        Button btnENFJ=(Button)findViewById(R.id.btnENTP);
        Button btnENTJ=(Button)findViewById(R.id.btnESFJ);

        btnISTJ.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ISTP.class);
                startActivity(intent);
            }
        });

        btnISFJ.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ISFJ.class);
                startActivity(intent);
            }
        });

        btnINFJ.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_INFJ.class);
                startActivity(intent);
            }
        });

        btnINTJ.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_INTJ.class);
                startActivity(intent);
            }
        });

        btnISTP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ISTP.class);
                startActivity(intent);
            }
        });

        btnISFP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ISFP.class);
                startActivity(intent);
            }
        });

        btnINFP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_INFP.class);
                startActivity(intent);
            }
        });

        btnINTP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_INTP.class);
                startActivity(intent);
            }
        });

        btnESTP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ESTP.class);
                startActivity(intent);
            }
        });

        btnESFP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ESFP.class);
                startActivity(intent);
            }
        });

        btnENFP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ENTP.class);
                startActivity(intent);
            }
        });

        btnENTP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ENTP.class);
                startActivity(intent);
            }
        });

        btnESTJ.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ESTJ.class);
                startActivity(intent);
            }
        });

        btnESFJ.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),personaltiy_ESFJ.class);
                startActivity(intent);
            }
        });

        btnENFJ.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ENFJ.class);
                startActivity(intent);
            }
        });

        btnENTJ.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), personality_ENTJ.class);
                startActivity(intent);
            }
        });
    }
}