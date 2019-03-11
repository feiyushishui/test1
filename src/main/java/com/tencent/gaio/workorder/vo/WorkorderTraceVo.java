package com.tencent.gaio.workorder.vo;

import java.util.Date;

public class WorkorderTraceVo {
    private String assignBy;
    private Date assignAt;

    public String getAssignBy() {
        return assignBy;
    }

    public void setAssignBy(String assignBy) {
        this.assignBy = assignBy;
    }

    public Date getAssignAt() {
        return assignAt;
    }

    public void setAssignAt(Date assignAt) {
        this.assignAt = assignAt;
    }
}
