package com.tencent.gaio.affair.service.impl;

import com.tencent.gaio.affair.feign.ItemFeign;
import com.tencent.gaio.affair.service.intf.IItemService;
import com.tencent.gaio.apis.affair.entity.ItemConfigEntity;
import com.tencent.gaio.apis.affair.entity.ItemEntity;
import com.tencent.gaio.commons.http.DataList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemFeign itemFeign;

    @Override
    public String page(String name, String taskCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("mark", "page");
        map.put("taskCode", taskCode);

        return itemFeign.page(map);
    }

    @Override
    public DataList itemMaterialListById(String itemTaskCode) {
        return itemFeign.itemMaterialListById(itemTaskCode);

    }

    @Override
    public DataList itemMaterialListByCode(String itemTaskCode) {
        return itemFeign.itemMaterialListByCode(itemTaskCode);

    }

    @Override
    public ItemConfigEntity queryConfigsById(String itemTaskCode) {
        return itemFeign.queryConfigsById(itemTaskCode);

    }

    @Override
    public ItemConfigEntity queryConfigsByCode(String itemTaskCode) {
        return itemFeign.queryConfigsByCode(itemTaskCode);

    }

    /**
     * 根据事项实施编码code查询数据
     *
     * @param itemTaskCode
     * @return
     */
    @Override
    public ItemEntity queryItemByCode(String itemTaskCode) {
        return itemFeign.queryItemByCode(itemTaskCode, "code");
    }

    /**
     * 根据事项实施标识id查询数据
     *
     * @param itemTaskCode
     * @return
     */
    @Override
    public ItemEntity queryItemById(long itemTaskCode) {
        return itemFeign.queryItemById(itemTaskCode, "id");
    }
}
