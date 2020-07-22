package com.mbtiholic.mobileprogramming_mbtiholic.PostPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mbtiholic.mobileprogramming_mbtiholic.R;
import com.mbtiholic.mobileprogramming_mbtiholic.domain.entity.PostItem;

import java.util.ArrayList;

public class PostBundlesRecyclerViewAdapter extends RecyclerView.Adapter<PostBundlesRecyclerViewAdapter.ItemViewHolder> { // 이코드를 확실히 알아야함

    private ArrayList<PostItem> listData ; // 변수는 맘대로 하면 됨 // adapter에 들어갈 list 입니다.
    private OnItemClickListener onItemClickListener;
    private  OnItemPinClickListener onItemPinClickListener;

    public PostBundlesRecyclerViewAdapter(ArrayList<PostItem> listData){
        this.listData = listData;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemPinClickListener(OnItemPinClickListener onItemPinClickListener) { // Pin을 위한
        this.onItemPinClickListener = onItemPinClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // 뷰 한칸(라인한줄) 만드는 코드. 데이터를 넣는게 아니라 뷰만 넣음
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_each, parent, false); // feed_item이 한칸의 xml임. 이 xml로 한칸을 구현하면 됨
        return new ItemViewHolder(view, onItemClickListener, onItemPinClickListener);
    } // 한 사이클을 넘어가면 뷰는 재사용한다.

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) { // 데이터를 넣음. 여기가 그 한칸(한줄)에 대한 데이터.ItemViewHolder 하나 만들고 여기서 하나 채움
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position),position);
    }// 여기서 ex)1번 내용을 14번 내용으로 덮어쓰기함. 그렇게 하면 재사용이 가능해지고 데이터만 바뀜

    @Override
    public int getItemCount() {
        // RecyclerView가 몇칸을 그려야되는지.. 아이템 한칸한칸일때 몇칸
        return listData.size();
    }
    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder { // 한칸의 뷰를 만들었을때 거기에 담을 내용. 바인딩 해놓을려고 만드는 함수

        private TextView textView1;
        private TextView textView2;
        private ImageView imageView;
        private int position;

        ItemViewHolder(View itemView, final OnItemClickListener onItemClickListener, final OnItemPinClickListener onItemPinClickListener) { // 내용 입을 애들을 미리 바인딩 해놓음ㅁ
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1); // 뷰바인딩
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onClick(view,position);
                }
            });
            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemPinClickListener.onClick(view, position);
                }
            });

        }

        void onBind(PostItem postItem, int position) { // 만들고 싶은 함수를 만듦. 중요한건 밖에서부터 매게변수를 받아서 setText, setImageResoure를 하려는 것.
            this.position = position;
            textView1.setText(postItem.getName());
            textView2.setText(postItem.getExplain());
            //imageView.setImageResource(data.getResId());
            Glide.with(itemView).load(R.drawable.feed_icon).into(imageView); // 앞으로 이미지 넣을때 이 코드로 넣어야 메모리가 관리된다.
        }
    }

    public interface OnItemClickListener
    {
        void onClick(View view, int position);
    }
    public interface OnItemPinClickListener
    {
        void onClick(View view, int position);
    }
}