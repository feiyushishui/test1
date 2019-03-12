package com.tencent.gaio.affair.service.intf;


import com.tencent.gaio.apis.affair.entity.ItemConfigEntity;
import com.tencent.gaio.apis.affair.entity.ItemEntity;
import com.tencent.gaio.commons.http.DataList;

public interface IItemService {

    /**
     * 根据taskcode和name简单查询事项
     *
     * @return
     */
    DataPage page(Map<String,Object> map);

    DataList itemMaterialListById(String itemTaskCode);

    DataList itemMaterialListByCode(String itemTaskCode);

    ItemConfigEntity queryConfigsById(String itemTaskCode);

    ItemConfigEntity queryConfigsByCode(String itemTaskCode);

    ItemEntity queryItemByCode(String itemTaskCode);

    ItemEntity queryItemById(long itemTaskCode);
}
