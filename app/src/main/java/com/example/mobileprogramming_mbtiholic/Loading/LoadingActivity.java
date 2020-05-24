package com.example.mobileprogramming_mbtiholic.Loading;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.example.mobileprogramming_mbtiholic.R;

public class LoadingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        startLoading();
    }
    private void startLoading(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();

            }
        },2000);
    }
}
