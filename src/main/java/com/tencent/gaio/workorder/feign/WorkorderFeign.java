package com.tencent.gaio.workorder.feign;

import com.tencent.gaio.apis.workorder.entity.WorkorderEntity;
import com.tencent.gaio.apis.workorder.entity.WorkorderTraceEntity;
import com.tencent.gaio.commons.http.DataItem;
import com.tencent.gaio.commons.http.DataPage;
import com.tencent.gaio.workorder.domain.WorkorderForm;
import com.tencent.gaio.workorder.domain.WorkorderItem;
import com.tencent.gaio.workorder.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "${workorder-apis:workorder-apis}", url = "http://localhost:8081")
public interface WorkorderFeign {

    /**
     * 根据条件分页查询-工单草稿列表
     *
     * @return
     */
    @RequestMapping(value = {"/workorders"}, method = RequestMethod.GET)
    DataPage workorderDraftPage(@RequestParam Map<String, Object> map);

    /**
     * 新建工单【确认】
     * author luochaoqiang
     *
     * @param workorderVO
     */
    @RequestMapping(value = "/workorders", method = RequestMethod.POST)
    ResponseEntity<WorkorderEntity> create(@RequestBody WorkorderVO workorderVO);

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

    /**
     * 新建工单-表单
     *
     * @param workorderFormVo
     * @param workorderCode
     * @param mark
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/forms", method = RequestMethod.POST)
    void createWorkorderForm(@RequestBody WorkorderFormVo workorderFormVo, @PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    /**
     * 查询工单-事项信息
     */
    @RequestMapping(value = "/workorders/{workorderCode}/items", method = RequestMethod.GET)
    ResponseEntity<WorkorderItem> getWorkorderItem(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);

    /**
     * 更新工单：工单收件
     *
     * @param workorderCode
     * @param vo
     */
    @RequestMapping(value = "/workorders/{workorderCode}", method = RequestMethod.PUT)
    ResponseEntity updateWorkorder(@RequestBody WorkorderEntity vo, @PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark);


    /**
     * 新建工单痕迹
     *
     * @param wte
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/traces", method = RequestMethod.PUT)
    ResponseEntity createTrace(@RequestBody WorkorderTraceEntity wte, @PathVariable("workorderCode") Long workorderCode, @RequestParam("mark") String mark);

    /**
     * 工单操作（认领、提交）
     *
     * @param workorderId
     * @param actInstId
     * @param taskActionReqVo
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/{actInstId}", method = RequestMethod.PUT)
    ResponseEntity<Integer> operateWorkorderByBpm(@PathVariable("workorderCode") String workorderId, @PathVariable("actInstId") String actInstId, @RequestBody TaskActionReqVo taskActionReqVo);

    /**
     * 根据id查询工单意见
     *
     * @param workorderId
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/opinions", method = RequestMethod.GET)
    ResponseEntity<DataItem> getWorkorderComment(@PathVariable("workorderCode") String workorderId, @RequestParam("mark") String mark);

    /**
     * 保存工单意见
     *
     * @param workorderId
     * @param taskDefKey
     * @param commentVo
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/{taskDefKey}/opinions", method = RequestMethod.POST)
    ResponseEntity<Integer> createWorkorderComment(@PathVariable("workorderCode") String workorderId, @PathVariable("taskDefKey") String taskDefKey, @RequestBody CommentVo commentVo, @RequestParam("mark") String mark);

    /**
     * 根据id更新轨迹信息
     *
     * @param workorderId
     */
    @RequestMapping(value = "/workorders/{workorderCode}/{actInstId}/traces", method = RequestMethod.PUT)
    ResponseEntity<Integer> updateWorkorderTrace(@PathVariable("workorderCode") String workorderId, @PathVariable("actInstId") String actInstId, @RequestBody WorkorderTraceVo workorderTraceVo, @RequestParam("mark") String mark);


}
