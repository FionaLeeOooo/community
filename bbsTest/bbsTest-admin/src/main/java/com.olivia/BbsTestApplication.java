/*
 * @Title:  BBSTest
 * @Package com.olivia
 * @author: zxuyi
 * @date:   2022/8/16 23:21
 * @version V1.0
 */
package com.olivia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author zxuyi
 * @title: BbsTestApplication
 * @description: 启动程序
 * @date 2022/8/16 23:21
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BbsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsTestApplication.class, args);
        System.out.println(" (♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }

}
