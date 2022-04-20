package com.zgf.springcloud.service.slave.impl;

import com.zgf.springcloud.constants.DataSourceConstants;
import com.zgf.springcloud.domain.slave.OrderDO;
import com.zgf.springcloud.holder.DynamicDataSourceContextHolder;
import com.zgf.springcloud.mapper.slave.OrderDao;
import com.zgf.springcloud.service.slave.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-19 15:43
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public OrderDO getOrderById(Long id) {
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_SLAVE);
        OrderDO orderDO = orderDao.getOrderById(id);
        DynamicDataSourceContextHolder.removeContextKey();
        return orderDO;
    }

    @Override
    public String insert(OrderDO orderDO) {
        int insert = orderDao.insert(orderDO);
        return "插入成功";
    }
}
