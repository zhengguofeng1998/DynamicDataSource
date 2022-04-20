package com.zgf.springcloud.service.slave.impl;

import com.zgf.springcloud.domain.slave.StorageDO;
import com.zgf.springcloud.holder.DynamicDataSourceContextHolder;
import com.zgf.springcloud.mapper.slave.StorageDao;
import com.zgf.springcloud.service.slave.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-19 15:43
 **/
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;

    @Override
    public StorageDO getStorageById(Long id) {
        DynamicDataSourceContextHolder.setContextKey("storage");
        StorageDO storageById = storageDao.getStorageById(id);
        DynamicDataSourceContextHolder.removeContextKey();
        return storageById;
    }
}
