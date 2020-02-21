package com.kaleldo.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private Integer id;

    private String userName;
    private String passWord;

    public User(Integer id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }
}
