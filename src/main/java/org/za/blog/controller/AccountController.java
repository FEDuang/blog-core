package org.za.blog.controller;

import org.springframework.web.bind.annotation.*;
import org.za.blog.consts.ServerResponse;
import org.za.blog.dto.LoginParam;
import org.za.blog.entity.Account;
import org.za.blog.service.IAccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


@CrossOrigin
@RestController
@RequestMapping(value = "account")
public class AccountController {

    IAccountService accountService;

    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("login")
    public Object login(@RequestBody LoginParam loginParam) {
        System.out.println(loginParam.getUsername() + " @ " + loginParam.getPassword());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if (subject.isAuthenticated()) {
            return ServerResponse.Success("您已经登陆过了", session.getAttribute("user"));
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginParam.getUsername(), loginParam.getPassword());
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            return ServerResponse.Error("账号或密码错误");
        }
        Account account = (Account) session.getAttribute("user");

        return ServerResponse.Success("登陆成功", account);

    }

    @PostMapping("logout")
    public Object logout() {
        SecurityUtils.getSubject().logout();
        return ServerResponse.Success();
    }
}
