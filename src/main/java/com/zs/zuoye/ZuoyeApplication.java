package com.zs.zuoye;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.zs.zuoye.dao")
public class ZuoyeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ZuoyeApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ZuoyeApplication.class);
    }

}
