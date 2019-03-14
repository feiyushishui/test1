package com.tencent.gaio.workorder.controller;


import com.tencent.gaio.apis.bpm.vo.TaskActionReqVo;
import com.tencent.gaio.apis.workorder.entity.WorkorderFormEntity;
import com.tencent.gaio.apis.workorder.vo.*;
import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.commons.http.DataPage;
import com.tencent.gaio.commons.http.ResultModel;
import com.tencent.gaio.commons.util.ParameterUtil;
import com.tencent.gaio.workorder.service.intf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    private IWorkorderMaterialService workorderMaterialService;
    @Autowired
    private IWorkorderService workorderService;

    /**
     * 新建工单【确认】
     * author luochaoqiang
     *
     * @param workorderVO
     */
    @RequestMapping(value = "/workorders", method = {RequestMethod.POST})
    public ResponseEntity create(@RequestBody WorkorderVo workorderVO) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderService.create(workorderVO)));
    }

    /**
     * 根据条件分页查询-工单草稿列表
     * <p>
     * 说明：固定参数  mark=page&state=0 (办件状态state（0：草稿；1：办理；2：完结；）)
     *
     * @return
     */
    @RequestMapping(value = {"/workorders"}, method = RequestMethod.GET, params = {Constants.DEFAULT_MARK_PARAMETER + "=page", "state=0"})
    public ResponseEntity workorderDraft(HttpServletRequest request) {
        Map<String, Object> queryParams = ParameterUtil.wrapObjectMap(request.getParameterMap());
        DataPage data = workorderService.workorderDraftPage(queryParams);
        ResultModel resultModel = new ResultModel(data);
        return ResponseEntity.ok(resultModel);
    }

    /**
     * 根据id查询工单-表单
     * @author wangheng
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/forms")
    public ResponseEntity<ResultModel<WorkorderFormEntity>> getWorkorderFormById(@PathVariable("workorderCode") String workorderId) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderFormService.findByWorkorderid(workorderId)));
    }

    /**
     * 根据code查询工单-表单
     * @author wangheng
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity<ResultModel<WorkorderFormEntity>> getWorkorderFormByCode(@PathVariable("workorderCode") String workorderCode) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderFormService.findByWorkorderCode(workorderCode)));
    }

    /**
     * 根据id更新工单-申请人
     * @author wangheng
     * @param applyVo
     * @param workorderCode
     * @return
     */
    @PutMapping(value = "/workorders/{workorderCode}/applyers")
    public ResponseEntity<ResultModel> updateWorkorderById(@RequestBody ApplyerVo applyVo, @PathVariable("workorderCode") long workorderCode) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderFormService.updateWorkorderById(applyVo, workorderCode)));
    }

    /**
     * 根据code更新工单-申请人
     * @author wangheng
     * @param applyVo
     * @param workorderCode
     * @return
     */
    @PutMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity<ResultModel> updateWorkorderByCode(@RequestBody ApplyerVo applyVo, @PathVariable("workorderCode") String workorderCode) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderFormService.updateWorkorderByCode(applyVo, workorderCode)));
    }

    /**
     * 查询工单-申请人信息
     * @author zouwei
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/applyers")
    public ResponseEntity<ResultModel<ApplyerVo>> getWorkorderApplyerById(@PathVariable("workorderCode") String workorderId) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderApplyerService.findApplyerByWorkorderid(workorderId)));
    }

    /**
     * 查询工单-申请人信息:code
     * @author zouwei
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity<ResultModel<ApplyerVo>> getWorkorderApplyerByCode(@PathVariable("workorderCode") String workorderCode) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderApplyerService.findApplyerByWorkorderCode(workorderCode)));
    }

    /**
     * 查询工单-事项信息
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/items", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderItemById(@PathVariable("workorderCode") String workorderId) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderItemService.findItemByWorkorderid(workorderId)));
    }

    /**
     * 查询工单-事项信息:code
     *
     * @return
     */
    /**
     * 查询工单-事项信息:code
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/items", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity getWorkorderItemByCode(@PathVariable("workorderCode") String workorderCode) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderItemService.findItemByWorkorderCode(workorderCode)));
    }

    /**
     * 查询工单痕迹:id
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/traces", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderTraceById(@PathVariable("workorderCode") String workorderId) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderTraceService.findTracesByWorkorderid(workorderId)));
    }

    /**
     * 查询工单痕迹:code
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/traces", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity getWorkorderTraceByCode(@PathVariable("workorderCode") String workorderCode) {
        return ResponseEntity.ok().body(new ResultModel<>(workorderTraceService.findTracesByWorkorderCode(workorderCode)));
    }

    /**
     * 通过工单id创建表单信息
     *
     * @param workorderFormVo
     * @param workorderId
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity createWorkorderFormById(@RequestBody WorkorderFormVo workorderFormVo, @PathVariable("workorderCode") String workorderId) {
        workorderFormService.createWorkorderForm(workorderFormVo, workorderId, "id");
        return ResponseEntity.ok().body(new ResultModel<>(null));
    }

    /**
     * 通过工单code创建表单信息
     *
     * @param workorderFormVo
     * @param workorderCode
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public ResponseEntity createWorkorderFormByCode(@RequestBody WorkorderFormVo workorderFormVo, @PathVariable("workorderCode") String workorderCode) {
        workorderFormService.createWorkorderForm(workorderFormVo, workorderCode, "code");
        return ResponseEntity.ok().body(new ResultModel<>(null));
    }

    /**
     * 通过id更新工单-表单
     * @author zouwei
     * @param vo
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/forms", method = RequestMethod.PUT)
    public ResponseEntity<ResultModel> updateFormsByWorkorderId(@RequestBody WorkorderFormVo vo, @PathVariable("workorderCode") Long workorderId) {

        return ResponseEntity.ok().body(new ResultModel<>(workorderFormService.updateFormsByWorkorderId(vo, workorderId)));
    }


    /**
     * 通过code更新工单-表单
     * @author zouwei
     * @param vo
     * @return
     */
    @RequestMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"}, method = RequestMethod.PUT)
    public ResponseEntity<ResultModel> updateFormsByWorkorderCode(@RequestBody WorkorderFormVo vo, @PathVariable("workorderCode") String workorderCode) {

        return ResponseEntity.ok().body(new ResultModel<>(workorderFormService.updateFormsByWorkorderCode(vo, workorderCode)));
    }

    /**
     * 完成收件
     *
     * @param workorderCode
     * @param mark
     * @return
     */
    @PutMapping(value = "/workorders/{workorderCode}/tasks")
    public ResponseEntity submitWorkorderTask(@PathVariable("workorderCode") String workorderCode, @RequestParam("mark") String mark) {
        int reval = workorderFormService.submitWorkorderTask(workorderCode, mark);
        return ResponseEntity.ok().body(new ResultModel<>(reval));
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
        if (num > 0) {
            WorkorderTraceVo workorderTraceVo = new WorkorderTraceVo();
            workorderTraceVo.setAssignBy(taskActionReqVo.getAssignee());
            workorderTraceVo.setAssignAt(new Date());
            //认领成功更新工单轨迹认领信息
            count = workorderTraceService.updateWorkorderTrace(workorderId, actInstId, workorderTraceVo);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResultModel<>(count));
    }

    /**
     * 查询工单意见
     *
     * @param workorderId
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/opinions", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderComment(@PathVariable("workorderCode") String workorderId) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResultModel<>(workorderCommentService.getWorkorderComment(workorderId)));
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
        return ResponseEntity.status(HttpStatus.OK).body(new ResultModel<>(workorderCommentService.createWorkorderComment(workorderId, taskDefKey, commentVo).intValue()));
    }

    /**
     * 提交工单-上传材料
     *
     * @param workorderId
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/materials", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity createWorkorderMaterialById(@PathVariable("workorderCode") String workorderId, @RequestBody WorkorderMaterialVo materialVo) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResultModel<>(workorderMaterialService.createWorkorderMaterialById(workorderId, materialVo).intValue()));
    }

}
