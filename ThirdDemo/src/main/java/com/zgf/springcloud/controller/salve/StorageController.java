package com.zgf.springcloud.controller.salve;

import com.zgf.springcloud.domain.slave.StorageDO;
import com.zgf.springcloud.service.slave.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloudBiliBili
 * @description:
 * @author: zhengguofeng
 * @create: 2021-12-25 14:12
 **/
@RestController
@RequestMapping("/storage")
@Slf4j
public class StorageController {

    @Autowired
    public StorageService storageService;

    @GetMapping("/getStorageById/{id}")
    public StorageDO getStorageById(@PathVariable("id") Long id) {
        StorageDO storage = storageService.getStorageById(id);
        return storage;
    }

}
