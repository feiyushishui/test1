package com.tencent.gaio.workorder.vo;

import com.tencent.gaio.affair.domain.Item;
import com.tencent.gaio.workorder.domain.Workorder;

public class WorkorderVO {
    private String operatedBy;
    private Workorder workorder;
    private Item item;
    private ApplyerVo applyer;

    public String getOperatedBy() {
        return operatedBy;
    }

    public void setOperatedBy(String operatedBy) {
        this.operatedBy = operatedBy;
    }

    public Workorder getWorkorder() {
        return workorder;
    }

    public void setWorkorder(Workorder workorder) {
        this.workorder = workorder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ApplyerVo getApplyer() {
        return applyer;
    }

    public void setApplyer(ApplyerVo applyer) {
        this.applyer = applyer;
    }

    @Override
    public String toString() {
        return "WorkorderVO{" +
                "operatedBy='" + operatedBy + '\'' +
                ", workorder=" + workorder +
                ", item=" + item +
                ", applyer=" + applyer +
                '}';
    }
}
