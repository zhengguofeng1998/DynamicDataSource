package com.zgf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: DynamicDataSource
 * @description:
 * 优点
 * 简单、直接：一个库对应一套处理方式，很好理解。
 * 符合开闭原则（ OCP ）：开发的设计模式告诉我们，对扩展开放，对修改关闭，添加多一个数据库，原来的那一套不需要改动，只添加即可。
 * 缺点
 * 资源浪费：针对每一个数据源写一套操作，连接数据库的资源也是独立的，分别占用同样多的资源。
 *         SqlSessionFactory 是一个工厂，建议是使用单例，完全可以重用，不需要建立多个，只需要更改数据源即可，跟多线程，使用线程池减少资源消耗是同一道理。
 * 代码冗余：在前面的多数据源配置中可以看出，其实 master 和 slave 的很多操作是一样的，只是改个名称而已，因此会造成代码冗余。
 * 缺乏灵活：所有需要使用的地方都需要引入对应的 mapper，对于很多操作，只是选择数据源的不一样，代码逻辑是一致的。另外，对于一主多从的情况，
 *         若需要对多个从库进行负载均衡，相对比较麻烦。
 * @author: zhengguofeng
 * @create: 2022-04-19 15:00
 **/
@SpringBootApplication
public class FirstApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class);
    }
}
