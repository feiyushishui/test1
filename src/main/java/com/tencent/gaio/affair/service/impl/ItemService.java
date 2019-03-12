package com.tencent.gaio.affair.service.impl;

import com.tencent.gaio.affair.feign.ItemFeign;
import com.tencent.gaio.affair.service.intf.IItemService;
import com.tencent.gaio.apis.affair.entity.ItemEntity;
import com.tencent.gaio.commons.http.DataPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemFeign itemFeign;

    @Override
    public String test() {
        return itemFeign.test();
    }

    @Override
    public DataPage page(Map<String,Object> map) {
        return itemFeign.page(map);
    }

    @Override
    public String itemMaterialListById(String itemTaskCode) {
        return itemFeign.itemMaterialListById(itemTaskCode);

    }

    @Override
    public String itemMaterialListByCode(String itemTaskCode) {
        return itemFeign.itemMaterialListByCode(itemTaskCode);

    }

    @Override
    public String queryConfigsById(String itemTaskCode) {
        return itemFeign.queryConfigsById(itemTaskCode);

    }

    @Override
    public String queryConfigsByCode(String itemTaskCode) {
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
