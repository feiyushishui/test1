package com.tencent.gaio.workorder.feign;

import com.tencent.gaio.workorder.vo.ApplyVo;
import com.tencent.gaio.workorder.domain.WorkorderForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "${workorder-apis:workorder-apis}", url = "http://localhost:8081")
public interface WorkorderFeign {

    /**
     * 查询工单-表单
     * @param workorderId
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/forms", method = RequestMethod.GET)
    ResponseEntity<WorkorderForm> findByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    /**
     * 根据id更新申请人信息
     * @param applyVo
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.PUT)
    String updateWorkorderById(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode") long workorderCode, @RequestParam("mark") String mark);

    /**
     * 根据code更新申请人信息
     * @param applyVo
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.PUT)
    String updateWorkorderByCode(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);
}
