package com.tencent.gaio.workorder.service.impl;

import com.tencent.gaio.apis.workorder.entity.WorkorderEntity;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.IWorkorderService;
import com.tencent.gaio.workorder.service.intf.IWorkorderService;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import com.tencent.gaio.workorder.vo.WorkorderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderServiceImpl implements IWorkorderService {

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


    /**
     * 工单操作（认领、提交、代理、代理提交）
     *
     * @param workorderid
     * @param actInstId
     * @param taskActionReqVo
     * @return
     */
    @Override
    public Integer operateWorkorderByBpm(String workorderid, String actInstId, TaskActionReqVo taskActionReqVo) {
        return workorderFeign.operateWorkorderByBpm(workorderid, actInstId, taskActionReqVo).getBody();
    }
}
