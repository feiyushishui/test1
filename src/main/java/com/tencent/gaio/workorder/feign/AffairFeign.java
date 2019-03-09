package com.tencent.gaio.workorder.feign;

import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.workorder.vo.ApplyVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name= "${workorder-apis:workorder-apis}",url = "http://localhost:8081/",path = "/workorders")
public interface AffairFeign {

    @GetMapping(value = "/test")
    Long test(@RequestParam("mark") String mark);

    @GetMapping(value = "/test")
    String test1(@RequestParam("mark") String mark);

    /**
     * 更新申请人信息
     * @param applyVo
     * @return
     */
    @RequestMapping(value = "/{workorderCode}/applyers", method = RequestMethod.PUT)
    String updateWorkorderById(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode") long workorderCode,@RequestParam("mark") String mark);

    /**
     * 查询工单-表单
     * @param workorderCode
     * @return
     */
    @RequestMapping(value = "/{workorderCode}/forms", method = RequestMethod.GET)
    String getWorkorderFormById(@PathVariable("workorderCode") long workorderCode,@RequestParam("mark") String mark);
}
