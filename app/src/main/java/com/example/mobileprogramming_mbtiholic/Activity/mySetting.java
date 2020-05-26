package com.example.mobileprogramming_mbtiholic.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming_mbtiholic.Main.MainActivity;
import com.example.mobileprogramming_mbtiholic.R;

import org.w3c.dom.Text;

public class mySetting extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysetting);

        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //뒤로가기 버튼
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("내 정보");

        ImageView image1_myMBTIimage = (ImageView) findViewById(R.id.image1_myMBTIimage);
        TextView tv2_myID = (TextView) findViewById(R.id.tv2_myID);
        TextView tv3_myName = (TextView) findViewById(R.id.tv3_myName);
        TextView tv4_setMyMBTI = (TextView) findViewById(R.id.tv4_setMyMBTI);
        final Button btn2_logoutBtn = (Button) findViewById(R.id.btn2_logoutBtn);

        Spinner mbtiSpinner = (Spinner) findViewById(R.id.mbtiSpinner);
        ArrayAdapter mbtiAdapter = ArrayAdapter.createFromResource(this, R.array.mbti_type, android.R.layout.simple_spinner_item);
        mbtiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mbtiSpinner.setAdapter(mbtiAdapter);

        btn2_logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder logoutDialog = new AlertDialog.Builder(mySetting.this);
                logoutDialog.setTitle("로그아웃");
                logoutDialog.setMessage("로그아웃 하시겠습니까?");
                logoutDialog.setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mySetting.this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                logoutDialog.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                logoutDialog.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                logoutDialog.create();
                logoutDialog.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
