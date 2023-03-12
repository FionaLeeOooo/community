/*
 * @Title:  community
 * @Package com.olivia.community.entity
 * @author: zxuyi
 * @date:   2023/3/12 13:10
 * @version V1.0
 */
package com.olivia.community.entity;

import java.util.Date;

/**
 * @author zxuyi
 * @title: User
 * @description: User Entity Class
 * @date 2023/3/12 13:10
 */


public class User {

    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int type;
    private int status;
    private int activationCode;
    private String headerUrl;

}
