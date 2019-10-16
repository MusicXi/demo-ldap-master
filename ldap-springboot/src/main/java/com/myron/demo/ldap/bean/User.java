package com.myron.demo.ldap.bean;

import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

/**
 * @author linrx1
 * @date 2019/9/19.
 */
@Entry(objectClasses = { "person", "top",  "user" }, base = "DC=myron,DC=com")
public class User {
    @Id
    private Name dn;
    //邮箱
    private String mail;
    //登录名
    private String sAMAccountName;
    //工号
    private String description;
    //工作地
    private String physicalDeliveryOfficeName;
    //组织架构 字符串如下（CN=XXX,OU=xx组,OU=xx研发部,OU=xx中心,OU=xx事业部,OU=xx科技公司,DC=myron,DC=com）
    private String distinguishedName;
    //显示名称
    private String displayName;
    //姓
    private String sn;
    //名
    private String givenName;

    public Name getDn() {
        return dn;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getsAMAccountName() {
        return sAMAccountName;
    }

    public void setsAMAccountName(String sAMAccountName) {
        this.sAMAccountName = sAMAccountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhysicalDeliveryOfficeName() {
        return physicalDeliveryOfficeName;
    }

    public void setPhysicalDeliveryOfficeName(String physicalDeliveryOfficeName) {
        this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
    }

    public String getDistinguishedName() {
        return distinguishedName;
    }

    public void setDistinguishedName(String distinguishedName) {
        this.distinguishedName = distinguishedName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Override
    public String toString() {
        return "User{" +
                "mail='" + mail + '\'' +
                ", sAMAccountName='" + sAMAccountName + '\'' +
                ", description='" + description + '\'' +
                ", physicalDeliveryOfficeName='" + physicalDeliveryOfficeName + '\'' +
                ", distinguishedName='" + distinguishedName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", sn='" + sn + '\'' +
                ", givenName='" + givenName + '\'' +
                '}';
    }
}
