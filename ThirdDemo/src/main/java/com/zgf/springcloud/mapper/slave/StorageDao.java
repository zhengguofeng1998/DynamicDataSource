package com.zgf.springcloud.mapper.slave;

import com.zgf.springcloud.domain.slave.OrderDO;
import com.zgf.springcloud.domain.slave.StorageDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageDao {

    StorageDO getStorageById(@Param("id") Long id);

}