package com.zgf.springcloud.controller.primary;

import com.zgf.springcloud.config.DynamicDataSource;
import com.zgf.springcloud.domain.GroupByVo;
import com.zgf.springcloud.domain.primary.AccountDO;
import com.zgf.springcloud.service.primary.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-19 15:06
 **/
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    public AccountService accountService;

    @GetMapping("/getAccountById/{id}")
    public AccountDO getAccountById(@PathVariable("id") Long id) {
        AccountDO allAccount = accountService.getAccountById(id);
        return allAccount;
    }

    @GetMapping("/queryByGroup")
    public List<GroupByVo> queryByGroup() {
        List<GroupByVo> groupByVos = accountService.queryByGroup();
        return groupByVos;
    }

    @PostMapping(value = "/updateById")
    public String updateById(@RequestBody AccountDO accountDO) {
        String s = accountService.updateById(accountDO);
        return s;
    }


    @PostMapping(value = "/insert")
    public String insert(@RequestBody AccountDO accountDO) {
        String insert = accountService.insert(accountDO);
        return insert;
    }
}
