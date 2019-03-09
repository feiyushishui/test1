package com.tencent.gaio.workorder.service.intf;

import org.springframework.http.ResponseEntity;

public interface IWorkorderFormService {

    /**
     * 通过工单标识查询表单
     *
     * @param workorderid
     * @return
     */
    ResponseEntity findByWorkorderid(String workorderid);
}