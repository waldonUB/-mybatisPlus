package cn.ak.gc.domain.entities;

import cn.ak.gc.commen.annotation.Column;
import cn.ak.gc.commen.annotation.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 社区模块评论信息
 * @author waldon
 * */
@Entity(tableName = "blog_comment", primaryKey = "pk_comment")
public class Comment implements Serializable{
    /**评论主键*/
    private String pk_comment;
    /**话题主键*/
    private String pk_blog;
    /**评论内容*/
    private String cmContent;
    /**评论时间*/
    private Date cmTime;
    /**评论用户*/
    private String userName;
    /**评论用户头像*/
    private String headImg;
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

    public String getPk_comment() {
        return pk_comment;
    }

    public void setPk_comment(String pk_comment) {
        this.pk_comment = pk_comment;
    }

    public String getPk_blog() {
        return pk_blog;
    }

    public void setPk_blog(String pk_blog) {
        this.pk_blog = pk_blog;
    }

    public String getCmContent() {
        return cmContent;
    }

    public void setCmContent(String cmContent) {
        this.cmContent = cmContent;
    }

    public Date getCmTime() {
        return cmTime;
    }

    public void setCmTime(Date cmTime) {
        this.cmTime = cmTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
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
