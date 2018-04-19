package com.terrydr;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

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
@MapperScan(basePackages = {"com.terrydr.dao.ecg"}, sqlSessionFactoryRef = "ecgSessionFactory")
public class DatabaseConfig_ECG {

    @Autowired
    @Qualifier("ecgDataSource")
    private DataSource ecgDataSource;

    @Bean
    public SqlSessionFactory ecgSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ecgDataSource); // 使用titan数据源, 连接titan库
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/ecg/*.xml"));
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate ecgSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(ecgSessionFactory()); // 使用上面配置的Factory
        return template;
    }

}
