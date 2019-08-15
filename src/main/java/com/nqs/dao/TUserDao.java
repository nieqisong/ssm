package com.nqs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nqs.entity.Student;
import com.nqs.entity.TUser;

import java.util.List;

public interface TUserDao extends BaseMapper<TUser> {
    TUser queryUserToLogin(TUser tuser);
}
