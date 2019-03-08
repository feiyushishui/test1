package com.tencent.gaio.affair.service.impl;

import com.tencent.gaio.affair.feign.ItemFeign;
import com.tencent.gaio.affair.service.intf.IItemService;
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

}
