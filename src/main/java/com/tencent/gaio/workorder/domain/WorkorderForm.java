package com.tencent.gaio.workorder.domain;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tencent.gaio.commons.entity.AbstractAuditingEntity;


public class WorkorderForm extends AbstractAuditingEntity {
    /**
     * 表单数据
     */
    private JSONObject content;
    /**
     * 工单标识
     */
    @JsonIgnore
    private Long workorderId;

    public JSONObject getContent() {
        return content;
    }

    public void setContent(JSONObject content) {
        this.content = content;
    }

    public Long getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Long workorderId) {
        this.workorderId = workorderId;
    }
}
