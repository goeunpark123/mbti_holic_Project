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
import androidx.core.app.ActivityCompat;

import com.example.mobileprogramming_mbtiholic.Main.MainActivity;
import com.example.mobileprogramming_mbtiholic.R;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class mySetting extends AppCompatActivity {
    private FirebaseAuth mAuth ;

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
        final Button btn2_withDrawBtn= (Button) findViewById(R.id.btn2_withDrawBtn);

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
                        signOut(); // 파이어베이스 로그아웃 구현
                        finish();
                        Toast.makeText(mySetting.this, "로그아웃 되었습니다. 앱을 종료 후 다시 실행시켜주십시오.", Toast.LENGTH_SHORT).show();;


                    }
                });
                logoutDialog.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                logoutDialog.create();
                logoutDialog.show();
            }
        });
        btn2_withDrawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder logoutDialog2 = new AlertDialog.Builder(mySetting.this);
                logoutDialog2.setTitle("탈퇴하기");
                logoutDialog2.setMessage("탈퇴 하시겠습니까?");
                logoutDialog2.setPositiveButton("탈퇴", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mySetting.this, "탈퇴되셨습니다. 앱을 종료 후 다시 실행시켜주십시오.", Toast.LENGTH_SHORT).show();;

                        revokeAccess(); // 파이어베이스 로그아웃 구현
                        System.runFinalizersOnExit(true);
                        System.exit(0);

                    }
                });
                logoutDialog2.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                logoutDialog2.create();
                logoutDialog2.show();
            }
        });
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

    private void revokeAccess() {
        mAuth.getCurrentUser().delete();
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
