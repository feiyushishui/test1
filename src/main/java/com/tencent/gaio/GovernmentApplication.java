package com.tencent.gaio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients//启动Feign客户端
@EnableRedisHttpSession//启动使用redis实现session共享
public class GovernmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(GovernmentApplication.class, args);
    }

}
