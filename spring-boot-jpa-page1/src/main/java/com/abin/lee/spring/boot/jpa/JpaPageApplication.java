package com.abin.lee.spring.boot.jpa;

/**
 * Created by abin on 2018/1/15 19:35.
 * spring-boot-start2
 * com.abin.lee.spring.boot.jpa
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class JpaPageApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JpaPageApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JpaPageApplication.class, args);
    }


}