package com.example.mobileprogramming_mbtiholic.Activity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming_mbtiholic.R;

import org.w3c.dom.Text;

public class mySetting extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysetting);

        TextView tv1_myInfoText = (TextView) findViewById(R.id.tv1_myInfoText);
        Button btn1_backBtn = (Button) findViewById(R.id.btn1_backBtn);
        ImageView image1_myMBTIimage = (ImageView) findViewById(R.id.image1_myMBTIimage);
        TextView tv2_myID = (TextView) findViewById(R.id.tv2_myID);
        TextView tv3_myName = (TextView) findViewById(R.id.tv3_myName);
        TextView tv4_setMyMBTI = (TextView) findViewById(R.id.tv4_setMyMBTI);
        Button btn2_logoutBtn = (Button) findViewById(R.id.btn2_logoutBtn);

        Spinner mbtiSpinner = (Spinner) findViewById(R.id.mbtiSpinner);
        ArrayAdapter mbtiAdapter = ArrayAdapter.createFromResource(this, R.array.mbti_type, android.R.layout.simple_spinner_item);
        mbtiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mbtiSpinner.setAdapter(mbtiAdapter);
    }
}
