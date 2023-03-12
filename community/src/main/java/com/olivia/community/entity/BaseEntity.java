/*
 * @Title:  community
 * @Package com.olivia.community.entity
 * @author: zxuyi
 * @date:   2023/3/12 13:41
 * @version V1.0
 */
package com.olivia.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zxuyi
 * @title: BaseEntity
 * @description: Base Entity Class
 * @date 2023/3/12 13:41
 */

public class BaseEntity implements Serializable {

    private String creator;

    private Date createTime;

    private String updater;

    private Date updateTime;


}
