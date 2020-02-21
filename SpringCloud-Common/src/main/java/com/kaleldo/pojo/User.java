package com.kaleldo.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private Integer id;

    private String userName;
    private String passWord;
}
