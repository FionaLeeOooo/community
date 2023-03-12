/*
 * @Title:  community
 * @Package com.olivia.community.service.impl
 * @author: zxuyi
 * @date:   2023/3/12 15:17
 * @version V1.0
 */
package com.olivia.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.olivia.community.entity.User;
import com.olivia.community.mapper.UserMapper;
import com.olivia.community.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zxuyi
 * @title: UserServiceImpl
 * @description: User Service Implementation
 * @date 2023/3/12 15:17
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * @param user User
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @description: user registration
     * @author zxuyi
     * @date 2023/3/12 15:59
     */
    @Override
    public Map<String, Object> register(User user) {
        return null;
    }


}
