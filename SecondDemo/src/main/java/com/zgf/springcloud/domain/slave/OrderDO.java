package com.zgf.springcloud.domain.slave;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: SpringCloudBiliBili
 * @description:
 * @author: zhengguofeng
 * @create: 2021-12-25 10:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDO {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;
}
