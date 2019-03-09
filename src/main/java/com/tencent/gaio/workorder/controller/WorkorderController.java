package com.tencent.gaio.workorder.controller;


import com.tencent.gaio.commons.Constants;
import com.tencent.gaio.workorder.vo.ApplyVo;
import com.tencent.gaio.workorder.service.intf.IWorkorderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkorderController {

    @Autowired
    private IWorkorderFormService workorderFormService;

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
     * @param applyVo
     * @param workorderCode
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=id"})
    public String updateWorkorderById(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode")long workorderCode)  {
        return workorderFormService.updateWorkorderById(applyVo,workorderCode);
    }

    /**
     * 根据code更新工单-申请人
     * @param applyVo
     * @param workorderCode
     * @return
     */
    @PostMapping(value = "/workorders/{workorderCode}/applyers", params = {Constants.DEFAULT_MARK_PARAMETER + "=code"})
    public String updateWorkorderByCode(@RequestBody ApplyVo applyVo, @PathVariable("workorderCode")String workorderCode)  {
        return workorderFormService.updateWorkorderByCode(applyVo,workorderCode);
    }


}
