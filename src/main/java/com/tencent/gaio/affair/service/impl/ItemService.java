package com.tencent.gaio.affair.service.impl;

import com.tencent.gaio.affair.feign.ItemFeign;
import com.tencent.gaio.affair.service.intf.IItemService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String page(String name, String taskCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("mark", "page");
        map.put("taskCode", taskCode);

        return itemFeign.page(map);
    }

    @Override
    public String findItemById(Long id){
        return itemFeign.findItemById(id);
    }

    @Override
    public String findItemByCode(String itemTaskCode){
        return itemFeign.findItemByCode(itemTaskCode);
    }

    @Override
    public String itemMaterialListById(String itemTaskCode){
        return itemFeign.itemMaterialListById(itemTaskCode);

    }

    @Override
    public String itemMaterialListByCode(String itemTaskCode){
        return itemFeign.itemMaterialListByCode(itemTaskCode);

    }
    @Override
    public String queryConfigsById(String itemTaskCode){
        return itemFeign.queryConfigsById(itemTaskCode);

    }
    @Override
    public String queryConfigsByCode(String itemTaskCode){
        return itemFeign.queryConfigsByCode(itemTaskCode);

    }



}
