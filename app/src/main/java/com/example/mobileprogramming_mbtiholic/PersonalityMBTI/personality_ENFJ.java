package com.example.mobileprogramming_mbtiholic.PersonalityMBTI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.mobileprogramming_mbtiholic.R;

public class personality_ENFJ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_personality__enfj);

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();

        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.enfj_성격);
        ;       ts1.setIndicator("성격");
        tabHost1.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.enfj_직업);
        ts2.setIndicator("직업");
        tabHost1.addTab(ts2);
        TextView s_career = (TextView)findViewById(R.id.enfj_직업2);
        s_career.setMovementMethod(new ScrollingMovementMethod());
    }
}
