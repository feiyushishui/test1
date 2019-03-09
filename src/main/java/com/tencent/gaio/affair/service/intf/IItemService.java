package com.tencent.gaio.affair.service.intf;


import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IItemService {

    /**
     * 测试方法
     *
     * @return
     */
    String test();


    /**
     * 根据taskcode和name简单查询事项
     *
     * @return
     */
    String page(String name, String taskCode);

    /**
     * 根据id查询事项基本信息
     * @param id
     * @return
     */
    String findItemById(Long id);

    /**
     * 根据实施编码查询事项基本信息
     * @param itemTaskCode
     * @return
     */
    String findItemByCode(String itemTaskCode);

    String itemMaterialListById(String itemTaskCode);

    String itemMaterialListByCode(String itemTaskCode);

    String queryConfigsById(String itemTaskCode);

    String queryConfigsByCode(String itemTaskCode);

    ResponseEntity queryItemByCode(String itemTaskCode);

    ResponseEntity queryItemById(long itemTaskCode);
}
