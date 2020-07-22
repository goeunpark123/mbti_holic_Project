package com.mbtiholic.mobileprogramming_mbtiholic.PostItemInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.mbtiholic.mobileprogramming_mbtiholic.R;
import com.mbtiholic.mobileprogramming_mbtiholic.domain.entity.Post;
import com.mbtiholic.mobileprogramming_mbtiholic.domain.entity.Reply;

import java.util.List;

public class PostItemInfoRecyclerViewAdapter extends Adapter<ViewHolder> {
    private Post post;
    private List<Reply> replyList;
    private OnPostLikeClickListener onPostLikeClickListener;
    private OnReplyLikeClickListener onReplyLikeClickListener;
    private OnReplyMenuClickListener onReplyMenuClickListener;

    private final int ITEM_VIEW_TYPE_POST = 1; // HEADER
    private final int ITEM_VIEW_TYPE_REPLY = 2;

    public PostItemInfoRecyclerViewAdapter(List<Reply> replyList){
        this.replyList = replyList;
    }

    public void setPost(Post post) {
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

    private Reply getReplyByPosition(int position) {
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
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_each, parent, false),
                        onPostLikeClickListener
                );
            case ITEM_VIEW_TYPE_REPLY:
                return new ReplyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_reply_each, parent, false),
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
                Reply reply = getReplyByPosition(position);
                int replyIndex = getReplyIndexByPosition(position);
                ((ReplyViewHolder)holder).onBind(reply, replyIndex);
                break;
        }
    }

    class PostViewHolder extends ViewHolder {
        private TextView contentTextView;

        PostViewHolder(View itemView, final OnPostLikeClickListener onPostLikeClickListener) {
            super(itemView);

            contentTextView = (TextView)itemView.findViewById(R.id.contentTextView);
            // TODO onPostLikeClickListener
        }

        void onBind(Post item) {
            if(item == null || item.getId() == null) {
                return;
            }

            contentTextView.setText(item.getContent());
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

        void onBind(Reply item, int replyIndex) {
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