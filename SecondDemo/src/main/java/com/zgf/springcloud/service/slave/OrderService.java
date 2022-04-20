package com.zgf.springcloud.service.slave;

import com.zgf.springcloud.domain.slave.OrderDO;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-19 15:06
 **/
public interface OrderService {
    OrderDO getOrderById(Long id);

    String insert(OrderDO orderDO);
}
