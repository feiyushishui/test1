package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.apis.workorder.vo.WorkorderMaterialVo;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderMaterialServiceImpl implements IWorkorderMaterialService {
    @Autowired
    private WorkorderFeign workorderFeign;

    public Integer createWorkorderMaterialById(String workorderId,WorkorderMaterialVo vo){
        return workorderFeign.createWorkorderMaterialById(workorderId,vo, "id").getBody();
    }
    public Integer createWorkorderMaterialByCode(String workorderId,WorkorderMaterialVo vo){
        return workorderFeign.createWorkorderMaterialByCode(workorderId,vo, "code").getBody();
    }
}