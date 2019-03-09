package com.tencent.gaio.workorder.vo;


import com.tencent.gaio.workorder.domain.WorkorderForm;

/**
 * 工单申请入参
 */
public class WorkorderFormVo {

    // 办理人userId
    private String operatedBy;

    private WorkorderForm form;

    public String getOperatedBy() {
        return operatedBy;
    }

    public void setOperatedBy(String operatedBy) {
        this.operatedBy = operatedBy;
    }

    public WorkorderForm getForm() {
        return form;
    }

    public void setForm(WorkorderForm form) {
        this.form = form;
    }
}