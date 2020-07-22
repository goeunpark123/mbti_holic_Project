package com.mbtiholic.mobileprogramming_mbtiholic.Loading;
import android.app.Activity;
import android.os.Bundle;

import com.mbtiholic.mobileprogramming_mbtiholic.Main.LoginCheckAsyncTask;
import com.mbtiholic.mobileprogramming_mbtiholic.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoadingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        LoginCheckAsyncTask asyncTask = new LoginCheckAsyncTask(FirebaseAuth.getInstance(), this);
        asyncTask.execute();
    }
}
