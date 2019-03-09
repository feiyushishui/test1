package com.tencent.gaio.workorder.domain;

import java.util.Date;

public class WorkorderTrace {

    /**
     * 节点实例编码
     */
    private String actInstId;
    /**
     * 节点名称
     */
    private String actName;
    /**
     * 状态（0：待办；1：已办；9：回退；）
     */
    private String state;
    /**
     * 被指定人
     */
    private String assignee;
    /**
     * 被指定人部门
     */
    private String assigneeOrg;
    /**
     * 办理人
     */
    private String operator;
    /**
     * 办理人部门
     */
    private String operatorOrg;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 办件信息id
     */
    private Long workorderId;

    public WorkorderTrace() {
    }

    public String getActInstId() {
        return actInstId;
    }

    public void setActInstId(String actInstId) {
        this.actInstId = actInstId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssigneeOrg() {
        return assigneeOrg;
    }

    public void setAssigneeOrg(String assigneeOrg) {
        this.assigneeOrg = assigneeOrg;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorOrg() {
        return operatorOrg;
    }

    public void setOperatorOrg(String operatorOrg) {
        this.operatorOrg = operatorOrg;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Long workorderId) {
        this.workorderId = workorderId;
    }
}
