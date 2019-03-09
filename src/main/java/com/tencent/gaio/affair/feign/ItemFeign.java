package com.tencent.gaio.affair.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //@RequestMapping(value = {"/{itemId}"}, method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    ResponseEntity findItem(@PathVariable("itemId") Long id, @RequestParam("mark") String mark);

}
