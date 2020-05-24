package com.example.mobileprogramming_mbtiholic.PostItemList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobileprogramming_mbtiholic.PostItemInfo.PostItemInfoActivity;
import com.example.mobileprogramming_mbtiholic.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PostItemListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, PostItemListRecyclerViewAdapter.OnItemClickListener {
    // views
    private SwipeRefreshLayout swipeRefreshLayout;

    private PostItemListRecyclerViewAdapter recyclerViewAdapter;
    private List<Map<String, Object>> itemList = new LinkedList<>();

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

        recyclerViewAdapter = new PostItemListRecyclerViewAdapter(itemList); // 리사이클러뷰의 핵심. 어댑터를 잘 짜는게 핵심이다.......
        recyclerView.setAdapter(recyclerViewAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerViewAdapter.setOnItemClickListener(this);

        onRefresh();
    }

    @Override
    public void onRefresh() {
        // TODO Reload ITEM LIST from FIREBASE

        itemList.add(new HashMap<String, Object>());
        itemList.add(new HashMap<String, Object>());
        itemList.add(new HashMap<String, Object>());

        recyclerViewAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(View view, int position) {
        Map<String, Object> item = itemList.get(position);

    }
}
