package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderTraceServiceImpl implements IWorkorderTraceService {

    @Autowired
    private WorkorderFeign workorderFeign;

    public String findTracesByWorkorderid(String workorderid) {
        return workorderFeign.findTracesByWorkorderid(workorderid, "id");
    }

    public String findTracesByWorkorderCode(String workorderCode) {
        return workorderFeign.findTracesByWorkorderCode(workorderCode, "code");
    }
}