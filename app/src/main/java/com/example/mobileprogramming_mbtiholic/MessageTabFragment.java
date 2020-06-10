package com.example.mobileprogramming_mbtiholic;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobileprogramming_mbtiholic.PostPage.Data;
import com.example.mobileprogramming_mbtiholic.PostPage.PostsRecyclerViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageTabFragment extends Fragment { //덤인데이터
    private PostsRecyclerViewAdapter adapter;
    GestureDetector gestureDetector;
    private ArrayList<Data> listData = new ArrayList<>(); // 변수는 맘대로 하면 됨


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message, container, false); // 전체 뷰를 가져옴
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView); //리사이클러뷰 선어

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()); // 이 두줄 무조건 쓰고 넘어가야 됨(복붙해서 사용)
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PostsRecyclerViewAdapter(listData); // 리사이클러뷰의 핵심. 어댑터를 잘 짜는게 핵심이다
        recyclerView.setAdapter(adapter); // 이 어댑터 써! 하고 셋팅하는 것
        adapter.setOnItemClickListener(new PostsRecyclerViewAdapter.OnItemClickListener() { // 화면이동
            @Override
            public void onClick(View view, int position) { // 한칸 클릭했을때
            }

        });
        adapter.setOnItemPinClickListener(new PostsRecyclerViewAdapter.OnItemPinClickListener() {
            @Override
            public void onClick(View view, int position) { // 그 핀 클릭했을 때

            }
        });
        adapter.notifyDataSetChanged(); // 나지금 리스트 추가 아님 삭제 했어!! 알려줌. 그럼 리사이클러뷰가 다시 계산함

//        }
        return view;
    }


    public void onAttach(Context context) {
        super.onAttach(context);
        getData(); //방금 만든 함수 호출
    }


    private void getData() {
        // 임의의 데이터입니다.


        for (int i = 1; i < 5; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다. 이게 핵심이다. 위에 코드 쓰레기 지움
            Data data = new Data();
            data.setTitle("알림");
            data.setContent("내가 쓴 글에 좋아요가 달렸습니다 "+i);
            data.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...

            // 각 값이 들어간 data를 adapter에 추가합니다.
            listData.add(data);
        }

    }


}

