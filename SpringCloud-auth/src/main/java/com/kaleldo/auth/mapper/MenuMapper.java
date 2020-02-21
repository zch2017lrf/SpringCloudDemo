package com.kaleldo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaleldo.pojo.system.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> findUserPermissions(String username);
}
