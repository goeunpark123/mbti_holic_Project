package com.example.mobileprogramming_mbtiholic;

import android.util.Log;

public class MyFirebaseInstanceIdService extends MyFirebaseMessagingService {



    private void sendRegistrationToServer(String token){
        //디바이스 토큰이 생성되거나 재생성 될 시 동작할 코드 작성
    }

    FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
        @Override
        public void onComplete(@NonNull Task<InstanceIdResult> task) {
            if (!task.isSuccessful()) {
                Log.w(TAG, "getInstanceId failed", task.getException());
                return;
            }

            // Get new Instance ID token
            String token = task.getResult().getToken();

            // Log and toast
            String msg = getString(R.string.msg_token_fmt, token);
            Log.d(TAG, msg);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    });
}
