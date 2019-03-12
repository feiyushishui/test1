package com.tencent.gaio.affair.service.intf;


import com.tencent.gaio.apis.affair.entity.ItemEntity;

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

    ItemEntity queryItemByCode(String itemTaskCode);

    ItemEntity queryItemById(long itemTaskCode);
}
