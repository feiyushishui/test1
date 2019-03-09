package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.workorder.vo.ClaimVo;
import org.springframework.http.ResponseEntity;

public interface IWorkorderService {

    /**
     * 工单认领
     *
     * @param workorderid
     * @return
     */
    Integer claimWorkOrder(String workorderid, String actInstId, ClaimVo claimVo);
}
