package com.zgf.springcloud.controller.salve;

import com.zgf.springcloud.domain.primary.AccountDO;
import com.zgf.springcloud.domain.slave.OrderDO;
import com.zgf.springcloud.service.primary.AccountService;
import com.zgf.springcloud.service.slave.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-19 15:06
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @GetMapping("/getOrderById/{id}")
    public OrderDO getOrderById(@PathVariable("id") Long id) {
        OrderDO orderDO = orderService.getOrderById(id);
        return orderDO;
    }


    @PostMapping(value = "/insert")
    public String insert(@RequestBody OrderDO orderDO) {
        String insert = orderService.insert(orderDO);
        return insert;
    }
}
