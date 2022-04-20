package com.zgf.springcloud.domain.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: SpringCloudBiliBili
 * @description:
 * @author: zhengguofeng
 * @create: 2021-12-25 10:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDO {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
