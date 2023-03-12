/*
 * @Title:  community
 * @Package com.olivia.community.service
 * @author: zxuyi
 * @date:   2023/3/12 15:16
 * @version V1.0
 */
package com.olivia.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.community.entity.User;

import java.util.Map;

/**
 * @author zxuyi
 * @title: UserService
 * @description: User Service
 * @date 2023/3/12 15:16
 */

public interface UserService extends IService<User> {

    /**
    * @description: user registration
    * @param user User
    * @return java.util.Map<java.lang.String,java.lang.Object>
    * @author zxuyi
    * @date 2023/3/12 15:59
    */
    Map<String, Object> register(User user);




}
