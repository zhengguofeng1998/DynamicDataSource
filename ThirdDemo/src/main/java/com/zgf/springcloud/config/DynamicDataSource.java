package com.zgf.springcloud.config;

import com.zgf.springcloud.holder.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> myTargetDataSources;

    public DynamicDataSource(Map<Object, Object> myTargetDataSources) {
        this.myTargetDataSources = myTargetDataSources;
    }

    public DynamicDataSource() {
    }

    public Map<Object, Object> getMyTargetDataSources() {
        return myTargetDataSources;
    }

    public void setMyTargetDataSources(Map<Object, Object> myTargetDataSources) {
        this.myTargetDataSources = myTargetDataSources;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }
}