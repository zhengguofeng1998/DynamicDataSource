package com.zgf.springcloud.service.primary.impl;


import com.zgf.springcloud.annotation.DS;
import com.zgf.springcloud.config.DynamicDataSource;
import com.zgf.springcloud.constants.DataSourceConstants;
import com.zgf.springcloud.domain.primary.AccountDO;
import com.zgf.springcloud.mapper.primary.AccountDao;
import com.zgf.springcloud.service.primary.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: testSeata
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-12 10:50
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    public AccountDao accountDao;

    @Override
    @DS(DataSourceConstants.DS_KEY_PRIMARY)
    public AccountDO getAccountById(Long id) {
        AccountDO all = accountDao.getAccountById(id);
        return all;
    }

    @Override
    @Transactional
    public String updateById(AccountDO accountDO) {
        int i = accountDao.updateById(accountDO);
        return "修改成功";

    }

    @Override
    @Transactional
    public String insert(AccountDO accountDO) {
        accountDao.insert(accountDO);
        return "插入成功！";
    }

}
