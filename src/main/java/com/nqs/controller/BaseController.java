package com.nqs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nqs.dao.StudentDao;
import com.nqs.entity.Student;
import com.nqs.entity.TUser;
import com.nqs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @ResponseBody
    @RequestMapping("doLogin")
    public TUser doLogin(TUser tuser, HttpSession session){
        TUser user =  userService.login(tuser);
        System.out.println(user);
        if (user != null){
            session.setAttribute("user",user);
            return user;
        }else{
            return null;
        }
    }
    @RequestMapping("user/user")
    public String user(){
        return "user";
    }
    @RequestMapping("user/selectUsersPage")
    public Object selectUsersPage(Integer pageNo,Integer pageSize,Map<String,Object> map){
        Map<String,Object> result = userService.selectUsersPage(pageNo,pageSize);
        map.put("result",result);
        return "pageUserTemp";
    }

    @RequestMapping("logout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
    @RequestMapping("user/main")
    public String main(HttpSession session){

        return "main";

    }

}
