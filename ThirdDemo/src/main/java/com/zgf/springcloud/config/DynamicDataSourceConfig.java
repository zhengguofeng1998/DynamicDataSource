package com.zgf.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zgf.springcloud.constants.DataSourceConstants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.zgf.springcloud.mapper")
public class DynamicDataSourceConfig {

    @Bean(DataSourceConstants.DS_KEY_PRIMARY)
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DruidDataSource primaryDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return dataSource(druidDataSource);
    }

    @Bean(DataSourceConstants.DS_KEY_SLAVE)
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DruidDataSource slaveDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return dataSource(druidDataSource);
    }

    public static DruidDataSource dataSource(DruidDataSource druidDataSource) {
        druidDataSource.setInitialSize(0);
        druidDataSource.setMaxActive(180);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setMinIdle(0);
        druidDataSource.setValidationQuery("Select 1 from DUAL");
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(25200000);
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setRemoveAbandonedTimeout(1800);
        druidDataSource.setLogAbandoned(true);
        return druidDataSource;
    }

    @Bean
    @Primary
    public DataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceConstants.DS_KEY_PRIMARY, primaryDataSource());
        dataSourceMap.put(DataSourceConstants.DS_KEY_SLAVE, slaveDataSource());
        //设置动态数据源
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource());
        dynamicDataSource.setMyTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }
}