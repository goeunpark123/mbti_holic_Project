package com.example.mobileprogramming_mbtiholic.domain.entity;

public class PostItem {
    private String id;
    private String name;
    private String explain;
    //유저랑 즐겨찾기 관련해서 뭔가가 필요함

    public PostItem(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
