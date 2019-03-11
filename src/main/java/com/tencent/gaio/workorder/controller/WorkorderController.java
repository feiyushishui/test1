package com.tencent.gaio.workorder.controller;

import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.commons.http.WrapperPage;
import com.tencent.gaio.commons.util.ParameterUtil;
import com.tencent.gaio.workorder.service.intf.IWorkorderService;
import com.tencent.gaio.workorder.service.intf.IWorkorderApplyerService;
import com.tencent.gaio.workorder.service.intf.IWorkorderFormService;
import com.tencent.gaio.workorder.service.intf.IWorkorderItemService;
import com.tencent.gaio.workorder.service.intf.IWorkorderTraceService;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import com.tencent.gaio.workorder.vo.WorkorderVO;
import com.tencent.gaio.workorder.service.intf.*;
import com.tencent.gaio.workorder.vo.CommentVo;
import com.tencent.gaio.workorder.vo.TaskActionReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
     * 根据条件分页查询-工单草稿列表
     *
     * 说明：固定参数  mark=page&state=0 (办件状态state（0：草稿；1：办理；2：完结；）)
     * @return
     */
    @RequestMapping(value = {"/workorders"}, method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=page","state=0"})
    public ResponseEntity<WrapperPage> workorderDraft(HttpServletRequest request){
        Map<String, Object> queryParams = ParameterUtil.wrapObjectMap(request.getParameterMap());
        WrapperPage page = workorderService.workorderDraftPage(queryParams);
        return ResponseEntity.status(HttpStatus.OK).body(page);
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

    /**
     * 完成收件
     * @param workorderCode
     * @param mark
     * @return
     */
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
        int num = workorderService.operateWorkorderByBpm(workorderId, actInstId, taskActionReqVo).intValue();
        if(num > 0){
            //int count = workorderTraceService
        }
        return ResponseEntity.status(HttpStatus.OK).body(num);
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
