/*
 * @Title:  community
 * @Package com.olivia.community.mapper
 * @author: zxuyi
 * @date:   2023/3/12 14:44
 * @version V1.0
 */
package com.olivia.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.community.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author zxuyi
 * @title: UserMapper
 * @description: User Mapper
 * @date 2023/3/12 14:44
 */

@Repository
public interface UserMapper extends BaseMapper<User> {
}
