package com.tencent.gaio.workorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "${affair-apis:affair-apis}",url = "http://localhost:8083/",path = "/dict")
public interface AffairFeign {

    @GetMapping(value = "/test")
    Long test(@RequestParam("mark") String mark);

    @GetMapping(value = "/test")
    String test1(@RequestParam("mark") String mark);
}
