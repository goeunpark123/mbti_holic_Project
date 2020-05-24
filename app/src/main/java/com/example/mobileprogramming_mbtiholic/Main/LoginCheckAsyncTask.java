package com.example.mobileprogramming_mbtiholic.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.mobileprogramming_mbtiholic.Login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginCheckAsyncTask extends AsyncTask<Void, Integer, Boolean> {
    FirebaseAuth firebaseAuth;
    Activity activity;

    public LoginCheckAsyncTask(FirebaseAuth firebaseAuth, Activity activity) {
        this.firebaseAuth = firebaseAuth;
        this.activity = activity;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try { Thread.sleep(1000L); } catch (Exception e) { }

        return firebaseAuth.getCurrentUser() != null;
    }

    @Override
    protected void onPostExecute(Boolean isExistCurrentUser) {
        Class<? extends Activity> targetActivity = isExistCurrentUser ? MainTabActivity.class : LoginActivity.class;
        Intent intent = new Intent(activity, targetActivity);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
