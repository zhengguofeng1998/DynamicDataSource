package com.zgf.springcloud.service.slave.impl;

import com.zgf.springcloud.annotation.DS;
import com.zgf.springcloud.domain.slave.StorageDO;
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
    @DS(value = "storage")
    public StorageDO getStorageById(Long id) {
        StorageDO storageById = storageDao.getStorageById(id);
        return storageById;
    }
}
