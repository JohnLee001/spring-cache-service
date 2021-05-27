package com.example.test.model;

import java.io.Serializable;
import java.util.Date;


public class ProdClass implements Serializable {

    /**
     * 产品分类ID
     */
    private String prodClassId;

    /**
     * 产品分类编码
     */
    private String prodClassCode;

    /**
     * 产品分类名称
     */
    private String prodClassName;

    /**
     * 产品分类等级
     */
    private Integer prodClassLevel;

    /**
     * 产品分类父级ID
     */
    private String parentClassId;

    /**
     * 产品分类父级编码
     */
    private String parentCode;

    /**
     * 组织机构ID
     */
    private String orgId;

    /**
     * 有效标识
     */
    private String validFlag;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date modifyTime;

    public String getProdClassId() {
        return prodClassId;
    }

    public void setProdClassId(String prodClassId) {
        this.prodClassId = prodClassId;
    }
    public String getProdClassCode() {
        return prodClassCode;
    }

    public void setProdClassCode(String prodClassCode) {
        this.prodClassCode = prodClassCode;
    }
    public String getProdClassName() {
        return prodClassName;
    }

    public void setProdClassName(String prodClassName) {
        this.prodClassName = prodClassName;
    }
    public Integer getProdClassLevel() {
        return prodClassLevel;
    }

    public void setProdClassLevel(Integer prodClassLevel) {
        this.prodClassLevel = prodClassLevel;
    }
    public String getParentClassId() {
        return parentClassId;
    }

    public void setParentClassId(String parentClassId) {
        this.parentClassId = parentClassId;
    }
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "ProdClass{" +
                "prodClassId=" + prodClassId +
                ", prodClassCode=" + prodClassCode +
                ", prodClassName=" + prodClassName +
                ", prodClassLevel=" + prodClassLevel +
                ", parentClassId=" + parentClassId +
                ", parentCode=" + parentCode +
                ", orgId=" + orgId +
                ", validFlag=" + validFlag +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", modifier=" + modifier +
                ", modifyTime=" + modifyTime +
                "}";
    }
}
