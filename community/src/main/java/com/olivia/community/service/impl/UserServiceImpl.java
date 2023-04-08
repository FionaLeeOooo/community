package com.olivia.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.olivia.community.entity.User;
import com.olivia.community.enums.UserStatusEnum;
import com.olivia.community.enums.UserTypeEnum;
import com.olivia.community.mapper.UserMapper;
import com.olivia.community.service.UserService;
import com.olivia.community.utils.CommunityUtil;
import com.olivia.community.utils.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zxuyi
 * @title: UserServiceImpl
 * @description: User Service Implementation
 * @date 2023/3/12 15:17
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${server.servlet.context-path}")
    private String contextPath;
    /** 网站域名 **/
    @Value("${community.path.domain}")
    private String domain;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;


    /**
     * @param user User
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @description: user registration
     * @author zxuyi
     * @date 2023/3/12 15:59
     */
    @Override
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();
        // 空值处理
        if (null == user) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        // 用户名为空
        if (StringUtils.isBlank(user.getUsername())) {
            map.put("usernameMessage", "用户名不能为空！");
            return map;
        }
        // 密码为空
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("passwordMessage", "密码不能为空！");
            return map;
        }
        // 邮箱为空
        if (StringUtils.isBlank(user.getEmail())) {
            map.put("emailMessage", "邮箱不能为空！");
            return map;
        }

        // 验证账号的合法性
        User selectUser = userMapper.selectOne(getWrappers(User.builder().username(user.getUsername()).build()));
        if (selectUser != null) {
            // 账号用户名存在，表示应该更换用户名
            map.put("usernameMessage", "用户名已存在！");
            return map;
        }

        // 验证邮箱的合法性
        selectUser = userMapper.selectOne(getWrappers(User.builder().email(user.getEmail()).build()));
        if (selectUser != null) {
            // 邮箱已经被注册，表示应该更换邮箱注册，或者找回密码
            map.put("emailMessage", "邮箱已被注册！");
        }

        // 注册账号，要将数据写入到数据库中
        // 一、设置 salt 值
        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
        // 二、设置被加密的密码值
        user.setPassword(CommunityUtil.md5(user.getPassword() + user.getSalt()));
        // 三、设置用户类型
        user.setUserType(UserTypeEnum.ORDINARY_USER.getValue());
        // 四、设置用户状态，默认为未激活
        user.setStatus(UserStatusEnum.UNACTIVATED.getValue());
        // 五、设置用户的激活码
        user.setActivationCode(CommunityUtil.generateUUID());
        // 六、设置默认头像路径
        user.setHeaderUrl("http://images.nowcoder.com/head/" + new Random().nextInt(1000) + "t.png");
        // 七、设置注册时间
        user.setCreateTime(LocalDateTime.now());
        // 八、保存用户
        insert(user);
        // 九、发送激活邮件
        Context context = new Context();
        context.setVariable("email", user.getEmail());
        // 填充网页链接：http://locolhost:8080/community/activation/userId/activationCode
        String url = domain + contextPath + "/activation/" + user.getId() + "/" + user.getActivationCode();
        context.setVariable("url", url);
        // 模板引擎调用网页，将其中的数据填充之后，生成一个 HTML 网页字符串对象，格式化网页
        String process = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(user.getEmail(), "激活账号链接", process);

        return map;
    }

    /**
     * @param user User
     * @return int
     * @description: add a user
     * @author zxuyi
     * @date 2023/3/12 17:10
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }


    private LambdaQueryWrapper<User> getWrappers(User user) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isBlank(user.getUsername()), User::getUsername, user.getUsername())
                .eq(StringUtils.isBlank(user.getEmail()), User::getEmail, user.getEmail());

        return wrapper;
    }


}
