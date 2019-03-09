package com.tencent.gaio.affair.controller;

import com.tencent.gaio.affair.service.IItemService;
import com.tencent.gaio.commons.Constants;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() {
        return iItemService.test();
    }

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String page(@RequestParam String name,@RequestParam String taskCode){
        return  iItemService.page(name,taskCode);
    }

    /**
     * 根据事项id查询事项信息
     *
     * @return
     */
    @RequestMapping(value = {"/items/{itemId}"}, method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity findItem(@PathVariable("itemId") Long id) {
        Map<String, Object> queryParams = new HashedMap();
        queryParams.put("id" , id);
        queryParams.put("mark" ,"id");
        //ItemEntity item = itemService.findItem(queryParams);
        return iItemService.findItem(queryParams);
    }
}
