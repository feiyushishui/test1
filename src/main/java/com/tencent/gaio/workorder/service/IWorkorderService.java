package com.tencent.gaio.workorder.service;

import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import org.springframework.http.ResponseEntity;

public interface IWorkorderService {

    /**
     * 查询工单-申请人
     *
     * @param
     * @return
     */
    ResponseEntity<ApplyerVo> getApplyers(String workorderCodeOrId, String mark);


    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    String updateFormsByWorkorderId(WorkorderFormVo vo, Long workorderId);


    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    String updateFormsByWorkorderCode(WorkorderFormVo vo, String workorderCode);

}
