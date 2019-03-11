package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderTraceService;
import com.tencent.gaio.workorder.vo.WorkorderTraceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderTraceServiceImpl implements IWorkorderTraceService {

    @Autowired
    private WorkorderFeign workorderFeign;

    @Override
    public String findTracesByWorkorderid(String workorderid) {
        return workorderFeign.findTracesByWorkorderid(workorderid, "id");
    }

    @Override
    public String findTracesByWorkorderCode(String workorderCode) {
        return workorderFeign.findTracesByWorkorderCode(workorderCode, "code");
    }

    @Override
    public Integer updateWorkorderTrace(String workorderId, String actInstId, WorkorderTraceVo workorderTraceVo) {
        return workorderFeign.updateWorkorderTrace(workorderId, actInstId, workorderTraceVo, "id").getBody();
    }
}