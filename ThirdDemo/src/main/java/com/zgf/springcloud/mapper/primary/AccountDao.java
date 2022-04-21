package com.zgf.springcloud.mapper.primary;

import com.zgf.springcloud.domain.GroupByVo;
import com.zgf.springcloud.domain.primary.AccountDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
    AccountDO getAccountById(@Param("id") Long id);

    int updateById(AccountDO accountDO);

    int insert(AccountDO accountDO);

    List<GroupByVo> queryByGroup();
}