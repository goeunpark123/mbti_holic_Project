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
import com.example.mobileprogramming_mbtiholic.domain.entity.User;

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

        mbtiSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                User user = new User();
                switch(i) {
                    case 0:
                        user.setMbti("ISTJ");
                        String str = user.getMbti();
                        if(user.getMbti() == "ISTJ")
                            Toast.makeText(mySetting.this, "mbti가 ISTJ로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        user.setMbti("ISFJ");
                        if(user.getMbti() == "ISFJ")
                            Toast.makeText(mySetting.this, "mbti가 ISFJ로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        user.setMbti("INFJ");
                        if(user.getMbti() == "INFJ")
                            Toast.makeText(mySetting.this, "mbti가 INFJ로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        user.setMbti("INTJ");
                        if(user.getMbti() == "INTJ")
                            Toast.makeText(mySetting.this, "mbti가 INTJ로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        user.setMbti("ISTP");
                        if(user.getMbti() == "ISTP")
                            Toast.makeText(mySetting.this, "mbti가 ISTP로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        user.setMbti("ISFP");
                        if(user.getMbti() == "ISFP")
                            Toast.makeText(mySetting.this, "mbti가 ISFP로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        user.setMbti("INFP");
                        if(user.getMbti() == "INFP")
                            Toast.makeText(mySetting.this, "mbti가 INFP로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        user.setMbti("INTP");
                        if(user.getMbti() == "INTP")
                            Toast.makeText(mySetting.this, "mbti가 INTP로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        user.setMbti("ESTP");
                        if(user.getMbti() == "ESTP")
                            Toast.makeText(mySetting.this, "mbti가 ESTP로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        user.setMbti("ESFP");
                        if(user.getMbti() == "ESFP")
                            Toast.makeText(mySetting.this, "mbti가 ESFP로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        user.setMbti("ENFP");
                        if(user.getMbti() == "ENFP")
                            Toast.makeText(mySetting.this, "mbti가 ENFP로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        user.setMbti("ENTP");
                        if(user.getMbti() == "ENTP")
                            Toast.makeText(mySetting.this, "mbti가 ENTP로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 12:
                        user.setMbti("ESTJ");
                        if(user.getMbti() == "ESTJ")
                            Toast.makeText(mySetting.this, "mbti가 ESTJ로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                        user.setMbti("ESFJ");
                        if(user.getMbti() == "ESFJ")
                            Toast.makeText(mySetting.this, "mbti가 ESFJ로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 14:
                        user.setMbti("ENFJ");
                        if(user.getMbti() == "ENFJ")
                            Toast.makeText(mySetting.this, "mbti가 ENFJ로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    case 15:
                        user.setMbti("ENTJ");
                        if(user.getMbti() == "ENTJ")
                            Toast.makeText(mySetting.this, "mbti가 ENTJ로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mySetting.this, "오류발생. 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
