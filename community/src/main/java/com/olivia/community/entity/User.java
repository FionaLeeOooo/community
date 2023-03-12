/*
 * @Title:  community
 * @Package com.olivia.community.entity
 * @author: zxuyi
 * @date:   2023/3/12 13:10
 * @version V1.0
 */
package com.olivia.community.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author zxuyi
 * @title: User
 * @description: User Entity Class
 * @date 2023/3/12 13:10
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private int id;

    /**
     * userId
     */
    private String userId;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * salt
     */
    private String salt;

    /**
     * email
     */
    private String email;

    /**
     * telephone
     */
    private String telephone;

    /**
     * gender
     */
    private String gender;

    /**
     * userType
     */
    private int userType;

    /**
     * avatar
     */
    private String avatar;

    /**
     * activationCode
     */
    private int activationCode;

    /**
     * headerUrl
     */
    private String headerUrl;

}
