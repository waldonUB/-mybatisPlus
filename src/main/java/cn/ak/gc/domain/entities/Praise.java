package cn.ak.gc.domain.entities;

import cn.ak.gc.commen.annotation.Column;
import cn.ak.gc.commen.annotation.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 社区模块点赞信息
 * @author waldon
 * */
@Entity(tableName = "blog_praise", primaryKey = "pk_praise")
public class Praise implements Serializable{
    /**点赞主键*/
    private String pk_praise;
    /**话题主键*/
    private String pk_blog;
    /**点赞用户*/
    private String userName;
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

    public String getPk_praise() {
        return pk_praise;
    }

    public void setPk_praise(String pk_praise) {
        this.pk_praise = pk_praise;
    }

    public String getPk_blog() {
        return pk_blog;
    }

    public void setPk_blog(String pk_blog) {
        this.pk_blog = pk_blog;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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
}
