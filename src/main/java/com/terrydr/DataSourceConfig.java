package com.terrydr;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import javax.sql.DataSource;

/**
 * @author zyyan@terrydr.com
 * @version 1.0.0
 * @desc 描述 <br>
 * <p>
 * Copyright: Copyright (c)
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 */
@Configuration
public class DataSourceConfig {

    /*@Bean
    @ConfigurationProperties(prefix = "spring.datasource.original") // application.properteis中对应属性的前缀
    public DataSource originalDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.basic") // application.properteis中对应属性的前缀
    public DataSource basicDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.ecg") // application.properteis中对应属性的前缀
    public DataSource ecgDataSource() {
        return DataSourceBuilder.create().build();
    }*/

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.eye") // application.properteis中对应属性的前缀
    public DataSource eyeDataSource() {
        return DataSourceBuilder.create().build();
    }

    /*@Bean
    @ConfigurationProperties(prefix = "spring.datasource.pathology") // application.properteis中对应属性的前缀
    public DataSource pathologyDataSource() {
        return DataSourceBuilder.create().build();
    }*/

}
