package com.example.mobileprogramming_mbtiholic.PostItemList;

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

        getSupportActionBar().setTitle("ACTIONBAR");
        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //뒤로가기 버튼
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        /*getSupportActionBar().hide();*/


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

    //액션버튼 메뉴 액션바에 집어 넣기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //액션버튼을 클릭했을때의 동작
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        //or switch문을 이용하면 될듯 하다.
        if (id == R.id.action_search) {
            Toast.makeText(this, "검색 클릭", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        Intent intent = new Intent(this, PostItemInfoActivity.class);
        intent.putExtra("id", (Long)item.get("id"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, android.R.anim.fade_out);
    }
}
