package com.zgf.springcloud.mapper.slave;

import com.zgf.springcloud.domain.primary.AccountDO;
import com.zgf.springcloud.domain.slave.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    OrderDO getOrderById(@Param("id") Long id);

    int insert(OrderDO orderDO);
}