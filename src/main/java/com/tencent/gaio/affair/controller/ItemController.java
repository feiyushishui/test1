package com.tencent.gaio.affair.controller;

import com.tencent.gaio.affair.service.intf.IItemService;
import com.tencent.gaio.commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String page(@RequestParam String name,@RequestParam String taskCode){
        return  iItemService.page(name,taskCode);
    }

    /**
     * 根据事项实施编码code查询数据
     * @param itemTaskCode
     * @return
     */
    @GetMapping(value = "/items/{itemTaskCode}", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity queryItemByCode(@PathVariable("itemTaskCode") String itemTaskCode) {
        return iItemService.queryItemByCode(itemTaskCode);
    }

    /**
     * 根据事项实施标识id查询数据
     * @param itemTaskCode
     * @return
     */
    @GetMapping(value = "/items/{itemTaskCode}", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity queryItemById(@PathVariable("itemTaskCode") long itemTaskCode) {
        return iItemService.queryItemById(itemTaskCode);
    }
}
