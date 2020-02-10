package com.kaleldo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述用户信息的方法
 */
@Data
public class KaleldoAuthUser implements Serializable {
    private static final long serialVersionUID = -1748289340320186418L;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
