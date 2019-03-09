package com.tencent.gaio.workorder.controller;


import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.workorder.service.intf.IWorkorderApplyerService;
import com.tencent.gaio.workorder.service.intf.IWorkorderFormService;
import com.tencent.gaio.workorder.service.intf.IWorkorderItemService;
import com.tencent.gaio.workorder.service.intf.IWorkorderTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 查询工单-表单
     *
     * @return
     */
    @GetMapping(value = "/workorders/{workorderCode}/forms", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public ResponseEntity getWorkorderFormById(@PathVariable("workorderCode") String workorderId) {
        return workorderFormService.findByWorkorderid(workorderId);
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
        return workorderTraceService.findTraceByWorkorderid(workorderId);
    }



}
