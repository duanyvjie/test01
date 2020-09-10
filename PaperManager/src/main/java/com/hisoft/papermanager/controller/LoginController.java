package com.hisoft.papermanager.controller;

import com.hisoft.papermanager.pojo.User;
import com.hisoft.papermanager.service.user.UserService;
import com.hisoft.papermanager.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-08 20:03:15
 **/
@Controller
@Transactional
public class LoginController {
    @Autowired
    UserService userService;


    @RequestMapping("/tologin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/dologin")
    public String doLogin(Model model,
                          @RequestParam("userName") String userName,
                          @RequestParam("userPwd") String userPwd,
                          HttpSession session) {
        System.out.println("login ============ ");
        User user = userService.getLoginUser(userName);
        if (null != user) {//登录成功
            if (!user.getUserPassword().equals(userPwd)) {
                throw new RuntimeException("密码输入错误");
            }
            //放入session
            session.setAttribute(Constants.USER_SESSION, user);
            //页面跳转（frame.jsp）
            return "redirect:/toframe";
        } else {
            //页面跳转（login.jsp）带出提示信息--转发
          /* model.addAttribute("error", "用户名或密码不正确");
            return "login";*/
            throw new RuntimeException("用户名不存在");
        }
    }

    @RequestMapping("/toframe")
    public String toframe(){
        return "frame";
    }
    @RequestMapping("/doLogout")
    public String logout(HttpSession session) {
        session.removeAttribute(Constants.USER_SESSION);
        return "redirect:/tologin";
    }
}
