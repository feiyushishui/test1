package com.tencent.gaio.workorder.service.intf;

import org.springframework.http.ResponseEntity;

public interface IWorkorderTraceService {

    /**
     * 通过工单标识查询工单痕迹
     *
     * @param workorderid
     * @return
     */
    ResponseEntity findTracesByWorkorderid(String workorderid);
}
