package com.olivia.community.enums;

import lombok.Getter;

/**
 * @author zxuyi
 * @title: UserTypeEnum
 * @description: User Type
 * @date 2023/3/12 16:47
 */

@Getter
public enum UserTypeEnum {

    ORDINARY_USER("0", "普通用户"),
    ADMINISTRATOR("1", "管理员"),
    SUPER_ADMINISTRATOR("2", "超级管理员"),
    MODERATOR("3", "版主"),
    ;

    /**
    * value
    */
    private String value;

    /**
     * type
     */
    private String type;

    UserTypeEnum(String value, String type) {

    }

    public boolean contains(String type) {
        for (UserTypeEnum userType : UserTypeEnum.values()) {
            if (userType.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public String getType(String value) {
        for (UserTypeEnum userType : UserTypeEnum.values()) {
            if (userType.equals(value)) {
                return userType.getType();
            }
        }
        return null;
    }

    public String getValue(String type) {
        for (UserTypeEnum userType : UserTypeEnum.values()) {
            if (userType.getType().equals(type)) {
                return userType.getValue();
            }
        }
        return null;
    }

}
