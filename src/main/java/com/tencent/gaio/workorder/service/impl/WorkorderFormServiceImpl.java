package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.workorder.domain.WorkorderForm;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderFormService;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderFormServiceImpl implements IWorkorderFormService {

    @Autowired
    private WorkorderFeign workorderFeign;

    /**
     * 通过工单标识查询表单
     *
     * @param workorderid
     * @return
     */
    @Override
    public ResponseEntity<WorkorderForm> findByWorkorderid(String workorderid) {
        return workorderFeign.findByWorkorderid(workorderid, "id");
    }

    /**
     * 通过工单code查询表单
     *
     * @param workorderCode
     * @return
     */
    @Override
    public ResponseEntity findByWorkorderCode(String workorderCode) {
        return workorderFeign.findByWorkorderCode(workorderCode, "code");
    }

    /**
     * 根据id更新工单-申请人信息
     *
     * @param applyVo
     * @param id
     * @return
     */
    @Override
    public String updateWorkorderById(ApplyerVo applyVo, long id) {
        return workorderFeign.updateWorkorderById(applyVo, id, "id");
    }

    /**
     * 根据code更新工单-申请人信息
     *
     * @param applyVo
     * @param workorderCode
     * @return
     */
    @Override
    public String updateWorkorderByCode(ApplyerVo applyVo, String workorderCode) {
        return workorderFeign.updateWorkorderByCode(applyVo, workorderCode, "code");
    }

    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    public String updateFormsByWorkorderId(WorkorderFormVo vo, Long workorderId) {
        return workorderFeign.updateFormsByWorkorderId(vo, workorderId, "id");
    }

    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    public String updateFormsByWorkorderCode(WorkorderFormVo vo, String workorderCode) {
        return workorderFeign.updateFormsByWorkorderCode(vo, workorderCode, "code");
    }
}