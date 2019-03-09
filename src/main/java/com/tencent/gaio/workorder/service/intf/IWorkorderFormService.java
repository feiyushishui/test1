package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.workorder.vo.ApplyerVo;
import com.tencent.gaio.workorder.vo.WorkorderFormVo;
import org.springframework.http.ResponseEntity;

public interface IWorkorderFormService {

    /**
     * 通过工单标识查询表单
     *
     * @param workorderid
     * @return
     */
    ResponseEntity findByWorkorderid(String workorderid);

    /**
     * 通过工单id更新工单申请人信息
     *
     * @param applyVo
     * @param id
     * @return
     */
    String updateWorkorderById(ApplyerVo applyVo, long id);

    /**
     * 通过工单code更新工单申请人信息
     *
     * @param applyVo
     * @param workorderCode
     * @return
     */
    String updateWorkorderByCode(ApplyerVo applyVo, String workorderCode);

    /**
     * 通过工单code查询表单
     *
     * @param workorderCode
     * @return
     */
    ResponseEntity findByWorkorderCode(String workorderCode);

    /**
     * 通过id更新工单-表单
     *
     * @param vo
     * @return
     */
    public String updateFormsByWorkorderId(WorkorderFormVo vo, Long workorderId);

    /**
     * 通过工单code创建表单信息
     *
     * @param workorderFormVo
     * @param workorderCode
     * @return
     */
    void createWorkorderForm(WorkorderFormVo workorderFormVo, String workorderCode, String mark);

    /**
     * 通过code更新工单-表单
     *
     * @param vo
     * @return
     */
    public String updateFormsByWorkorderCode(WorkorderFormVo vo, String workorderCode);
}