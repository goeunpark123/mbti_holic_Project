package com.example.mobileprogramming_mbtiholic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobileprogramming_mbtiholic.PostItemList.PostItemListActivity;
import com.example.mobileprogramming_mbtiholic.domain.entity.PostBundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class PostTabFragment extends Fragment { //덤인데이터
    private PostBundlesRecyclerViewAdapter adapter;
    private ArrayList<PostBundle> listData = new ArrayList<>(); // 변수는 맘대로 하면 됨
    public PostTabFragment() {
        // Required empty public constructor
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        DatabaseReference postBundlesRef = FirebaseDatabase.getInstance().getReference("postBundles");
        postBundlesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listData.clear();
                for(DataSnapshot s : dataSnapshot.getChildren()) {
                    PostBundle postBundle = s.getValue(PostBundle.class);
                    postBundle.setId(s.getKey());
                    listData.add(postBundle);
                }
                if(adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_feed, container, false); // 전체 뷰를 가져옴
//        if(adapter== null) {
            RecyclerView recyclerView = view.findViewById(R.id.recyclerView); //리사이클러뷰 선어

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()); // 이 두줄 무조건 쓰고 넘어가야 됨(복붙해서 사용)
            recyclerView.setLayoutManager(linearLayoutManager);

            adapter = new PostBundlesRecyclerViewAdapter(listData); // 리사이클러뷰의 핵심. 어댑터를 잘 짜는게 핵심이다.......
            recyclerView.setAdapter(adapter); // 이 어댑터 써! 하고 셋팅하는 것
            adapter.setOnItemClickListener(new PostBundlesRecyclerViewAdapter.OnItemClickListener() { // 화면이동
                @Override
                public void onClick(View view, int position) { // 한칸 클릭했을때
                    Intent intent = new Intent(getActivity(), PostItemListActivity.class); // 액티비티 띄우기 전에 만드는 intent
                    intent.putExtra(PostItemListActivity.EXTRA_POST_BUNDLE_ID, listData.get(position).getId());
                    intent.putExtra(PostItemListActivity.EXTRA_POST_NAME, listData.get(position).getName());
                    startActivity(intent);
                }
            });
            adapter.setOnItemPinClickListener(new PostBundlesRecyclerViewAdapter.OnItemPinClickListener() {
                @Override
                public void onClick(View view, int position) { // 그 핀 클릭했을 때

                }
            });
            adapter.notifyDataSetChanged(); // 나지금 리스트 추가 아님 삭제 했어!! 알려줌. 그럼 리사이클러뷰가 다시 계산함.......
//        }
        return view;
    }

}

