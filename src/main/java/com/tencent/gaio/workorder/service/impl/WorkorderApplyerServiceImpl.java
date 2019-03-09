package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderApplyerService;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderApplyerServiceImpl implements IWorkorderApplyerService {

    @Autowired
    private WorkorderFeign workorderFeign;

    /**
     * 通过工单标识查询基本信息
     *
     * @param workorderid
     * @return
     */
    @Override
    public ResponseEntity<ApplyerVo> findApplyerByWorkorderid(String workorderid) {
        return workorderFeign.findApplyerByWorkorderid(workorderid, "id");
    }

    /**
     * 通过code查询基本信息
     *
     * @param workorderCode
     * @return
     */
    @Override
    public ResponseEntity<ApplyerVo> findApplyerByWorkorderCode(String workorderCode) {
        return workorderFeign.findApplyerByWorkorderCode(workorderCode, "code");
    }

}