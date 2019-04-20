package com.beerus.entity;


import java.sql.Timestamp;

/**
 * 供应商Bean
 */
public class SmbmsProvider {

  private Integer id;
  private String proCode;
  private String proName;
  private String proDesc;
  private String proContact;
  private String proPhone;
  private String proAddress;
  private String proFax;
  private Integer createBy;
  private Timestamp creationDate;
  private Integer modifyBy;
  private Timestamp modifyDate;

  public SmbmsProvider() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProCode() {
    return proCode;
  }

  public void setProCode(String proCode) {
    this.proCode = proCode;
  }

  public String getProName() {
    return proName;
  }

  public void setProName(String proName) {
    this.proName = proName;
  }

  public String getProDesc() {
    return proDesc;
  }

  public void setProDesc(String proDesc) {
    this.proDesc = proDesc;
  }

  public String getProContact() {
    return proContact;
  }

  public void setProContact(String proContact) {
    this.proContact = proContact;
  }

  public String getProPhone() {
    return proPhone;
  }

  public void setProPhone(String proPhone) {
    this.proPhone = proPhone;
  }

  public String getProAddress() {
    return proAddress;
  }

  public void setProAddress(String proAddress) {
    this.proAddress = proAddress;
  }

  public String getProFax() {
    return proFax;
  }

  public void setProFax(String proFax) {
    this.proFax = proFax;
  }

  public Integer getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Integer createBy) {
    this.createBy = createBy;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  }

  public Integer getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(Integer modifyBy) {
    this.modifyBy = modifyBy;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
  }

  @Override
  public String toString() {
    return "SmbmsProvider{" +
            "id=" + id +
            ", proCode='" + proCode + '\'' +
            ", proName='" + proName + '\'' +
            ", proDesc='" + proDesc + '\'' +
            ", proContact='" + proContact + '\'' +
            ", proPhone='" + proPhone + '\'' +
            ", proAddress='" + proAddress + '\'' +
            ", proFax='" + proFax + '\'' +
            ", createBy=" + createBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            '}';
  }
}
