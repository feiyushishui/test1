package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.workorder.vo.ApplyerVo;
import org.springframework.http.ResponseEntity;

public interface IWorkorderApplyerService {
    /**
     * 通过工单标识查询基本信息
     *
     * @param workorderid
     * @return
     */
    ApplyerVo findApplyerByWorkorderid(String workorderid);
    /**
     * 通过工单code查询基本信息
     *
     * @param workorderCode
     * @return
     */
    ApplyerVo findApplyerByWorkorderCode(String workorderCode);

}
