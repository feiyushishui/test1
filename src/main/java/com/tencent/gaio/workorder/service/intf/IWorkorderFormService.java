package com.tencent.gaio.workorder.service.intf;

import com.tencent.gaio.apis.workorder.entity.WorkorderFormEntity;
import com.tencent.gaio.apis.workorder.vo.ApplyerVo;
import com.tencent.gaio.apis.workorder.vo.WorkorderFormVo;

public interface IWorkorderFormService {

    /**
     * 通过工单标识查询表单
     *
     * @param workorderid
     * @return
     */
    WorkorderFormEntity findByWorkorderid(String workorderid);

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
    WorkorderFormEntity findByWorkorderCode(String workorderCode);

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

    /**
     * 通过工单标识/流水号完成表单提交，并启动工单流程实例
     *
     * @param workorderCode
     * @return
     */
    int submitWorkorderTask(String workorderCode, String mark);
}