package com.demo.modules.bussiness.entity;

import java.io.Serializable;

/**
 * 在建工地/工地总数(ApiBuildingWebsite)实体类
 *
 * @author zhangweiwei
 * @since 2020-09-29 20:21:14
 */
public class ApiBuildingWebsite implements Serializable {
    private static final long serialVersionUID = 601008659335363803L;

    private Integer id;
    /**
     * 项目总数
     */
    private String totalcount;
    /**
     * 在建
     */
    private String stopname;
    /**
     * 百度地图x
     */
    private String baidumapx;
    /**
     * 百度地图y
     */
    private String baidumapy;
    /**
     * 是否停止
     */
    private String isstop;
    /**
     * 在建项目
     */
    private Integer buildingnum;
    /**
     * 项目名称
     */
    private String projname;
    /**
     * 环保项目名称（如果这个字段不为空，表示这个项目用的扬尘的设备）
     */
    private String hbprojectname;
    /**
     * 地址
     */
    private String projectaddress;
    /**
     * 监管行政区
     */
    private String areaname;
    /**
     * 建设单位联系电话
     */
    private String contractorcontactphone;
    /**
     * 建设单位
     */
    private String contractor;
    /**
     * 建设单位联系人
     */
    private String contractorcontact;
    /**
     * 施工单位
     */
    private String buildname;
    /**
     * 项目联系人
     */
    private String pmanager;
    /**
     * 项目联系电话
     */
    private String pmanagertel;
    /**
     * 监理单位
     */
    private String supervise;
    /**
     * 监理单位联系人
     */
    private String supervisecontact;
    /**
     * 监理单位联系电话
     */
    private String supervisecontactphone;
    /**
     * 扬尘设备（建筑工地）、雾炮设备（建筑工地（无扬尘监测设备））
     */
    private String hbtype;
    /**
     * 项目编号
     */
    private String projcode;

    private String createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public String getStopname() {
        return stopname;
    }

    public void setStopname(String stopname) {
        this.stopname = stopname;
    }

    public String getBaidumapx() {
        return baidumapx;
    }

    public void setBaidumapx(String baidumapx) {
        this.baidumapx = baidumapx;
    }

    public String getBaidumapy() {
        return baidumapy;
    }

    public void setBaidumapy(String baidumapy) {
        this.baidumapy = baidumapy;
    }

    public String getIsstop() {
        return isstop;
    }

    public void setIsstop(String isstop) {
        this.isstop = isstop;
    }

    public Integer getBuildingnum() {
        return buildingnum;
    }

    public void setBuildingnum(Integer buildingnum) {
        this.buildingnum = buildingnum;
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    public String getHbprojectname() {
        return hbprojectname;
    }

    public void setHbprojectname(String hbprojectname) {
        this.hbprojectname = hbprojectname;
    }

    public String getProjectaddress() {
        return projectaddress;
    }

    public void setProjectaddress(String projectaddress) {
        this.projectaddress = projectaddress;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getContractorcontactphone() {
        return contractorcontactphone;
    }

    public void setContractorcontactphone(String contractorcontactphone) {
        this.contractorcontactphone = contractorcontactphone;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getContractorcontact() {
        return contractorcontact;
    }

    public void setContractorcontact(String contractorcontact) {
        this.contractorcontact = contractorcontact;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public String getPmanager() {
        return pmanager;
    }

    public void setPmanager(String pmanager) {
        this.pmanager = pmanager;
    }

    public String getPmanagertel() {
        return pmanagertel;
    }

    public void setPmanagertel(String pmanagertel) {
        this.pmanagertel = pmanagertel;
    }

    public String getSupervise() {
        return supervise;
    }

    public void setSupervise(String supervise) {
        this.supervise = supervise;
    }

    public String getSupervisecontact() {
        return supervisecontact;
    }

    public void setSupervisecontact(String supervisecontact) {
        this.supervisecontact = supervisecontact;
    }

    public String getSupervisecontactphone() {
        return supervisecontactphone;
    }

    public void setSupervisecontactphone(String supervisecontactphone) {
        this.supervisecontactphone = supervisecontactphone;
    }

    public String getHbtype() {
        return hbtype;
    }

    public void setHbtype(String hbtype) {
        this.hbtype = hbtype;
    }

    public String getProjcode() {
        return projcode;
    }

    public void setProjcode(String projcode) {
        this.projcode = projcode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}