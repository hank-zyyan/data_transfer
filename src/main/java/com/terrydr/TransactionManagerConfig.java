package com.terrydr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

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
public class TransactionManagerConfig {

    @Autowired
    @Qualifier("originalDataSource")
    private DataSource originalDataSource;

    @Autowired
    @Qualifier("basicDataSource")
    private DataSource basicDataSource;

    @Autowired
    @Qualifier("ecgDataSource")
    private DataSource ecgDataSource;

    @Autowired
    @Qualifier("eyeDataSource")
    private DataSource eyeDataSource;

    @Autowired
    @Qualifier("pathologyDataSource")
    private DataSource pathologyDataSource;

    @Bean
    public PlatformTransactionManager originalTransactionManager() {
        return new DataSourceTransactionManager(originalDataSource);
    }

    @Bean
    public PlatformTransactionManager basicTransactionManager() {
        return new DataSourceTransactionManager(basicDataSource);
    }

    @Bean
    public PlatformTransactionManager ecgTransactionManager() {
        return new DataSourceTransactionManager(ecgDataSource);
    }

    @Bean
    public PlatformTransactionManager eyeTransactionManager() {
        return new DataSourceTransactionManager(eyeDataSource);
    }

    @Bean
    public PlatformTransactionManager pathologyTransactionManager() {
        return new DataSourceTransactionManager(pathologyDataSource);
    }

}
