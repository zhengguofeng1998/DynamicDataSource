package com.zgf.springcloud.service.slave;

import com.zgf.springcloud.domain.slave.StorageDO;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-19 15:06
 **/
public interface StorageService {
    StorageDO getStorageById(Long id);
}
