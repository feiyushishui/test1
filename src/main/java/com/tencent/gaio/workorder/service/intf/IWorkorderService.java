package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.workorder.vo.TaskActionReqVo;

public interface IWorkorderService {

    /**
     * 工单操作（认领、提交、代理、代理提交）
     *
     * @param workorderid
     * @param actInstId
     * @param taskActionReqVo
     * @return
     */
    Integer operateWorkorderByBpm(String workorderid, String actInstId, TaskActionReqVo taskActionReqVo);
}
