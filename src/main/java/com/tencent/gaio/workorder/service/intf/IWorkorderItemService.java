package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.workorder.domain.WorkorderItem;

public interface IWorkorderItemService {
    /**
     * 通过工单标识查询事项信息
     *
     * @param workorderid
     * @return
     */
    WorkorderItem findItemByWorkorderid(String workorderid);


    WorkorderItem findItemByWorkorderCode(String workorderCode);
}
