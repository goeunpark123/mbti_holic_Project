package com.example.mobileprogramming_mbtiholic.PostItemList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming_mbtiholic.R;

import java.util.List;
import java.util.Map;

public class PostItemListRecyclerViewAdapter extends RecyclerView.Adapter<PostItemListRecyclerViewAdapter.ItemViewHolder> {
    private List<Map<String, Object>> itemList;
    private OnItemClickListener onItemClickListener;

    public PostItemListRecyclerViewAdapter(List<Map<String, Object>> itemList){
        this.itemList = itemList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_post_item_list, parent, false),
                onItemClickListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(itemList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView timeTextView;
        private TextView contentTextView;
        private TextView likeCountTextView;
        private TextView replyCountTextView;
        private int position;

        ItemViewHolder(View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

//            timeTextView = itemView.findViewById(R.id.timeTextView);
//            contentTextView = itemView.findViewById(R.id.contentTextView);
//            likeCountTextView = itemView.findViewById(R.id.likeCountTextView);
//            replyCountTextView = itemView.findViewById(R.id.replyCountTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view, position);
                }
            });
        }

        void onBind(Map<String, Object> item, int position) {
            this.position = position;

            // TODO FILL TEXTVIEW TEXT
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}