//package com.terrydr;
//
//import com.github.pagehelper.PageHelper;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.apache.ibatis.plugin.Interceptor;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * @author zyyan@terrydr.com
// * @version 1.0.0
// * @desc 描述 <br>
// * <p>
// * Copyright: Copyright (c)
// * <p>
// * Company: 南京泰立瑞信息科技有限公司
// * <p>
// */
//@Configuration
//@MapperScan(basePackages = {"com.terrydr.dao.basic"}, sqlSessionFactoryRef = "originalSessionFactory")
//public class DatabaseConfig_Original {
//
//    @Autowired
//    @Qualifier("originalDataSource")
//    private DataSource originalDataSource;
//
//    @Bean
//    public SqlSessionFactory originalSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(originalDataSource); // 使用titan数据源, 连接titan库
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/*.xml"));
//        return factoryBean.getObject();
//
//    }
//
//    @Bean
//    public SqlSessionTemplate originalSessionTemplate() throws Exception {
//        SqlSessionTemplate template = new SqlSessionTemplate(originalSessionFactory()); // 使用上面配置的Factory
//        return template;
//    }
//
//}
