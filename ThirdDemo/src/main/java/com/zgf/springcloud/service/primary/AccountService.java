package com.zgf.springcloud.service.primary;

import com.zgf.springcloud.annotation.DS;
import com.zgf.springcloud.constants.DataSourceConstants;
import com.zgf.springcloud.domain.GroupByVo;
import com.zgf.springcloud.domain.primary.AccountDO;

import java.util.List;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-19 15:06
 **/
public interface AccountService {
    AccountDO getAccountById(Long id);

    List<GroupByVo> queryByGroup();

    String updateById(AccountDO accountDO);

    String insert(AccountDO accountDO);
}
