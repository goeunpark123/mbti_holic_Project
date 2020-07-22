package com.mbtiholic.mobileprogramming_mbtiholic.domain.entity;

import java.util.Date;

public class Post {
    private String id;
    private String postBundleId;
    private String userId;
    private String userMbti;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    //트렌젝션을 해야할만한 것은 다 빼자 -> likeCount에 관련된 테이블이 필요함

    public Post(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostBundleId() {
        return postBundleId;
    }

    public void setPostBundleId(String postBundleId) {
        this.postBundleId = postBundleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMbti() {
        return userMbti;
    }

    public void setUserMbti(String userMbti) {
        this.userMbti = userMbti;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
