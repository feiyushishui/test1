package com.tencent.gaio.workorder.controller;

import com.tencent.gaio.affair.feign.AffairFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @Autowired
    private AffairFeign affairFeign;

    @GetMapping("/test")
    public Long test() {
        return affairFeign.test("code");
    }

    @GetMapping("/test1")
    public String test1() {
        return affairFeign.test1("id");
    }


}
