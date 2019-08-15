package com.nqs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nqs.dao.TUserDao;
import com.nqs.entity.TUser;
import com.nqs.service.UserService;
import com.nqs.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TUserDao tUserDao;

    @Override
    public TUser login(TUser tUser) {
        tUser.setUserpwd(MD5Utils.MD5Encode(tUser.getUserpwd(),null));
        TUser tuser = tUserDao.queryUserToLogin(tUser);
        return tuser;
    }

    @Override
    public Map<String,Object> selectUsersPage(Integer pageNo, Integer pageSize) {
        IPage<TUser> page = tUserDao.selectPage(new Page<TUser>(pageNo,pageSize),null);
        Map<String,Object> map = new HashMap<>();
        System.out.println("总数据量" + page.getTotal());
        System.out.println("总页码" + page.getPages());
        System.out.println("数据" + page.getRecords());
        System.out.println("当前页页码" + page.getCurrent());
        long pageSum =(Long) page.getPages();//总页码
        long pageCurrent = (Long)page.getCurrent();//当前页码
        long pageStart = 0;
        long pageEnd = 0;
        if (pageSum > 10){
            if (pageCurrent >= 6){
                if ((pageSum - pageCurrent) >= 4){
                    pageStart = pageCurrent - 5;
                    pageEnd = pageCurrent + 4;
                }else{
                    pageStart = pageSum - 9;
                    pageEnd = pageSum;
                }
            }else {
                pageStart =  1;
                pageEnd = 10;
            }

        }else{
            pageStart = 1;
            pageEnd = pageSum;
        }



        map.put("pageStart",pageStart);
        map.put("pageEnd",pageEnd);
        map.put("page",pageCurrent);
        map.put("pageSum",pageSum);
        map.put("data",page.getRecords());
        return map;
    }
}
