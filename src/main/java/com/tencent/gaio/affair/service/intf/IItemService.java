package com.tencent.gaio.affair.service.intf;


import org.springframework.http.ResponseEntity;

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

    String itemMaterialListById(String itemTaskCode);

    String itemMaterialListByCode(String itemTaskCode);

    String queryConfigsById(String itemTaskCode);

    String queryConfigsByCode(String itemTaskCode);

    ResponseEntity queryItemByCode(String itemTaskCode);

    ResponseEntity queryItemById(long itemTaskCode);
}
