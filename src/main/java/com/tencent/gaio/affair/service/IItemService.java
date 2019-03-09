package com.tencent.gaio.affair.service;


import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IItemService {

    /**
     * 测试方法
     * @return
     */
    String test();


    /**
     * 根据taskcode和name简单查询事项
     * @return
     */
    String page(String name,String taskCode);

    /**
     * 根据条件查询事项基本信息
     * @param queryParams
     * @return
     */
    ResponseEntity findItem(Map<String,Object> queryParams);

}
