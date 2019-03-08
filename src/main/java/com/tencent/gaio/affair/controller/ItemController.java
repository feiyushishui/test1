package com.tencent.gaio.affair.controller;

import com.tencent.gaio.affair.feign.ItemFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ItemController {

    @Autowired
    private ItemFeign itemFeign;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() {
        return itemFeign.test();
    }

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String page(@RequestParam String name,@RequestParam String taskCode){
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("mark","page");
        map.put("taskCode",taskCode);

        return itemFeign.page(map);

    }


}
