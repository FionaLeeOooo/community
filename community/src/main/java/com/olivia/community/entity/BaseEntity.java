/*
 * @Title:  community
 * @Package com.olivia.community.entity
 * @author: zxuyi
 * @date:   2023/3/12 13:41
 * @version V1.0
 */
package com.olivia.community.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zxuyi
 * @title: BaseEntity
 * @description: Base Entity Class
 * @date 2023/3/12 13:41
 */

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1402942655051821140L;

    /**
     * creator
     */
    private String creator;

    /**
     * createTime
     */
    private LocalDateTime createTime;

    /**
     * updater
     */
    private String updater;

    /**
     * updateTime
     */
    private LocalDateTime updateTime;

    /**
     * deleteFlag
     * (0:no; 1:yes)
     */
    private String deleteFlag;

    /**
     * status
     * (0:no; 1:yes)
     */
    private String status;

}
