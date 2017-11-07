package com.boa;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Controller
@ServletComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan(basePackages = "cn.boa.mapper")
@EnableTransactionManagement
public class WebApplication extends SpringBootServletInitializer {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        LOGGER.info("**************************************************************************************************************************");
        LOGGER.info("**************************************    Boa Spring boot Application start completed !   ********************************");
        LOGGER.info("**************************************************************************************************************************");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        SpringApplicationBuilder sources = builder.sources(WebApplication.class);
        return sources;
    }
}
