package com.tencent.gaio.workorder.feign;

import com.tencent.gaio.commons.http.DataItem;
import com.tencent.gaio.workorder.domain.WorkorderApplyer;
import com.tencent.gaio.workorder.domain.WorkorderForm;
import com.tencent.gaio.workorder.domain.WorkorderItem;
import com.tencent.gaio.workorder.domain.WorkorderTraces;
import com.tencent.gaio.workorder.vo.ApplyVo;
import com.tencent.gaio.workorder.vo.CommentVo;
import com.tencent.gaio.workorder.vo.TaskActionReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "${workorder-apis:workorder-apis}", url = "http://localhost:8081")
public interface WorkorderFeign {

    /**
     * 根据id查询工单-表单
     * @param workorderId
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/forms", method = RequestMethod.GET)
    ResponseEntity<WorkorderForm> findByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    /**
     * 根据code查询工单-表单
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/forms", method = RequestMethod.GET)
    ResponseEntity<WorkorderForm> findByWorkorderCode(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    /**
     * 根据id更新申请人信息
     *
     * @param applyVo
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.PUT)
    String updateWorkorderById(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode") long workorderCode, @RequestParam("mark") String mark);

    /**
     * 根据code更新申请人信息
     *
     * @param applyVo
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.PUT)
    String updateWorkorderByCode(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    @RequestMapping(value = "/workorders/{workorderCode}/applyers", method = RequestMethod.GET)
    ResponseEntity<WorkorderApplyer> findApplyerByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    @RequestMapping(value = "/workorders/{workorderCode}/items", method = RequestMethod.GET)
    ResponseEntity<WorkorderItem> findItemByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);


    @RequestMapping(value = "/workorders/{workorderCode}/traces", method = RequestMethod.GET)
    ResponseEntity<WorkorderTraces> findTracesByWorkorderid(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    @RequestMapping(value = "/workorders/{workorderCode}/{actInstId}", method = RequestMethod.PUT)
    ResponseEntity<Integer> operateWorkorderByBpm(@PathVariable("workorderCode") String workorderId, @PathVariable("actInstId") String actInstId, @RequestBody TaskActionReqVo taskActionReqVo);

    @RequestMapping(value = "/workorders/{workorderCode}/opinions", method = RequestMethod.GET)
    ResponseEntity<DataItem> getWorkorderComment(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    @RequestMapping(value = "/workorders/{workorderCode}/{taskDefKey}/opinions", method = RequestMethod.POST)
    ResponseEntity<Integer> createWorkorderComment(@PathVariable("workorderCode") String workorderId, @PathVariable("taskDefKey") String taskDefKey, @RequestBody CommentVo commentVo, @RequestParam("mark") String mark);

}
