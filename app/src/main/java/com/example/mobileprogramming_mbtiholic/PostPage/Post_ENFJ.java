package com.example.mobileprogramming_mbtiholic.PostPage;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.View;

import com.example.mobileprogramming_mbtiholic.PersonalityMBTI.personality_ISFJ;
import com.example.mobileprogramming_mbtiholic.R;
import com.example.mobileprogramming_mbtiholic.PostsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Post_ENFJ extends AppCompatActivity { //덤인데이터
    private PostsRecyclerViewAdapter adapter;
    GestureDetector gestureDetector;
    private ArrayList<Data> listData = new ArrayList<>(); // 변수는 맘대로 하면 됨
  //생성자는 웬만하면 만들지 마라


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView); //리사이클러뷰 선어

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Post_ENFJ.this); // 이 두줄 무조건 쓰고 넘어가야 됨(복붙해서 사용)
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PostsRecyclerViewAdapter(listData); // 리사이클러뷰의 핵심. 어댑터를 잘 짜는게 핵심이다.......
        recyclerView.setAdapter(adapter); // 이 어댑터 써! 하고 셋팅하는 것
        adapter.setOnItemClickListener(new PostsRecyclerViewAdapter.OnItemClickListener() { // 화면이동
            @Override
            public void onClick(View view, int position) { // 한칸 클릭했을때
                Intent intent = new Intent(Post_ENFJ.this, personality_ISFJ.class); // 액티비티 띄우기 전에 만드는 intent
                // intent.putExtra(키 번호,  ) // 다음 activity에서 내가 어디서 온건지도 알아야함
                intent.putExtra("user", listData.get(position));
                startActivity(intent);
            }

        });
        adapter.setOnItemPinClickListener(new PostsRecyclerViewAdapter.OnItemPinClickListener() {
            @Override
            public void onClick(View view, int position) { // 그 핀 클릭했을 때

            }
        });

        getData();

    }


    private void getData() {
        // 임의의 데이터입니다.
        List<String> listTitle = Arrays.asList(
                "제목1",
                "제목2",
                "제목3",
                "제목4",
                "제목5",
                "제목6",
                "제목7",
                "제목8",
                "제목9",
                "제목10",
                "제목11",
                "제목12"
        );
        List<String> listContent = Arrays.asList(
                "내용입니다1",
                "내용입니다2",
                "내용입니다3",
                "내용입니다4",
                "내용입니다5",
                "내용입니다6",
                "내용입니다7",
                "내용입니다8",
                "내용입니다9",
                "내용입니다10",
                "내용입니다11",
                "내용입니다12"

        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.feed_star
        );
        for (int i = 0; i < listTitle.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Data data = new Data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResId.get(0)); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...

            // 각 값이 들어간 data를 adapter에 추가합니다.
            listData.add(data);

        }
        adapter.notifyDataSetChanged(); // 나지금 리스트 추가 아님 삭제 했어!! 알려줌. 그럼 리사이클러뷰가 다시 계산함.......
    }


}

