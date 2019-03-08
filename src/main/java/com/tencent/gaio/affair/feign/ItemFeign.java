package com.tencent.gaio.affair.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@FeignClient(name= "${affair-apis:affair-apis}",url = "http://localhost:8080",path = "/items")
public interface ItemFeign {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String test();

    /**
     * 根据条件分页查询事项列表
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    String page(@RequestParam Map<String,Object> map);


}
