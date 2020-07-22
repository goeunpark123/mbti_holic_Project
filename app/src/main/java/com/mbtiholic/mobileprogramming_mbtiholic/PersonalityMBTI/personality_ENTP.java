package com.mbtiholic.mobileprogramming_mbtiholic.PersonalityMBTI;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import com.mbtiholic.mobileprogramming_mbtiholic.R;

public class personality_ENTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_personality__entp);

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();

        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.entp_성격);
        ;       ts1.setIndicator("성격");
        tabHost1.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.entp_직업);
        ts2.setIndicator("직업");
        tabHost1.addTab(ts2);
        TextView s_career = (TextView)findViewById(R.id.entp_직업2);
        s_career.setMovementMethod(new ScrollingMovementMethod());

        // 액션과 관련 코드 시작
        getSupportActionBar().setTitle("MBTI 16가지 유형");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFDFC8F8)); //0xFFECE0F8
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //뒤로가기 버튼
        getSupportActionBar().setDisplayShowHomeEnabled(true);
// 액션과 관련 코드 끝
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
