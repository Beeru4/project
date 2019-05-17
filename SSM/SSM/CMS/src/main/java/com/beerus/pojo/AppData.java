package com.beerus.pojo;


/**
 * 查询数据映射类
 */
public class AppData {

    private Integer id;
    private String softwareName;
    private String apkName;
    private double softwareSize;
    private String flatform;
    private String level1Name;
    private String level2Name;
    private String level3Name;
    private String stauts;
    private Integer downloads;
    private String versionNo;
    private Integer stautsId;
    private String categoryName;
    private Integer flatformid;
    private  Integer level1Id ;
    private  Integer level2Id ;
    private  Integer level3Id ;

    public AppData() {
    }

    public Integer getLevel1Id() {
        return level1Id;
    }

    public void setLevel1Id(Integer level1Id) {
        this.level1Id = level1Id;
    }

    public Integer getLevel2Id() {
        return level2Id;
    }

    public void setLevel2Id(Integer level2Id) {
        this.level2Id = level2Id;
    }

    public Integer getLevel3Id() {
        return level3Id;
    }

    public void setLevel3Id(Integer level3Id) {
        this.level3Id = level3Id;
    }

    public Integer getFlatformid() {
        return flatformid;
    }

    public void setFlatformid(Integer flatformid) {
        this.flatformid = flatformid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public Integer getStautsId() {
        return stautsId;
    }

    public void setStautsId(Integer stautsId) {
        this.stautsId = stautsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public double getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(double softwareSize) {
        this.softwareSize = softwareSize;
    }

    public String getFlatform() {
        return flatform;
    }

    public void setFlatform(String flatform) {
        this.flatform = flatform;
    }

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }
}
