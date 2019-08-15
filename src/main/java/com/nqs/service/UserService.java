package com.nqs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nqs.entity.TUser;

import java.util.Map;

public interface UserService {
    TUser login(TUser tUser);
    Map<String,Object> selectUsersPage(Integer pageNo, Integer pageSize);
}
