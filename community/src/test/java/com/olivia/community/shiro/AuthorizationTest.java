/*
 * @Title:  community
 * @Package com.olivia.community.shiro
 * @author: zxuyi
 * @date:   2023/3/20 21:01
 * @version V1.0
 */
package com.olivia.community.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zxuyi
 * @title: AuthenticationTest
 * @description: Authorization Test
 * @date 2023/3/20 21:01
 */
public class AuthorizationTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before // 在方法开始前添加一个用户,让它具备admin和user两个角色
    public void addUser() {
        simpleAccountRealm.addAccount("wmyskxz", "123456", "admin", "user");
    }

    @Test
    public void testAuthentication() {

        // 1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager); // 设置SecurityManager环境
        Subject subject = SecurityUtils.getSubject(); // 获取当前主体

        UsernamePasswordToken token = new UsernamePasswordToken("wmyskxz", "123456");
        subject.login(token); // 登录

        // subject.isAuthenticated()方法返回一个boolean值,用于判断用户是否认证成功
        System.out.println("isAuthenticated:" + subject.isAuthenticated()); // 输出true
        // 判断subject是否具有admin和user两个角色权限,如没有则会报错
        subject.checkRoles("admin","user");
//        subject.checkRole("xxx"); // 报错
    }

}
