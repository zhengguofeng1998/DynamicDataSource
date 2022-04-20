package com.zgf.springcloud.service.primary;

import com.zgf.springcloud.domain.primary.AccountDO;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-19 15:06
 **/
public interface AccountService {
    AccountDO getAccountById(Long id);

    String updateById(AccountDO accountDO);

    String insert(AccountDO accountDO);
}
