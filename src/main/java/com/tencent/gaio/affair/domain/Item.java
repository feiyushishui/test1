package com.tencent.gaio.affair.domain;

import java.util.Date;

public class Item {
    //标识
    private Long id;
    //实施编码
    private String taskCode;
    //基本编码
    private String code;
    //名称
    private String name;
    //类型
    private String category;
    //组织机构（实施主体）
    private String orgCode;
    //办理渠道
    private String channel;
    //服务对象
    private String serverCategory;
    //法定办结时限
    private Integer anticipateDay;
    //承诺办结时限
    private Integer promiseDay;
    //需要物流
    private String isExpress;
    //需要收费
    private String isFee;
    //接入状态
    private String acessState;
    //接入时间
    private Date acessTime;

    public Item() {
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getServerCategory() {
        return serverCategory;
    }

    public void setServerCategory(String serverCategory) {
        this.serverCategory = serverCategory;
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

    public String getAcessState() {
        return acessState;
    }

    public void setAcessState(String acessState) {
        this.acessState = acessState;
    }

    public Date getAcessTime() {
        return acessTime;
    }

    public void setAcessTime(Date acessTime) {
        this.acessTime = acessTime;
    }
}
