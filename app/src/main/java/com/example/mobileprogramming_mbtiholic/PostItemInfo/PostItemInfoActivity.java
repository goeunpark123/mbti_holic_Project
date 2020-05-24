package com.example.mobileprogramming_mbtiholic.PostItemInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mobileprogramming_mbtiholic.PostItemList.PostItemListRecyclerViewAdapter;
import com.example.mobileprogramming_mbtiholic.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PostItemInfoActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, PostItemInfoRecyclerViewAdapter.OnPostLikeClickListener, PostItemInfoRecyclerViewAdapter.OnReplyLikeClickListener, PostItemInfoRecyclerViewAdapter.OnReplyMenuClickListener {
    // views
    private SwipeRefreshLayout swipeRefreshLayout;

    private PostItemInfoRecyclerViewAdapter recyclerViewAdapter;
    private Map<String, Object> post = new HashMap<>();
    private List<Map<String, Object>> replyList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        // TODO getIntent().getStringExtra() 를 이용하여 어떤 게시판인지 확인해야합니다.

        setContentView(R.layout.activity_post_item_list);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this); // 이 두줄 무조건 쓰고 넘어가야 됨(복붙해서 사용)
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerViewAdapter = new PostItemInfoRecyclerViewAdapter(replyList); // 리사이클러뷰의 핵심. 어댑터를 잘 짜는게 핵심이다.......
        recyclerView.setAdapter(recyclerViewAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerViewAdapter.setOnPostLikeClickListener(this);
        recyclerViewAdapter.setOnReplyLikeClickListener(this);
        recyclerViewAdapter.setOnReplyMenuClickListener(this);

        onRefresh();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, R.anim.slide_out_right);
    }

    @Override
    public void onRefresh() {
        // TODO Reload ITEM LIST from FIREBASE

        recyclerViewAdapter.setPost(post);

        replyList.add(new HashMap<String, Object>());
        replyList.add(new HashMap<String, Object>());
        replyList.add(new HashMap<String, Object>());

        recyclerViewAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onPostLikeClick(View view) {
        // TODO
        Toast.makeText(this, "post like", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReplyLikeClick(View view, int position) {
        // TODO
        Toast.makeText(this, "reply like", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReplyMenuClick(View view, int position) {
        // TODO
        Toast.makeText(this, "reply menu", Toast.LENGTH_SHORT).show();
    }
}
