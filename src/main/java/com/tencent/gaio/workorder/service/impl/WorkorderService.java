package com.tencent.gaio.workorder.service.impl;

import com.tencent.gaio.apis.workorder.entity.WorkorderEntity;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.IWorkorderService;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import com.tencent.gaio.workorder.vo.WorkorderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WorkorderService implements IWorkorderService {

    @Autowired
    private WorkorderFeign workorderFeign;

    /**
     * 新建工单【确认】
     * author luochaoqiang
     *
     * @param workorderVO
     */
    @Override
    public ResponseEntity<WorkorderEntity> create(WorkorderVO workorderVO) {
        return workorderFeign.create(workorderVO);
    }

    /**
     * 查询工单-申请人
     *
     * @param
     * @return
     */
    @Override
    public ResponseEntity<ApplyerVo> getApplyers(String workorderCodeOrId, String mark) {
        return workorderFeign.findApplyer(workorderCodeOrId, mark);
    }


    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    @Override
    public String updateFormsByWorkorderId(WorkorderFormVo vo, Long workorderId) {
        return workorderFeign.updateFormsByWorkorderId(vo, workorderId, "id");
    }


    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    @Override
    public String updateFormsByWorkorderCode(WorkorderFormVo vo, String workorderCode) {
        return workorderFeign.updateFormsByWorkorderCode(vo, workorderCode, "code");
    }


}
