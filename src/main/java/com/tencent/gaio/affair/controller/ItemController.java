package com.tencent.gaio.affair.controller;

import com.tencent.gaio.affair.service.intf.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return iItemService.test();
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String page(@RequestParam String name, @RequestParam String taskCode) {
        return iItemService.page(name, taskCode);
    }


}
