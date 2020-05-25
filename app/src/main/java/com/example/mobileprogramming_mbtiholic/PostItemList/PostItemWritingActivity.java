package com.example.mobileprogramming_mbtiholic.PostItemList;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming_mbtiholic.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class PostItemWritingActivity extends AppCompatActivity {
    TextView write_title;
    EditText postItem_Write;
    Button  write_Finish, write_Cancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postitem_write);
        write_title = (TextView)findViewById(R.id.writingTextView);
        postItem_Write = (EditText)findViewById(R.id.postText);
        write_Finish = (Button)findViewById(R.id.writeFinish);
        write_Cancle = (Button)findViewById(R.id.writeCancle);

        write_Cancle.setOnClickListener();

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference newPost = database.getReference().child("postBundles").child("게시판이름").child("posts").push();
        newPost.child("user_id").setValue(userId);
        newPost.child("content").setValue("글내용");

    }
}
