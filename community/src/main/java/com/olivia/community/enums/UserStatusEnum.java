package com.olivia.community.enums;

import lombok.Getter;

/**
 * @author zxuyi
 * @title: UserStatusEnum
 * @description: User Status
 * @date 2023/3/12 17:02
 */

@Getter
public enum UserStatusEnum {

    UNACTIVATED("0", "未激活"),
    ACTIVATED("1", "已激活"),
    ;

    /**
     * value
     */
    private String value;

    /**
     * type
     */
    private String type;

    UserStatusEnum(String value, String type) {

    }

    public boolean contains(String type) {
        for (UserStatusEnum userStatus : UserStatusEnum.values()) {
            if (userStatus.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public String getType(String value) {
        for (UserStatusEnum userStatus : UserStatusEnum.values()) {
            if (userStatus.equals(value)) {
                return userStatus.getType();
            }
        }
        return null;
    }

    public String getValue(String type) {
        for (UserStatusEnum userStatus : UserStatusEnum.values()) {
            if (userStatus.getType().equals(type)) {
                return userStatus.getValue();
            }
        }
        return null;
    }

}
