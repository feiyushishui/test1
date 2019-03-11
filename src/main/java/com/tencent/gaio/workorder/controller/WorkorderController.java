package com.tencent.gaio.workorder.controller;


import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.workorder.service.intf.IWorkorderApplyerService;
import com.tencent.gaio.workorder.service.intf.IWorkorderFormService;
import com.tencent.gaio.workorder.service.intf.IWorkorderItemService;
import com.tencent.gaio.workorder.service.intf.IWorkorderTraceService;
import com.tencent.gaio.workorder.vo.*;
import com.tencent.gaio.workorder.service.intf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class WorkorderController {

    @Autowired
    private IWorkorderFormService workorderFormService;
    @Autowired
    private IWorkorderApplyerService workorderApplyerService;
    @Autowired
    private IWorkorderItemService workorderItemService;
    @Autowired
    private IWorkorderTraceService workorderTraceService;
    @Autowired
    private IWorkorderCommentService workorderCommentService;
    @Autowired
    private IWorkorderService workorderService;

    /**
     * 新建工单【确认】
     * author luochaoqiang
     *
     * @param workorderVO
     */
    @RequestMapping(value = "/workorders", method = {RequestMethod.POST})
    public ResponseEntity create(@RequestBody WorkorderVO workorderVO) {
        return workorderService.create(workorderVO);
    }

    /**
     * 根据id查询工单-表单
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderFormById(@PathVariable("workorderCode") String workorderId) {
        return workorderFormService.findByWorkorderid(workorderId);
    }

    /**
     * 根据code查询工单-表单
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity getWorkorderFormByCode(@PathVariable("workorderCode") String workorderCode) {
        return workorderFormService.findByWorkorderCode(workorderCode);
    }

    /**
     * 根据id更新工单-申请人
     *
     * @param applyVo
     * @param workorderCode
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public String updateWorkorderById(@RequestBody ApplyerVo applyVo, @PathVariable("workorderCode") long workorderCode) {
        return workorderFormService.updateWorkorderById(applyVo, workorderCode);
    }

    /**
     * 根据code更新工单-申请人
     *
     * @param applyVo
     * @param workorderCode
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public String updateWorkorderByCode(@RequestBody ApplyerVo applyVo, @PathVariable("workorderCode") String workorderCode) {
        return workorderFormService.updateWorkorderByCode(applyVo, workorderCode);
    }

    /**
     * 查询工单-申请人信息
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderApplyerById(@PathVariable("workorderCode") String workorderId) {
        return workorderApplyerService.findApplyerByWorkorderid(workorderId);
    }

    /**
     * 查询工单-申请人信息:code
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity getWorkorderApplyerByCode(@PathVariable("workorderCode") String workorderCode) {
        return workorderApplyerService.findApplyerByWorkorderCode(workorderCode);
    }

    /**
     * 查询工单-事项信息
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/items", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderItemById(@PathVariable("workorderCode") String workorderId) {
        return workorderItemService.findItemByWorkorderid(workorderId);
    }

    /**
     * 查询工单-事项信息:code
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/items", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity getWorkorderItemByCode(@PathVariable("workorderCode") String workorderCode) {
        return workorderItemService.findItemByWorkorderCode(workorderCode);
    }

    /**
     * 查询工单痕迹:id
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/traces", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public String getWorkorderTraceById(@PathVariable("workorderCode") String workorderId) {
        return workorderTraceService.findTracesByWorkorderid(workorderId);
    }

    /**
     * 查询工单痕迹:code
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/traces", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public String getWorkorderTraceByCode(@PathVariable("workorderCode") String workorderCode) {
        return workorderTraceService.findTracesByWorkorderCode(workorderCode);
    }

    /**
     * 通过工单id创建表单信息
     *
     * @param workorderFormVo
     * @param workorderId
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity<Void> createWorkorderFormById(@RequestBody WorkorderFormVo workorderFormVo, @PathVariable("workorderCode") String workorderId) {
        workorderFormService.createWorkorderForm(workorderFormVo, workorderId, "id");
        return ResponseEntity.ok().body(null);
    }

    /**
     * 通过工单code创建表单信息
     *
     * @param workorderFormVo
     * @param workorderCode
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity<Void> createWorkorderFormByCode(@RequestBody WorkorderFormVo workorderFormVo, @PathVariable("workorderCode") String workorderCode) {
        workorderFormService.createWorkorderForm(workorderFormVo, workorderCode, "code");
        return ResponseEntity.ok().body(null);
    }

    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"}, method = RequestMethod.PUT)
    public String updateFormsByWorkorderId(@RequestBody WorkorderFormVo vo, @PathVariable("workorderCode") Long workorderId) {

        return workorderFormService.updateFormsByWorkorderId(vo, workorderId);
    }


    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"}, method = RequestMethod.PUT)
    public String updateFormsByWorkorderCode(@RequestBody WorkorderFormVo vo, @PathVariable("workorderCode") String workorderCode) {

        return workorderFormService.updateFormsByWorkorderCode(vo, workorderCode);
    }

    @PutMapping(value = "/workorders/{workorderCode}/tasks")
    public ResponseEntity submitWorkorderTask(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark) {
        int reval = workorderFormService.submitWorkorderTask(workorderCode, mark);
        return ResponseEntity.ok().body(reval);
    }

    /**
     * 工单认领
     *
     * @param workorderId
     * @param actInstId
     * @param taskActionReqVo
     */
    @PutMapping(value = "/workorders/{workorderCode}/{actInstId}", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity claimWorkOrder(@PathVariable("workorderCode") String workorderId, @PathVariable("actInstId") String actInstId, @RequestBody TaskActionReqVo taskActionReqVo) {
        //认领操作
        int num = workorderService.operateWorkorderByBpm(workorderId, actInstId, taskActionReqVo).intValue();
        int count = 0;
        if(num > 0){
            WorkorderTraceVo workorderTraceVo = new WorkorderTraceVo();
            workorderTraceVo.setAssignBy(taskActionReqVo.getAssignee());
            workorderTraceVo.setAssignAt(new Date());
            //认领成功更新工单轨迹认领信息
            count = workorderTraceService.updateWorkorderTrace(workorderId, actInstId, workorderTraceVo);
        }
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    /**
     * 查询工单意见
     *
     * @param workorderId
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/opinions", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderComment(@PathVariable("workorderCode") String workorderId) {
        return ResponseEntity.status(HttpStatus.OK).body(workorderCommentService.getWorkorderComment(workorderId));
    }

    /**
     * 提交工单意见
     *
     * @param workorderId
     * @param taskDefKey
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/{taskDefKey}/opinions", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity createWorkorderComment(@PathVariable("workorderCode") String workorderId, @PathVariable("taskDefKey") String taskDefKey, @RequestBody CommentVo commentVo) {
        return ResponseEntity.status(HttpStatus.OK).body(workorderCommentService.createWorkorderComment(workorderId, taskDefKey, commentVo).intValue());
    }
}
