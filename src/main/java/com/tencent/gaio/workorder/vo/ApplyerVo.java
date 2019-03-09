package com.tencent.gaio.workorder.vo;

import com.tencent.gaio.workorder.domain.Corporator;
import com.tencent.gaio.workorder.domain.Person;


/**
 * 申请人
 */
public class ApplyerVo {
    // 办理人userId
    private String operatedBy;

    private Person person;
    private Corporator corporator;

    public ApplyerVo() {
    }

    public Corporator getCorporator() {
        return corporator;
    }

    public void setCorporator(Corporator corporator) {
        this.corporator = corporator;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getOperatedBy() {
        return operatedBy;
    }

    public void setOperatedBy(String operatedBy) {
        this.operatedBy = operatedBy;
    }
}
