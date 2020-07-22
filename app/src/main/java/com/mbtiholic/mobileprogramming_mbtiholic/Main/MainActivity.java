package com.mbtiholic.mobileprogramming_mbtiholic.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.mbtiholic.mobileprogramming_mbtiholic.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //여기에서 시작해서 로그인 했으면 MainTabActivity로 넘어가게 분기를 해줘야된다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_old);
//
//        try {
//            String token = MyFirebaseInstanceIdService.getInstance().getToken();
//            Log.d("IDService","device token : "+token);
//        }
//
//        catch (NullPointerException e) {
//            e.printStackTrace();
//        }

        LoginCheckAsyncTask asyncTask = new LoginCheckAsyncTask(FirebaseAuth.getInstance(), this);
        asyncTask.execute();
    }
}