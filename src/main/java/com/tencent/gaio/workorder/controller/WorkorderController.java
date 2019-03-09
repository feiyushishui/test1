package com.tencent.gaio.workorder.controller;


import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.workorder.service.intf.*;
import com.tencent.gaio.workorder.vo.ApplyVo;
import com.tencent.gaio.workorder.vo.ClaimVo;
import com.tencent.gaio.workorder.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String updateWorkorderById(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode") long workorderCode) {
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
    public String updateWorkorderByCode(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode") String workorderCode) {
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
     * 查询工单-事项信息
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/items", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderItemById(@PathVariable("workorderCode") String workorderId) {
        return workorderItemService.findItemByWorkorderid(workorderId);
    }

    /**
     * 查询工单痕迹
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/traces", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderTraceById(@PathVariable("workorderCode") String workorderId) {
        return workorderTraceService.findTracesByWorkorderid(workorderId);
    }

    /**
     * 工单认领
     *
     * @param workorderId
     * @param actInstId
     * @param claimVo
     */
    @PutMapping(value = "/workorders/{workorderCode}/claim/{actInstId}", params = {"mark=id"})
    public ResponseEntity claimWorkOrder(@PathVariable("workorderCode") String workorderId, @PathVariable("actInstId") String actInstId, @RequestBody ClaimVo claimVo) {
        return ResponseEntity.status(HttpStatus.OK).body(workorderService.claimWorkOrder(workorderId, actInstId, claimVo).intValue());
    }

    /**
     * 提交工单意见
     *
     * @param workorderId
     * @param taskDefKey
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/{taskDefKey}/opinions", params = {"mark=id"})
    public ResponseEntity createWorkorderComment(@PathVariable("workorderCode") String workorderId, @PathVariable("taskDefKey") String taskDefKey, @RequestBody CommentVo commentVo) {
        return ResponseEntity.status(HttpStatus.OK).body(workorderCommentService.createWorkorderComment(workorderId, taskDefKey, commentVo).intValue());
    }
}
