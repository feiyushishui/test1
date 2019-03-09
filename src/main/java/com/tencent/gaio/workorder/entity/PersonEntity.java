package com.tencent.gaio.workorder.entity;

public class PersonEntity {
    /**
     * 姓名
     */
    private String name;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 固定电话
     */
    private String contactNo;
    /**
     * 证件类型
     */
    private String certCategory;
    /**
     * 证件号码
     */
    private String certCode;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 工单标识
     */
    private Long workorderId;

    public PersonEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCertCategory() {
        return certCategory;
    }

    public void setCertCategory(String certCategory) {
        this.certCategory = certCategory;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Long workorderId) {
        this.workorderId = workorderId;
    }
}
