package com.tencent.gaio.workorder.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 新建工单【确认】
     * author luochaoqiang
     *
     */
    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public String create() {
        return "成功进入页面";
    }


}
