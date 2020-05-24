package com.example.mobileprogramming_mbtiholic.domain.entity;

import java.util.Date;

public class Reply {
    private String id;
    private String userId;
    private String userMbti;//글쓴 시점의 사용자의 mbti를 저장
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public Reply(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
