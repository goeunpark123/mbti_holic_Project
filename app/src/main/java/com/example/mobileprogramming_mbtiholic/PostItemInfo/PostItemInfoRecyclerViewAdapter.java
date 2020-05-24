package com.example.mobileprogramming_mbtiholic.PostItemInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.mobileprogramming_mbtiholic.R;

import java.util.List;
import java.util.Map;

public class PostItemInfoRecyclerViewAdapter extends Adapter<ViewHolder> {
    private Map<String, Object> post;
    private List<Map<String, Object>> replyList;
    private OnPostLikeClickListener onPostLikeClickListener;
    private OnReplyLikeClickListener onReplyLikeClickListener;
    private OnReplyMenuClickListener onReplyMenuClickListener;

    private final int ITEM_VIEW_TYPE_POST = 1; // HEADER
    private final int ITEM_VIEW_TYPE_REPLY = 2;

    public PostItemInfoRecyclerViewAdapter(List<Map<String, Object>> replyList){
        this.replyList = replyList;
    }

    public void setPost(Map<String, Object> post) {
        this.post = post;
    }

    public void setOnPostLikeClickListener(OnPostLikeClickListener onPostLikeClickListener) {
        this.onPostLikeClickListener = onPostLikeClickListener;
    }

    public void setOnReplyLikeClickListener(OnReplyLikeClickListener onReplyLikeClickListener) {
        this.onReplyLikeClickListener = onReplyLikeClickListener;
    }

    public void setOnReplyMenuClickListener(OnReplyMenuClickListener onReplyMenuClickListener) {
        this.onReplyMenuClickListener = onReplyMenuClickListener;
    }

    private int getReplyIndexByPosition(int position) {
        return position - 1;
    }

    private Map<String, Object> getReplyByPosition(int position) {
        int index = getReplyIndexByPosition(position);
        return index >= replyList.size() ? null : replyList.get(index);
    }

    @Override
    public int getItemCount() {
        return 1 + replyList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? ITEM_VIEW_TYPE_POST : ITEM_VIEW_TYPE_REPLY;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_VIEW_TYPE_POST:
                return new PostViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_post_item_info_post, parent, false),
                        onPostLikeClickListener
                );
            case ITEM_VIEW_TYPE_REPLY:
                return new ReplyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_post_item_info_reply, parent, false),
                        onReplyLikeClickListener,
                        onReplyMenuClickListener
                );
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int viewHolderType = getItemViewType(position);
        switch (viewHolderType) {
            case ITEM_VIEW_TYPE_POST:
                ((PostViewHolder)holder).onBind(post);
                break;
            case ITEM_VIEW_TYPE_REPLY:
                Map<String, Object> reply = getReplyByPosition(position);
                int replyIndex = getReplyIndexByPosition(position);
                ((ReplyViewHolder)holder).onBind(reply, replyIndex);
                break;
        }
    }

    class PostViewHolder extends ViewHolder {
        PostViewHolder(View itemView, final OnPostLikeClickListener onPostLikeClickListener) {
            super(itemView);

            // TODO Bind view
            // TODO onPostLikeClickListener
        }

        void onBind(Map<String, Object> item) {
            // TODO FILL TEXTVIEW TEXT
        }
    }

    class ReplyViewHolder extends ViewHolder {
        private int replyIndex;

        ReplyViewHolder(View itemView, final OnReplyLikeClickListener onReplyLikeClickListener, final OnReplyMenuClickListener onReplyMenuClickListener) {
            super(itemView);

            // TODO Bind view
            // TODO onReplyLikeClickListener
            // TODO onReplyMenuClickListener
        }

        void onBind(Map<String, Object> item, int replyIndex) {
            this.replyIndex = replyIndex;

            // TODO FILL TEXTVIEW TEXT
        }
    }

    public interface OnPostLikeClickListener {
        void onPostLikeClick(View view);
    }

    public interface OnReplyLikeClickListener {
        void onReplyLikeClick(View view, int position);
    }

    public interface OnReplyMenuClickListener {
        void onReplyMenuClick(View view, int position);
    }
}