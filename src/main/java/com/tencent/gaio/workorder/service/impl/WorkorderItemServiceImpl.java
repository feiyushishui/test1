package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.workorder.domain.WorkorderItem;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderItemServiceImpl implements IWorkorderItemService {

    @Autowired
    private WorkorderFeign workorderFeign;

    /**
     * 通过工单标识查询事项信息
     *
     * @param workorderid
     * @return
     */
    @Override
    public WorkorderItem findItemByWorkorderid(String workorderid) {
        return workorderFeign.findItemByWorkorder(workorderid, "id");
    }

    /**
     * 通过工单code查询事项信息
     *
     * @param workorderCode
     * @return
     */
    @Override
    public WorkorderItem findItemByWorkorderCode(String workorderCode) {
        return workorderFeign.findItemByWorkorder(workorderCode, "code");
    }
}