package com.tencent.gaio.workorder.service.impl;

import com.tencent.gaio.commons.http.WrapperPage;
import com.tencent.gaio.workorder.feign.WorkorderFeign;
import com.tencent.gaio.workorder.service.IWorkorderService;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Service
public class WorkorderService implements IWorkorderService {

    @Autowired
    private WorkorderFeign workorderFeign;

    /**
     * 根据条件分页查询-工单草稿列表
     * @param params
     * @return
     */
    @Override
    public WrapperPage workorderDraftPage(Map<String,Object> params){

        return workorderFeign.workorderDraftPage(params);
    }

    /**
     * 查询工单-申请人
     *
     * @param
     * @return
     */
    @Override
    public ResponseEntity<ApplyerVo> getApplyers(String workorderCodeOrId, String mark) {
        return workorderFeign.findApplyer(workorderCodeOrId, mark);
    }


    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    @Override
    public String updateFormsByWorkorderId(WorkorderFormVo vo, Long workorderId) {
        return workorderFeign.updateFormsByWorkorderId(vo, workorderId, "id");
    }


    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    @Override
    public String updateFormsByWorkorderCode(WorkorderFormVo vo, String workorderCode) {
        return workorderFeign.updateFormsByWorkorderCode(vo, workorderCode, "code");
    }


}
