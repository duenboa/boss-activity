package com.boa.common.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright (C), 2012-2020 上海好屋网信息技术有限公司
 * @Author: DengBenbo 20160289
 * @Date: 2017/6/24
 * @Version: 1.0.0
 * :
 * @see
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class) //在指定bean实例化之后才实例化当前配置 (即有先后顺序)
public class MybatisMapperScannerConfig {


    /**** mapper接口的扫描器 ****/
    @Bean
    @ConditionalOnMissingBean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.boa.mapper");
        return mapperScannerConfigurer;
    }

}
