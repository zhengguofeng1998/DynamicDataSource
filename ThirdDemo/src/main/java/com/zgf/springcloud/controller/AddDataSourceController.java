package com.zgf.springcloud.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.zgf.springcloud.config.DynamicDataSource;
import com.zgf.springcloud.config.DynamicDataSourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-20 15:14
 **/
@RestController
@Slf4j
@RequestMapping("/addDataSource")
public class AddDataSourceController {

    @Autowired
    public DynamicDataSource dynamicDataSource;

    String url = "jdbc:mysql://localhost:3306/seata_storage?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    String username = "root";
    String password = "123456";
    String driverClassName = "org.gjt.mm.mysql.Driver";

    /**
     * 自动添加数据源到配置类
     */
    @GetMapping("/addDataSource")
    public String addDataSource() {
        Map<Object, Object> myTargetDataSources = dynamicDataSource.getMyTargetDataSources();
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource = DynamicDataSourceConfig.dataSource(druidDataSource);
        myTargetDataSources.put("storage", druidDataSource);
        dynamicDataSource.setTargetDataSources(myTargetDataSources);
        dynamicDataSource.afterPropertiesSet();
        return "添加数据源成功";
    }

}
