package cn.ak.gc.domain.entities;

import cn.ak.gc.commen.annotation.Column;
import cn.ak.gc.commen.annotation.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * 用户信息
 * @author waldon
 */
@Entity(tableName = "sys_user", primaryKey = "user_id")
public class UserInfo implements Serializable {

    /**用户主键*/
    @Column(column = "user_id")
    private String userId;
    /**用户名*/
    @Column(column = "user_name")
    private String userName;
    /**密码*/
    @Column(column = "password")
    private String password;
    /**生效状态*/
    @Column(column = "status")
    private int status;
    /**用户类型*/
    @Column(column = "user_type")
    private int userType;
    /**用户头像base64*/
    @Column(column = "head_img")
    private String headImg;
    /**最近登录时间*/
    @Column(column = "last_time")
    private Date lastTime;
    /**所属地区*/
    @Column(column = "district")
    private String district;
    /**ip地址*/
    @Column(column = "ip")
    private String ip;
    /**ip归属地*/
    @Column(column = "ip_area")
    private String ipArea;
    /**用户组*/
    @Column(column = "group_code")
    private String groupCode;
    /**创建人*/
    @Column(column = "creator")
    private String creator;
    /**创建时间*/
    @Column(column = "creation_time")
    private Date creationTime;
    /**修改人*/
    @Column(column = "modifier")
    private String modifier;
    /**修改时间*/
    @Column(column = "modify_time")
    private Date modifyTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpArea() {
        return ipArea;
    }

    public void setIpArea(String ipArea) {
        this.ipArea = ipArea;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }


    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}

