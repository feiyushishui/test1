package com.tencent.gaio.workorder.controller;


import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.workorder.vo.ApplyVo;
import com.tencent.gaio.workorder.feign.AffairFeign;
import com.tencent.gaio.workorder.service.intf.ISomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SomeController {

    @Autowired
    private AffairFeign affairFeign;

    @Autowired
    private ISomeService someService;

    @GetMapping("/test")
    public Long test() {
        return affairFeign.test("code");
    }

    @GetMapping("/test1")
    public String test1() {
        return affairFeign.test1("id");
    }

    @PostMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public String updateWorkorderById(@RequestBody ApplyVo applyVo,@PathVariable("workorderCode")long workorderCode)  {
        String mark="id";
        return someService.updateWorkorderById(applyVo,workorderCode);
    }

    @GetMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public String getWorkorderFormById(@PathVariable("workorderCode")long workderId)  {
        return someService.getWorkorderFormById(workderId);
    }

}
