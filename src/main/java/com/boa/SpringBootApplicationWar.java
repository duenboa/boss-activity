package com.boa;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * 这种方式来构建war包. 独立到tomcat中发布
 * <p>
 * <b>修改点:</b>
 * <p>
 * 1. pom文件中的打包方式: 指定为war
 * <pre>
 *     <groupId>com.boa</groupId>
 *     <artifactId>boaspringboot</artifactId>
 *     <version>0.0.1-SNAPSHOT</version>
 *     <!--<packaging>jar</packaging>-->
 *     <packaging>war</packaging>
 *</pre>
 *
 * <pre>
 * 2. 配置启动类
 *     #@Controller
 *     #@EnableAutoConfiguration
 *     #@SpringBootApplication
 *     public class SpringBootApplicationWar extends SpringBootServletInitializer {...}
 *
 * 3. 将maven中的依赖: spring-boot-starter-tomcat 的scope设置为 provide类型. 编译时提供,打包时排除.
 *      <dependency>
 *      <groupId>org.springframework.boot</groupId>
 *      <artifactId>spring-boot-starter-tomcat</artifactId>
 *      <scope>provided</scope>
 *      </dependency>
 * </pre>
 */
public class SpringBootApplicationWar extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //此处指向原先启动jar应用的核心类.
        return builder.sources(BootstrapApplication.class);
    }
}
