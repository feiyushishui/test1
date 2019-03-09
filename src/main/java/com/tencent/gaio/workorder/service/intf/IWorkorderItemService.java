package com.tencent.gaio.workorder.service.intf;

import org.springframework.http.ResponseEntity;

public interface IWorkorderItemService {
    /**
     * 通过工单标识查询事项信息
     *
     * @param workorderid
     * @return
     */
    ResponseEntity findItemByWorkorderid(String workorderid);


    ResponseEntity findItemByWorkorderCode(String workorderCode);
}
