package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderService;
import com.tencent.gaio.workorder.vo.TaskActionReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderServiceImpl implements IWorkorderService {

    @Autowired
    private WorkorderFeign workorderFeign;

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