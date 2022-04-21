package com.zgf.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: DynamicDataSource
 * @description:
 * @author: zhengguofeng
 * @create: 2022-04-21 10:18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupByVo {
    private String userId;
    private List<SubVo> subVo;




}
