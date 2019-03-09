package com.tencent.gaio.workorder.service;

import com.tencent.gaio.commons.http.WrapperPage;
import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public interface IWorkorderService {

    /**
     * 根据条件分页查询-工单草稿列表
     * @param params
     * @return
     */
    WrapperPage workorderDraftPage(Map<String,Object> params);

    /**
     * 查询工单-申请人
     *
     * @param
     * @return
     */
    ResponseEntity<ApplyerVo> getApplyers(String workorderCodeOrId, String mark);


    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    String updateFormsByWorkorderId(WorkorderFormVo vo, Long workorderId);


    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    String updateFormsByWorkorderCode(WorkorderFormVo vo, String workorderCode);

}
