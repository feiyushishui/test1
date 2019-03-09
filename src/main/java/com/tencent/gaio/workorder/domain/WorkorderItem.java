package com.tencent.gaio.workorder.domain;

public class WorkorderItem {
    /**
     * 事项实施编码
     */
    private String taskCode;
    /**
     * 事项基本编码
     */
    private String code;
    /**
     * 事项名称
     */
    private String name;
    /**
     * 事项类型
     */
    private String category;
    /**
     * 组织机构（实施主体）
     */
    private String orgCode;
    /**
     * 法定办结时限
     */
    private Integer anticipateDay;
    /**
     * 承诺办结时限
     */
    private Integer promiseDay;
    /**
     * 需要物流
     */
    private String isExpress;
    /**
     * 需要收费
     */
    private String isFee;


    public WorkorderItem() {
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getAnticipateDay() {
        return anticipateDay;
    }

    public void setAnticipateDay(Integer anticipateDay) {
        this.anticipateDay = anticipateDay;
    }

    public Integer getPromiseDay() {
        return promiseDay;
    }

    public void setPromiseDay(Integer promiseDay) {
        this.promiseDay = promiseDay;
    }

    public String getIsExpress() {
        return isExpress;
    }

    public void setIsExpress(String isExpress) {
        this.isExpress = isExpress;
    }

    public String getIsFee() {
        return isFee;
    }

    public void setIsFee(String isFee) {
        this.isFee = isFee;
    }

}
