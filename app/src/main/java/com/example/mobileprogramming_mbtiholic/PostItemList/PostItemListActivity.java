package com.example.mobileprogramming_mbtiholic.PostItemList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mobileprogramming_mbtiholic.PostItemInfo.PostItemInfoActivity;
import com.example.mobileprogramming_mbtiholic.R;
import com.example.mobileprogramming_mbtiholic.domain.entity.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

public class PostItemListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, PostItemListRecyclerViewAdapter.OnItemClickListener {
    // views
    private SwipeRefreshLayout swipeRefreshLayout;

    private PostItemListRecyclerViewAdapter recyclerViewAdapter;
    private List<Post> itemList = new LinkedList<>();

    public final static String EXTRA_POST_BUNDLE_ID = "POST_BUNDLE_ID";
    private String postBundleId;
    public final static String EXTRA_POST_NAME = "POST_NAME";
    private String postName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_item_list);

        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFFEC0CF));
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //뒤로가기 버튼
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        postBundleId = getIntent().getStringExtra(EXTRA_POST_BUNDLE_ID);
        postName = getIntent().getStringExtra(EXTRA_POST_NAME);

        if(postBundleId == null || postBundleId.isEmpty() || postName == null || postName.isEmpty()) {
            Toast.makeText(this, "EXTRA를 확인해주세요.", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        setTitle(postName);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this); // 이 두줄 무조건 쓰고 넘어가야 됨(복붙해서 사용)
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerViewAdapter = new PostItemListRecyclerViewAdapter(itemList); // 리사이클러뷰의 핵심. 어댑터를 잘 짜는게 핵심이다.......
        recyclerView.setAdapter(recyclerViewAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerViewAdapter.setOnItemClickListener(this);

        onRefresh();
    }

    //액션버튼 메뉴 액션바에 집어 넣기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_item_list_menu, menu);
        return true;
    }

    //액션버튼을 클릭했을때의 동작
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "검색 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_post_write:
                Intent intent = new Intent(this, PostItemWritingActivity.class);
                intent.putExtra(PostItemWritingActivity.EXTRA_POST_BUNDLE_ID, postBundleId);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        // TODO Reload ITEM LIST from FIREBASE

        DatabaseReference postsRef = FirebaseDatabase.getInstance().getReference("postBundles").child(postBundleId).child("posts");
        postsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemList.clear();
                for(DataSnapshot s : dataSnapshot.getChildren()) {
                    Post post = s.getValue(Post.class);
                    post.setId(s.getKey());
                    itemList.add(post);
                }
                if(recyclerViewAdapter != null) {
                    recyclerViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        recyclerViewAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(View view, int position) {
        Post item = itemList.get(position);

        Intent intent = new Intent(this, PostItemInfoActivity.class);
        intent.putExtra(PostItemInfoActivity.EXTRA_POST_BUNDLE_ID, postBundleId);
        intent.putExtra(PostItemInfoActivity.EXTRA_POST_ID, item.getId());
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, android.R.anim.fade_out);
    }
}
