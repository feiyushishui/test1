package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.apis.workorder.vo.WorkorderTraceVo;

public interface IWorkorderTraceService {

    /**
     * 通过工单标识查询工单痕迹
     *
     * @param workorderid
     * @return
     */
    String findTracesByWorkorderid(String workorderid);

    /**
     * 通过工单code查询工单痕迹
     *
     * @param workorderCode
     * @return
     */
    String findTracesByWorkorderCode(String workorderCode);

    Integer updateWorkorderTrace(String workorderId, String actInstId, WorkorderTraceVo workorderTraceVo);


}
