package com.tencent.gaio.workorder.entity;

public class CorporatorEntity {

    /**
     * 统一社会信用代码
     */
    private String socialCode;
    /**
     * 企业名称
     */
    private String name;
    /**
     * 企业地址
     */
    private String address;
    /**
     * 法人代表姓名
     */
    private String representName;
    /**
     * 法人代表手机号码
     */
    private String representMobile;
    /**
     * 法人代表证件类型
     */
    private String representCertCategory;
    /**
     * 法人代表证件号码
     */
    private String representCertCode;
    /**
     * 经办人标识
     */
    private Long personId;
    /**
     * 工单标识
     */
    private Long workorderId;

    public CorporatorEntity() {
    }

    public String getSocialCode() {
        return socialCode;
    }

    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRepresentName() {
        return representName;
    }

    public void setRepresentName(String representName) {
        this.representName = representName;
    }

    public String getRepresentMobile() {
        return representMobile;
    }

    public void setRepresentMobile(String representMobile) {
        this.representMobile = representMobile;
    }

    public String getRepresentCertCategory() {
        return representCertCategory;
    }

    public void setRepresentCertCategory(String representCertCategory) {
        this.representCertCategory = representCertCategory;
    }

    public String getRepresentCertCode() {
        return representCertCode;
    }

    public void setRepresentCertCode(String representCertCode) {
        this.representCertCode = representCertCode;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Long workorderId) {
        this.workorderId = workorderId;
    }
}
