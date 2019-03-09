package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderService;
import com.tencent.gaio.workorder.service.intf.IWorkorderTraceService;
import com.tencent.gaio.workorder.vo.ClaimVo;
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

    @Override
    public Integer claimWorkOrder(String workorderid, String actInstId, ClaimVo claimVo) {
        return workorderFeign.claimWorkOrder(workorderid, actInstId, claimVo, "id").getBody();
    }
}