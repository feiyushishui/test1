package com.tencent.gaio.workorder.service.intf;

import org.springframework.http.ResponseEntity;

public interface IWorkorderApplyerService {
    /**
     * 通过工单标识查询基本信息
     *
     * @param workorderid
     * @return
     */
    ResponseEntity findApplyerByWorkorderid(String workorderid);
}
