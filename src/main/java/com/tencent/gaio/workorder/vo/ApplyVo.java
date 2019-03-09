package com.tencent.gaio.workorder.vo;

import com.tencent.gaio.workorder.entity.CorporatorEntity;
import com.tencent.gaio.workorder.entity.PersonEntity;


/**
 * 申请人
 */
public class ApplyVo {
    // 办理人userId
    private String operatedBy;

    private PersonEntity person;
    private CorporatorEntity corporator;

    public CorporatorEntity getCorporator() {
        return corporator;
    }

    public void setCorporator(CorporatorEntity corporator) {
        this.corporator = corporator;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public String getOperatedBy() {
        return operatedBy;
    }

    public void setOperatedBy(String operatedBy) {
        this.operatedBy = operatedBy;
    }
}
