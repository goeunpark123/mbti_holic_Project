package com.mbtiholic.mobileprogramming_mbtiholic.domain.entity;

public class UserAuth {
    private String id;
    private String identification;
    private String pw;
    private int type; //1:일반 로그인, 2:구글 로그인

    public UserAuth(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
