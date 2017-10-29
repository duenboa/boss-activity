package com.boa;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@ServletComponentScan //扫描Servlet级别的组件eg: servlet,filter,listener
@Controller
@EnableAutoConfiguration
//@ImportResource({"classpath:my-context.xml", "classpath:my-context2.xml"})//非要配置文件不可的情况下, 通过此注解导入配置
//通过exclude属性指定不需要自动配置的组件
@SpringBootApplication(exclude = {RedisAutoConfiguration.class, SolrAutoConfiguration.class, MongoDataAutoConfiguration.class, MongoRepositoriesAutoConfiguration.class})
public class BootstrapApplication {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BootstrapApplication.class);

    public static void main(String[] args) {
        //SpringApplication app = new SpringApplication();
        //app.setBannerMode(OFF); //关闭banner
        SpringApplication.run(BootstrapApplication.class, args);
        System.out.println("**************************************************************************************************************************");
        System.out.println("**************************************    Boa Spring boot Application start completed !   ********************************");
        System.out.println("**************************************************************************************************************************");


        //---------------------- 测试自己要测试的东西
        testAOPAdviser();
    }

    private static void testAOPAdviser() {

    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        //http://127.0.0.1:8088/hello.do
        String str = "hello 我是好人";
        return str;
    }


}
