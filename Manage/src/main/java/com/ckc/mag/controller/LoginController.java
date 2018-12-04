package com.ckc.mag.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("adm")
public class LoginController {

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String doLogin(String username, String password){

        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        // 测试当前的用户是否已经被认证，即是否已经登陆
        // 调用Subject的isAuthenticated
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                // 执行登陆
                currentUser.login(token);
            } catch (AuthenticationException ae) {
                System.out.println("登录失败--->" + ae.getMessage());
            }
        }
        return "success";
    }
}
