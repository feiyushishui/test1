package com.tencent.gaio.affair.service.intf;


import com.tencent.gaio.apis.affair.entity.ItemEntity;

public interface IItemService {

    /**
     * 根据taskcode和name简单查询事项
     *
     * @return
     */
    String page(String name, String taskCode);

    DataList itemMaterialListById(String itemTaskCode);

    DataList itemMaterialListByCode(String itemTaskCode);

    ItemConfigEntity queryConfigsById(String itemTaskCode);

    ItemConfigEntity queryConfigsByCode(String itemTaskCode);

    ItemEntity queryItemByCode(String itemTaskCode);

    ItemEntity queryItemById(long itemTaskCode);
}
