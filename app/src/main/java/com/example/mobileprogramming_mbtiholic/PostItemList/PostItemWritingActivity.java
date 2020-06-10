package com.example.mobileprogramming_mbtiholic.PostItemList;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming_mbtiholic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostItemWritingActivity extends AppCompatActivity {
    TextView write_title;
    EditText postItem_Write;
    Button  write_Finish, write_Cancle;

    public final static String EXTRA_POST_BUNDLE_ID = "POST_BUNDLE_ID";
    private String postBundleId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_item_each_write);

        //액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        
        postBundleId = getIntent().getStringExtra(EXTRA_POST_BUNDLE_ID);

        if(postBundleId == null || postBundleId.isEmpty()) {
            Toast.makeText(this, "EXTRA를 확인해주세요.", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        write_title = (TextView)findViewById(R.id.writingTextView);
        postItem_Write = (EditText)findViewById(R.id.postText);
        write_Finish = (Button)findViewById(R.id.writeFinish);
        write_Cancle = (Button)findViewById(R.id.writeCancle);

        write_Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = postItem_Write.getText().toString();

                if(content == null || content.isEmpty()) {
                    new AlertDialog.Builder(PostItemWritingActivity.this)
                            .setMessage("내용을 입력해주세요.")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //TODO focus postItem_Write
                                }
                            })
                            .setCancelable(false)
                            .create()
                            .show();
                    return;
                }

                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference newPost = database.getReference().child("postBundles").child(postBundleId).child("posts").push();
                newPost.child("user_id").setValue(userId);
                newPost.child("content").setValue(content);

                new AlertDialog.Builder(PostItemWritingActivity.this)
                        .setMessage("글을 작성하였습니다.")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                PostItemWritingActivity.this.finish();
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
            }
        });

        write_Cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostItemWritingActivity.this.finish();
            }
        });
    }
}
