package com.tencent.gaio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients//启动Feign客户端
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
