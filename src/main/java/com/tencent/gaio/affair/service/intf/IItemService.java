package com.tencent.gaio.affair.service.intf;


import com.tencent.gaio.apis.affair.entity.ItemConfigEntity;
import com.tencent.gaio.commons.http.DataList;
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

    DataList itemMaterialListById(String itemTaskCode);

    DataList itemMaterialListByCode(String itemTaskCode);

    ItemConfigEntity queryConfigsById(String itemTaskCode);

    ItemConfigEntity queryConfigsByCode(String itemTaskCode);

    ResponseEntity queryItemByCode(String itemTaskCode);

    ResponseEntity queryItemById(long itemTaskCode);
}
