package com.kaleldo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaleldo.pojo.system.SystemUser;

public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}
