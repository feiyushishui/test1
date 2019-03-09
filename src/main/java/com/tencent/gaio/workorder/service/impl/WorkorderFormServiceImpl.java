package com.tencent.gaio.workorder.service.impl;


import com.tencent.gaio.workorder.domain.WorkorderForm;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.intf.IWorkorderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 工单服务接口实现类
 */
@Service
public class WorkorderFormServiceImpl implements IWorkorderFormService {

    @Autowired
    private WorkorderFeign workorderFeign;

    /**
     * 通过工单标识查询表单
     *
     * @param workorderid
     * @return
     */
    @Override
    public ResponseEntity<WorkorderForm> findByWorkorderid(String workorderid) {
        ResponseEntity<WorkorderForm> asdf = workorderFeign.findByWorkorderid(workorderid, "id");

        return asdf;
    }
}