package com.mbtiholic.mobileprogramming_mbtiholic;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbtiholic.mobileprogramming_mbtiholic.PostPage.Data;
import com.mbtiholic.mobileprogramming_mbtiholic.PostPage.PostsRecyclerViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageTabFragment extends Fragment { //덤인데이터
    private PostsRecyclerViewAdapter adapter;
    GestureDetector gestureDetector;
    private ArrayList<Data> listData = new ArrayList<>(); // 변수는 맘대로 하면 됨


    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message, container, false); // 전체 뷰를 가져옴
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView); //리사이클러뷰 선어

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()); // 이 두줄 무조건 쓰고 넘어가야 됨(복붙해서 사용)
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PostsRecyclerViewAdapter(listData); // 리사이클러뷰의 핵심. 어댑터를 잘 짜는게 핵심이다
        recyclerView.setAdapter(adapter); // 이 어댑터 써! 하고 셋팅하는 것
        adapter.setOnItemClickListener(new PostsRecyclerViewAdapter.OnItemClickListener() { // 화면이동
            @Override
            public void onClick(View view, int position) { // 한칸 클릭했을때

                if(position == 0) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle(" E = 외향형");
                    dlg.setMessage("폭넓은 대인관계 유지, 사교적, 정열적, 활동적");
                    dlg.setIcon(R.drawable.ic_mail_outline);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
                if(position == 1 ) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle(" I = 내향형");
                    dlg.setMessage("깊이있는 대인관계 유지, 조용하고 신중, 이해한 다음에 경험");
                    dlg.setIcon(R.drawable.ic_mail_outline);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }

                if(position == 2 ) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle(" S = 감각형");
                    dlg.setMessage("오감에 의존, 실제 경험 중시, 현재에 초점을 맞추고 정확, 철저히 일처리");
                    dlg.setIcon(R.drawable.ic_mail_outline);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
                if(position == 3 ) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle(" N = 직관형");
                    dlg.setMessage("육감 내지 영감에 의존, 미래지향적, 가능성과 의미 추구, 신속, 비약적으로 일처리");
                    dlg.setIcon(R.drawable.ic_mail_outline);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }

                if(position == 4 ) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle(" T = 사고형");
                    dlg.setMessage("진실과 사실에 주관심, 논리적, 분석적, 객관적 판단");
                    dlg.setIcon(R.drawable.ic_mail_outline);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }

                if(position == 5 ) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle(" F = 감정형");
                    dlg.setMessage("사람과 관계에 주관심, 상확적, 정상을 참작한 설명");
                    dlg.setIcon(R.drawable.ic_mail_outline);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
                if(position == 6 ) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle(" J = 판단형");
                    dlg.setMessage("분명한 목적과 방향, 기한 엄수, 철저한 사전계획, 체계적");
                    dlg.setIcon(R.drawable.ic_mail_outline);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
                if(position == 7 ) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                    dlg.setTitle(" P = 인식형");
                    dlg.setMessage("목적과 방향은 변화 가능, 상황에 따라 일정 변경, 자율적이고 융통성 있다.");
                    dlg.setIcon(R.drawable.ic_mail_outline);
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
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


        //for (int i = 1; i < 5; i++) {
//            // 각 List의 값들을 data 객체에 set 해줍니다. 이게 핵심이다. 위에 코드 쓰레기 지움
//            Data data = new Data();
//            data.setTitle("알림");
//            data.setContent("내가 쓴 글에 좋아요가 달렸습니다 ");
//            data.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
//            // 각 값이 들어간 data를 adapter에 추가합니다.
//            listData.add(data);
//      //  }

        Data data = new Data();
        data.setTitle("E (Extraversion)  ");
        data.setContent("에너지 방향, 주의 초점 (클릭)");
        data.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
        // 각 값이 들어간 data를 adapter에 추가합니다.
        listData.add(data);

        Data data1 = new Data();
        data1.setTitle("I (Introversion) ");
        data1.setContent("에너지 방향, 주의 초점 (클릭)");
        data1.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
        // 각 값이 들어간 data를 adapter에 추가합니다.
        listData.add(data1);

        Data data2 = new Data();
        data2.setTitle("S (Sensing) ");
        data2.setContent("인식기능, 정보수집 (클릭)");
        data2.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
        // 각 값이 들어간 data를 adapter에 추가합니다.
        listData.add(data2);

        Data data3 = new Data();
        data3.setTitle("N (Intuition) ");
        data3.setContent("인식기능, 정보수집 (클릭)");
        data3.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
        // 각 값이 들어간 data를 adapter에 추가합니다.
        listData.add(data3);

        Data data4 = new Data();
        data4.setTitle("T (Thinking) ");
        data4.setContent("판단기능, 결정기능 (클릭)");
        data4.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
        // 각 값이 들어간 data를 adapter에 추가합니다.
        listData.add(data4);

        Data data5 = new Data();
        data5.setTitle("F (Feeling) ");
        data5.setContent("판단기능, 결정기능 (클릭)");
        data5.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
        // 각 값이 들어간 data를 adapter에 추가합니다.
        listData.add(data5);

        Data data6 = new Data();
        data6.setTitle("J (Judging) ");
        data6.setContent("이행양식, 생활양식 (클릭)");
        data6.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
        // 각 값이 들어간 data를 adapter에 추가합니다.
        listData.add(data6);

        Data data7 = new Data();
        data7.setTitle("P (Perceiving) ");
        data7.setContent("이행양식, 생활양식 (클릭)");
        data7.setResId(R.drawable.message); // 이걸 i가 아닌 0으로 해주면 서로 숫자 안맞아도.. 데이터 출력 가능...
        // 각 값이 들어간 data를 adapter에 추가합니다.
        listData.add(data7);

    }


}

