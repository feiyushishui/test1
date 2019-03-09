package com.tencent.gaio.affair.service.impl;

import com.tencent.gaio.affair.domain.Item;
import com.tencent.gaio.affair.feign.ItemFeign;
import com.tencent.gaio.affair.service.intf.IItemService;
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
    public String page( String name,String taskCode){
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("mark","page");
        map.put("taskCode",taskCode);

        return itemFeign.page(map);
    }

    /**
     * 根据事项实施编码code查询数据
     * @param itemTaskCode
     * @return
     */
    @Override
    public ResponseEntity<Item> queryItemByCode(String itemTaskCode) {
        return itemFeign.queryItemByCode(itemTaskCode,"code");
    }

    /**
     * 根据事项实施标识id查询数据
     * @param itemTaskCode
     * @return
     */
    @Override
    public ResponseEntity<Item> queryItemById(long itemTaskCode) {
        return itemFeign.queryItemById(itemTaskCode,"id");
    }


}
