package com.cxp.sbt.bean;

import java.util.Date;

public class SysUserBean {
    private Integer uid;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String registerAddress;

    private Date registerTime;

    private Date loginTime;

    private Date lastLoginTime;

    private String loginCount;

    private String signed;

    private Integer roleid;

    private Integer organizeid;

    private Integer opid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(String loginCount) {
        this.loginCount = loginCount == null ? null : loginCount.trim();
    }

    public String getSigned() {
        return signed;
    }

    public void setSigned(String signed) {
        this.signed = signed == null ? null : signed.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getOrganizeid() {
        return organizeid;
    }

    public void setOrganizeid(Integer organizeid) {
        this.organizeid = organizeid;
    }

    public Integer getOpid() {
        return opid;
    }

    public void setOpid(Integer opid) {
        this.opid = opid;
    }

    public SysUserBean(Integer uid, String username, String password, String email, String phone, String registerAddress, Date registerTime, Date loginTime, Date lastLoginTime, String loginCount, String signed, Integer roleid, Integer organizeid, Integer opid) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.registerAddress = registerAddress;
        this.registerTime = registerTime;
        this.loginTime = loginTime;
        this.lastLoginTime = lastLoginTime;
        this.loginCount = loginCount;
        this.signed = signed;
        this.roleid = roleid;
        this.organizeid = organizeid;
        this.opid = opid;
    }

    public SysUserBean() {
    }
}