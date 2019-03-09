package com.tencent.gaio.workorder.feign;

import com.tencent.gaio.workorder.domain.WorkorderForm;
import com.tencent.gaio.workorder.domain.WorkorderItem;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "${workorder-apis:workorder-apis}", url = "http://localhost:8081")
public interface WorkorderFeign {

    /**
     * 根据id查询工单-表单
     *
     * @param workorderId
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/forms", method = RequestMethod.GET)
    ResponseEntity<WorkorderForm> findByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    /**
     * 根据code查询工单-表单
     *
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/forms", method = RequestMethod.GET)
    ResponseEntity<WorkorderForm> findByWorkorderCode(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);


    /**
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.GET)
    ResponseEntity<ApplyerVo> findApplyer(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    /**
     * 根据id更新申请人信息
     *
     * @param applyVo
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.PUT)
    String updateWorkorderById(@RequestBody ApplyerVo applyVo, @PathVariable("workorderCode") long workorderCode, @RequestParam("mark") String mark);

    /**
     * 根据code更新申请人信息
     *
     * @param applyVo
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.PUT)
    String updateWorkorderByCode(@RequestBody ApplyerVo applyVo, @PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    /**
     * @param workorderId
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.GET)
    ResponseEntity<ApplyerVo> findApplyerByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    /**
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.GET)
    ResponseEntity<ApplyerVo> findApplyerByWorkorderCode(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    /**
     * @param workorderId
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/items", method = RequestMethod.GET)
    ResponseEntity<WorkorderItem> findItemByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    /**
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/items", method = RequestMethod.GET)
    ResponseEntity<WorkorderItem> findItemByWorkorderCode(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    /**
     * @param workorderId
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/traces", method = RequestMethod.GET)
    String findTracesByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    /**
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/traces", method = RequestMethod.GET)
    String findTracesByWorkorderCode(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    /**
     * 根据code更新工单-表单
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/{workorderCode}/forms", method = RequestMethod.PUT)
    String updateFormsByWorkorderCode(@RequestBody WorkorderFormVo vo, @PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);


    /**
     * 根据id更新工单-表单
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/{workorderCode}/forms", method = RequestMethod.PUT)
    String updateFormsByWorkorderId(@RequestBody WorkorderFormVo vo, @PathVariable("workorderCode") Long workorderId, @RequestParam("mark") String mark);


}
